package com.acme.homehealthy.Social.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Social.domain.model.Review;
import com.acme.homehealthy.Social.domain.model.Score;
import com.acme.homehealthy.Social.domain.repository.ReviewRepository;
import com.acme.homehealthy.Social.domain.repository.ScoreRepository;
import com.acme.homehealthy.Social.domain.service.ReviewService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Page<Review> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Review getReviewByCustomerAndCollaborator(Long customerId, Long collaboratorId) {
        return reviewRepository.findReviewByCustomer_IdAndCollaborator_Id(customerId,collaboratorId).orElseThrow(()-> new ResourceNotFoundException("Customer and Collaborator","Id", customerId + collaboratorId));
    }

    @Override
    public Review createReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest) {
        Review existingReview = reviewRepository.findReviewByCustomer_IdAndCollaborator_Id(customerId,collaboratorId).orElse(null);
        if(existingReview != null){
            throw new ResourceNotFoundException("You conducted a survey with this contributor.");
        }
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerId));
        Collaborator collaborator = collaboratorRepository.findById(collaboratorId).orElseThrow(()->new ResourceNotFoundException("Collaborator","Id",collaboratorId));
        Score score = scoreRepository.findById(scoreId).orElseThrow(()->new ResourceNotFoundException("Score","Id",scoreId));

        reviewRequest.setCustomer(customer);
        reviewRequest.setCollaborator(collaborator);
        reviewRequest.setScore(score);
        return reviewRepository.save(reviewRequest);

    }

    @Override
    public Review updateReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest) {
        Review existingReview = reviewRepository.findReviewByCustomer_IdAndCollaborator_Id(customerId,collaboratorId).orElseThrow(()-> new ResourceNotFoundException("Customer and Collaborator","Id", customerId + collaboratorId));
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerId));
        Collaborator collaborator = collaboratorRepository.findById(collaboratorId).orElseThrow(()->new ResourceNotFoundException("Collaborator","Id",collaboratorId));
        Score score = scoreRepository.findById(scoreId).orElseThrow(()->new ResourceNotFoundException("Score","Id",scoreId));

        return reviewRepository.save(existingReview.setCollaborator(collaborator)
        .setCustomer(customer)
        .setDescription(reviewRequest.getDescription())
        .setScore(score));
    }

    @Override
    public ResponseEntity<?> deleteReview(Long customerId, Long collaboratorId) {
        Review existingReview = reviewRepository.findReviewByCustomer_IdAndCollaborator_Id(customerId,collaboratorId).orElseThrow(()-> new ResourceNotFoundException("Customer and Collaborator","Id", customerId + collaboratorId));
        reviewRepository.delete(existingReview);
        return ResponseEntity.ok().build();
    }
}
