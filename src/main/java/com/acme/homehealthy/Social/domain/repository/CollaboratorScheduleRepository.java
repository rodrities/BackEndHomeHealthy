package com.acme.homehealthy.Social.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Social.domain.model.CollaboratorSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CollaboratorScheduleRepository extends JpaRepository<CollaboratorSchedule, Long> {
    Page<CollaboratorSchedule> findByCollaboratorId(Long collaboratorId, Pageable pageable);
    Optional<CollaboratorSchedule> findByIdAndCollaboratorId(Long id, Long collaboratorId);
}
