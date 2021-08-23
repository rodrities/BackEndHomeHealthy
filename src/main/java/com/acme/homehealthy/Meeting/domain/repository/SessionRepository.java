package com.acme.homehealthy.Meeting.domain.repository;

import com.acme.homehealthy.Meeting.domain.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Page<Session> findByCustomerId(Long userId, Pageable pageable);
    Page<Session> findByCollaboratorId(Long collaboratorId, Pageable pageable);
    Optional<Session> findByIdAndCustomerId(Long id, Long userId);

}
