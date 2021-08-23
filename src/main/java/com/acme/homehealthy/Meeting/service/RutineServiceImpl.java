package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.repository.RutineRepository;
import com.acme.homehealthy.Meeting.domain.service.RutineService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RutineServiceImpl implements RutineService {
    @Autowired
    private RutineRepository rutineRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public Page<Rutine> getAllRutinesByUserId(Long userId, Pageable pageable) {
        return rutineRepository.findRutineByCustomerId(userId, pageable);
    }

    @Override
    public Page<Rutine> getAllRutinesByCollaboratorId(Long collaboratorId, Pageable pageable) {
        return rutineRepository.findRutineByCollaboratorId(collaboratorId, pageable);
    }

    @Override
    public Page<Rutine> getAllRutines(Pageable pageable) {
        return rutineRepository.findAll(pageable);
    }

    @Override
    public Rutine getRutineById(Long id) {
        return rutineRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Rutine","Id",id));
    }

    @Override
    public Rutine createRutine(Long customerId, Long collaboratorId, Rutine rutine) {
        Collaborator existingCollaborator =
                collaboratorRepository.findById(collaboratorId)
                        .orElseThrow(()-> new ResourceNotFoundException("Collaborator","Id",collaboratorId));
        Customer existingCustomer =
                customerRepository.findById(customerId).
                        orElseThrow(() -> new ResourceNotFoundException("Customer","Id",customerId));
        rutine.setCustomer(existingCustomer);
        rutine.setCollaborator(existingCollaborator);
        return rutineRepository.save(rutine);
    }

    @Override
    public Rutine updateRutine(Long id, Rutine rutine, Long sessionId) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteRutine(String name) {
        Rutine rutine = rutineRepository.findRutineByname(name).orElseThrow(()->new ResourceNotFoundException("Rutine","name",name));
        rutineRepository.delete(rutine);
        return ResponseEntity.ok().build();
    }
}
