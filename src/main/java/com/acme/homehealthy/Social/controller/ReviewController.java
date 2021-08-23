package com.acme.homehealthy.Social.controller;

import com.acme.homehealthy.Social.domain.model.Review;
import com.acme.homehealthy.Social.domain.service.ReviewService;
import com.acme.homehealthy.Social.resource.ReviewResource;
import com.acme.homehealthy.Social.resource.SaveReviewResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Review",description = "Social API")
@RestController
@RequestMapping("api/")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/reviews")
    public Page<ReviewResource> getAllReview(Pageable pageable){
        Page<Review> reviews = reviewService.getAllReviews(pageable);
        List<ReviewResource> resources = reviews.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/reviews/{customerId}/{collaboratorId}")
    public ReviewResource getReviewByCustomerAndCollaborator(@Valid @PathVariable(name = "customerId") Long customerId,
                                                             @Valid @PathVariable(name = "collaboratorId") Long collaborator){
        return convertToResource(reviewService.getReviewByCustomerAndCollaborator(customerId,collaborator));
    }

    @PostMapping("/reviews/{customerId}/{collaboratorId}/{scoreId}")
    public ReviewResource createReview(@Valid @PathVariable(name = "customerId") Long customerId,
                                       @Valid @PathVariable(name = "collaboratorId") Long collaborator,
                                       @Valid @PathVariable(name = "scoreId") Long scoredId,
                                       @Valid @RequestBody SaveReviewResource resource){
        Review review = convertToEntity(resource);
        return convertToResource(reviewService.createReview(customerId,collaborator,scoredId,review));
    }
    //Review updateReview(Long customerId, Long collaboratorId, Long scoreId, Review reviewRequest);
    @PutMapping("/reviews/{customerId}/{collaboratorId}/{scoreId}")
    public ReviewResource updateReview(@Valid @PathVariable(name = "customerId") Long customerId,
                                       @Valid @PathVariable(name = "collaboratorId") Long collaborator,
                                       @Valid @PathVariable(name = "scoreId") Long scoredId,
                                       @Valid @RequestBody SaveReviewResource resource){
        Review review = convertToEntity(resource);
        return convertToResource(reviewService.updateReview(customerId,collaborator,scoredId,review));
    }

    @DeleteMapping("/reviews/{customerId}/{collaboratorId}")
    public ResponseEntity<?> updateReview(@Valid @PathVariable(name = "customerId") Long customerId,
                                       @Valid @PathVariable(name = "collaboratorId") Long collaboratorId){
        reviewService.deleteReview(customerId,collaboratorId);
        return ResponseEntity.ok().build();
    }

    private Review convertToEntity(SaveReviewResource resource){return mapper.map(resource,Review.class);}
    private ReviewResource convertToResource(Review review){return mapper.map(review,ReviewResource.class);}
}
