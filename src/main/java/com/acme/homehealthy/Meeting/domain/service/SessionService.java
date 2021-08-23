package com.acme.homehealthy.Meeting.domain.service;

import com.acme.homehealthy.Meeting.domain.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SessionService {

    Page<Session> getAllSessionsByUserId(Long userId, Pageable pageable);
    Page<Session> getAllSessionsByCollaboratorId(Long collaboratorId, Pageable pageable);

    Session getSessionByIdAndUserId(Long userId, Long sessionId);

    Session createSession(Long userId, Long collaboratorId, Session session);

    Session updateSession(Long userId, Long sessionId, Session sessionDetails);

    ResponseEntity<?> deleteSession(Long userId, Long sessionId);
}