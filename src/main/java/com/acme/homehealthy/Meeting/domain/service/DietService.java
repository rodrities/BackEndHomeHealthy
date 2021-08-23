package com.acme.homehealthy.Meeting.domain.service;



import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Social.domain.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface DietService {

    Page<Diet> getAllDietsByUserId(Long userId, Pageable pageable);
    Page<Diet> getAllDietsByCollaboratorId(Long collaboratorId, Pageable pageable);

    Page<Diet> getAllDiets(Pageable pageable);

    Diet getDietById(Long id);

    Diet createDiet( Long customerId, Long collaboratorId, Diet diet);

    Diet updateDiet(Long dietId, Diet diet, Long sessionId);

    //Diet getDietBySessionId(Long id);

    ResponseEntity<?> deleteDiet(String name);
}
