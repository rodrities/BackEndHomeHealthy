package com.acme.homehealthy.Initialization.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Initialization.domain.service.CollaboratorService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public Page<Collaborator> getAllCollaborators(Pageable pageable) {
        return collaboratorRepository.findAll(pageable);
    }

    @Override
    public Collaborator getCollaboratorById(Long collaboratorId) {
        return collaboratorRepository.findById(collaboratorId).orElseThrow(()->new ResourceNotFoundException("Collaborator","Id",collaboratorId));
    }

    @Override
    public Collaborator createCollaborator(Collaborator collaborator) {
        Collaborator existingUsername =
                collaboratorRepository.findCollaboratorByUsername(collaborator.getUsername())
                        .orElse(null);
        if(existingUsername != null){
            throw new ResourceNotFoundException
                    ("The username " + existingUsername.getUsername() + " is begin used by another user");
        }
        Collaborator existingEmail =
                collaboratorRepository.findCollaboratorByEmail(collaborator.getEmail())
                        .orElse(null);
        if(existingEmail != null){
            throw new ResourceNotFoundException
                    ("The email " + existingUsername.getEmail() + " is begin used by another user");
        }
        return collaboratorRepository.save(collaborator);
    }

    @Override
    public Collaborator updateCollaborator(Long id, Collaborator collaborator) {
        Collaborator _collaborator = collaboratorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Collaborator","Id",id));
        if(_collaborator.getEmail() != collaborator.getEmail()) {
            Collaborator existingEmail = collaboratorRepository.findCollaboratorByEmail(collaborator.getEmail()).orElse(null);
            if (existingEmail == null) {
                throw new ResourceNotFoundException("This email is being used by another user");
            }
        }
        return collaboratorRepository.save(
                _collaborator.setAddress(collaborator.getAddress())
                .setEmail(collaborator.getEmail())
                .setLastname(collaborator.getLastname())
                .setAddress(collaborator.getAddress())
                .setName(collaborator.getName())
                .setPassword(collaborator.getPassword())
                .setPhone(collaborator.getPhone())
        );
    }

    @Override
    public Collaborator getCollaboratorByUsernameAndPassword(String username, String password) {
        return collaboratorRepository.findCollaboratorByUsernameAndEmail(username,password)
                .orElseThrow(()->new ResourceNotFoundException
                        ("Customer","Username or Pasword", username + " " + password));
    }

    @Override
    public ResponseEntity<?> deleteCollaborator(String username) {
        Collaborator _collaborator = collaboratorRepository.findCollaboratorByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("Collaborator","Username",username));
        collaboratorRepository.delete(_collaborator);
        return ResponseEntity.ok().build();
    }
}
