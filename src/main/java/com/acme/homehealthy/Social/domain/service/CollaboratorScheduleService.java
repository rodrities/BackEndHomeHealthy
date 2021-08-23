package com.acme.homehealthy.Social.domain.service;

import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Social.domain.model.CollaboratorSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CollaboratorScheduleService {
    Page<CollaboratorSchedule> getAllCollaboratorSchedulesByCollaboratorId(Long collaboratorId, Pageable pageable);

    CollaboratorSchedule getCollaboratorScheduleByIdAndCollaboratorId(Long collaboratorId, Long id);

    CollaboratorSchedule createCollaboratorSchedule( Long collaboratorId, CollaboratorSchedule collaboratorSchedule);

    CollaboratorSchedule updateCollaboratorSchedule(Long collaboratorId, Long id, Session sessionDetails);

    ResponseEntity<?> deleteCollaboratorSchedule(Long collaboratorId, Long id);
}
