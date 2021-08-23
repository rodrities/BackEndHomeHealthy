package com.acme.homehealthy.Initialization.domain.repository;


import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollaboratorRepository extends JpaRepository<Collaborator,Long> {
    Optional<Collaborator> findCollaboratorByEmail(String email);
    Optional<Collaborator> findCollaboratorByUsername(String username);
    Optional<Collaborator> findCollaboratorByUsernameAndEmail(String username, String password);
}
