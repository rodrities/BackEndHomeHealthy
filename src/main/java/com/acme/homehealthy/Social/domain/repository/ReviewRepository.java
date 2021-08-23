package com.acme.homehealthy.Social.domain.repository;

import com.acme.homehealthy.Social.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findReviewByCustomer_IdAndCollaborator_Id(Long customerId, Long collaboratorId);
}
