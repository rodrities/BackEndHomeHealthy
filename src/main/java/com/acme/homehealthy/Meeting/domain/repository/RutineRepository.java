package com.acme.homehealthy.Meeting.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RutineRepository extends JpaRepository<Rutine,Long> {
    Page<Rutine> findRutineByCustomerId(Long customerId, Pageable pageable);
    Page<Rutine> findRutineByCollaboratorId(Long collaboratorId, Pageable pageable);
    Optional<Rutine>findRutineByname(String name);
    //Optional<Rutine>findDietBySession_Id(Long id);
}