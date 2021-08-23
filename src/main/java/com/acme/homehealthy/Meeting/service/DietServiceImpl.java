package com.acme.homehealthy.Meeting.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.repository.SessionRepository;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Meeting.domain.service.DietService;
import com.acme.homehealthy.Social.domain.model.Review;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DietServiceImpl implements  DietService {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public Diet getDietById(Long id) {
        return dietRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Diet","Id",id));
    }

    @Override
    public Diet createDiet(Long customerId, Long collaboratorId, Diet diet) {
        Collaborator existingCollaborator =
                collaboratorRepository.findById(collaboratorId)
                        .orElseThrow(()-> new ResourceNotFoundException("Collaborator","Id",collaboratorId));
        Customer existingCustomer =
                customerRepository.findById(customerId).
                        orElseThrow(() -> new ResourceNotFoundException("Customer","Id",customerId));
        diet.setCustomer(existingCustomer);
        diet.setCollaborator(existingCollaborator);
        return dietRepository.save(diet);
        /*
        Diet existingDiet = dietRepository.findDietByname(diet.getName()).orElse(null);
        Session existingSession = sessionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Session","Id",id));

        diet.setSession(existingSession);
        if(existingDiet != null){
            throw new ResourceNotFoundException("This diet name is begin used");
        }

        return dietRepository.save(diet);*/
    }
    @Override
    public Diet updateDiet(Long id, Diet diet, Long sessionId) {

        return null;
        /*
        Diet existingDiet = dietRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Diet","Id",id));
        Session existingSession = sessionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Session","Id",id));
        return dietRepository.save(
              existingDiet.setName(diet.getName()).setDescription(diet.getDescription()).setDuration(diet.getDuration()).setSession(existingSession)
        );*/
    }

    @Override
    public ResponseEntity<?> deleteDiet(String name) {
        Diet diet = dietRepository.findDietByname(name).orElseThrow(()->new ResourceNotFoundException("Diet","name",name));
        dietRepository.delete(diet);
        return ResponseEntity.ok().build();
    }

    @Override
    public Page<Diet> getAllDietsByUserId(Long customerId, Pageable pageable) {
        return dietRepository.findDietByCustomerId(customerId, pageable);
    }

    @Override
    public Page<Diet> getAllDietsByCollaboratorId(Long collaboratorId, Pageable pageable) {
        return dietRepository.findDietByCollaboratorId(collaboratorId, pageable);
    }

    @Override
    public Page<Diet> getAllDiets(Pageable pageable) {
        return dietRepository.findAll(pageable);
    }

}
