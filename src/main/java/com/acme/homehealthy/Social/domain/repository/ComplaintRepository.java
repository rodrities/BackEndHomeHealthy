package com.acme.homehealthy.Social.domain.repository;

import com.acme.homehealthy.Social.domain.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
