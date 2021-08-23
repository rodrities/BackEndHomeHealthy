package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Meeting.domain.repository.SessionRepository;
import com.acme.homehealthy.Meeting.domain.service.SessionService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private CustomerRepository userRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public Page<Session> getAllSessionsByUserId(Long customerId, Pageable pageable) {
        return sessionRepository.findByCustomerId(customerId, pageable);
    }
    @Override
    public Page<Session> getAllSessionsByCollaboratorId(Long collaboratorId, Pageable pageable) {
        return sessionRepository.findByCollaboratorId(collaboratorId, pageable);
    }

    @Override
    public Session getSessionByIdAndUserId(Long customerId, Long sessionId) {
        return sessionRepository.findByIdAndCustomerId(sessionId, customerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Session not found with Id " + sessionId +
                                " and CustomerId " + customerId));
    }

    @Override
    public Session createSession(Long customerId, Long collaboratorId, Session session) {
        Collaborator existingCollaborator =
                collaboratorRepository.findById(collaboratorId)
                        .orElseThrow(()-> new ResourceNotFoundException("Collaborator","Id",collaboratorId));
        Customer existingCustomer =
                userRepository.findById(customerId).
                        orElseThrow(() -> new ResourceNotFoundException("Customer","Id",customerId));
        session.setCustomer(existingCustomer);
        session.setCollaborator(existingCollaborator);
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Long customerId, Long sessionId, Session sessionDetails) {
        if (!userRepository.existsById(customerId))
            throw new ResourceNotFoundException("User", "Id", customerId);
        return sessionRepository.findById(sessionId).map(comment -> {
            comment.setLink(sessionDetails.getLink());
            return sessionRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Session", "Id", sessionId));
    }

    @Override
    public ResponseEntity<?> deleteSession(Long customerId, Long sessionId) {
        return sessionRepository.findByIdAndCustomerId(sessionId, customerId).map(comment -> {
            sessionRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Session not found with Id " + sessionId + " and UserId " + customerId));
    }
}
