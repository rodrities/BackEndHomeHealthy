package com.acme.homehealthy.Meeting.domain.service;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface RutineService {
    Page<Rutine> getAllRutinesByUserId(Long userId, Pageable pageable);
    Page<Rutine> getAllRutinesByCollaboratorId(Long collaboratorId, Pageable pageable);

    Page<Rutine> getAllRutines(Pageable pageable);

    Rutine getRutineById(Long id);

    Rutine createRutine( Long customerId, Long collaboratorId, Rutine rutine);

    Rutine updateRutine(Long id, Rutine rutine, Long sessionId);

    //Diet getDietBySessionId(Long id);

    ResponseEntity<?> deleteRutine(String name);
}
