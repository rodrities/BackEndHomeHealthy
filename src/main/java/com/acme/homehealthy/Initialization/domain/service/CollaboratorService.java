package com.acme.homehealthy.Initialization.domain.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CollaboratorService {
    Page<Collaborator> getAllCollaborators(Pageable pageable);
    Collaborator getCollaboratorById(Long id);
    Collaborator createCollaborator(Collaborator collaborator);
    Collaborator updateCollaborator(Long id, Collaborator collaborator);
    Collaborator getCollaboratorByUsernameAndPassword(String username, String password);
    ResponseEntity<?> deleteCollaborator(String username);
}
