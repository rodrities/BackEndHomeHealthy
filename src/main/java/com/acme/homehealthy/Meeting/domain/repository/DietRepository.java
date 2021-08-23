package com.acme.homehealthy.Meeting.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DietRepository extends JpaRepository<Diet,Long> {
    Page<Diet> findDietByCustomerId(Long customerId, Pageable pageable);
    Page<Diet> findDietByCollaboratorId(Long collaboratorId, Pageable pageable);
    Optional<Diet>findDietByname(String name);
    //Optional<Diet>findDietBySession_Id(Long id);
}

