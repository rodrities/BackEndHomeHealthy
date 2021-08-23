package com.acme.homehealthy.Social.service;


import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Social.domain.model.CollaboratorSchedule;
import com.acme.homehealthy.Social.domain.repository.CollaboratorScheduleRepository;
import com.acme.homehealthy.Social.domain.service.CollaboratorScheduleService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorScheduleServiceImpl implements CollaboratorScheduleService {

    @Autowired
    private CollaboratorScheduleRepository collaboratorScheduleRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public Page<CollaboratorSchedule> getAllCollaboratorSchedulesByCollaboratorId(Long collaboratorId, Pageable pageable) {
        return collaboratorScheduleRepository.findByCollaboratorId(collaboratorId, pageable);
    }

    @Override
    public CollaboratorSchedule getCollaboratorScheduleByIdAndCollaboratorId(Long collaboratorId, Long id) {
        return collaboratorScheduleRepository.findByIdAndCollaboratorId(id, collaboratorId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Session not found with Id " + id +
                                " and CustomerId " + collaboratorId));
    }

    @Override
    public CollaboratorSchedule createCollaboratorSchedule(Long collaboratorId, CollaboratorSchedule collaboratorSchedule) {
        Collaborator existingCollaborator =
                collaboratorRepository.findById(collaboratorId)
                        .orElseThrow(()-> new ResourceNotFoundException("Collaborator","Id",collaboratorId));
        collaboratorSchedule.setCollaborator(existingCollaborator);
        return collaboratorScheduleRepository.save(collaboratorSchedule);
    }

    @Override
    public CollaboratorSchedule updateCollaboratorSchedule(Long collaboratorId, Long id, Session sessionDetails) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCollaboratorSchedule(Long collaboratorId, Long id) {
        return collaboratorScheduleRepository.findByIdAndCollaboratorId(id, collaboratorId).map(comment -> {
            collaboratorScheduleRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Session not found with Id " + id + " and CollaboratorId " + collaboratorId));
    }
}
