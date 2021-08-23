package com.acme.homehealthy.Social.domain.service;

import com.acme.homehealthy.Social.domain.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReviewService {
    Page<Review> getAllReviews(Pageable pageable);
    Review getReviewByCustomerAndCollaborator(Long customerId, Long collaboratorId);
    Review createReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest);
    Review updateReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest);
    ResponseEntity<?> deleteReview(Long customerId, Long collaboratorId);
}
