package com.acme.homehealthy.Social.domain.repository;

import com.acme.homehealthy.Social.domain.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReasonRepository extends JpaRepository<Reason, Long> {
    Optional<Reason> findReasonByDescription(String description);
}
