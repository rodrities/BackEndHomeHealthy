package com.acme.homehealthy.Meeting.controller;

import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Meeting.domain.service.SessionService;
import com.acme.homehealthy.Meeting.resource.SaveSessionResource;
import com.acme.homehealthy.Meeting.resource.SessionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Sessions", description = "Sessions API")
@RestController
@RequestMapping("/api")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Find sessions by customer Id")
    @GetMapping("/customers/{customerId}/sessions")
    public Page<SessionResource> getAllSessionsByUserId(
            @PathVariable(value = "customerId") Long customerId,
            Pageable pageable) {
        Page<Session> commentPage = sessionService.getAllSessionsByUserId(customerId, pageable);
        List<SessionResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find sessions by collaborator Id")
    @GetMapping("/collaborators/{collaboratorId}/sessions")
    public Page<SessionResource> getAllSessionsByCollaboratorId(
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            Pageable pageable) {
        Page<Session> commentPage = sessionService.getAllSessionsByCollaboratorId(collaboratorId, pageable);
        List<SessionResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find session by customer Id and collaborator Id")
    @GetMapping("/customers/{customerId}/sessions/{sessionId}")
    public SessionResource getSessionByIdAndUser(
            @PathVariable(name = "customerId") Long customerId,
            @PathVariable(name = "sessionId") Long sessionId) {
        return convertToResource(sessionService.getSessionByIdAndUserId(customerId, sessionId));
    }

    @Operation(summary = "Create a session")
    @PostMapping("/customers/{customerId}/{collaboratorId}/sessions")
    public SessionResource createSession(
            @PathVariable(value = "customerId") Long customerId,
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            @RequestBody SaveSessionResource resource) {
        return convertToResource(sessionService.createSession(customerId,collaboratorId,
                convertToEntity(resource)));
    }

    @Operation(summary = "Update a session")
    @PutMapping("/customers/{customerId}/sessions/{sessionId}")
    public SessionResource updateSession(
            @PathVariable(value = "customerId") Long customerId,
            @PathVariable(value = "sessionId") Long sessionId,
            @RequestBody SaveSessionResource resource) {
        return convertToResource(sessionService.updateSession(customerId, sessionId,
                convertToEntity(resource)));
    }

    @Operation(summary = "Delete a session")
    @DeleteMapping("/customers/{customerId}/sessions/{sessionId}")
    public ResponseEntity<?> deleteSession(
            @PathVariable(value = "customerId") Long customerId,
            @PathVariable(value = "sessionId") Long sessionId) {
        return sessionService.deleteSession(customerId, sessionId);
    }

    private Session convertToEntity(SaveSessionResource resource) {
        return mapper.map(resource, Session.class);
    }

    private SessionResource convertToResource(Session entity) {
        return mapper.map(entity, SessionResource.class);
    }

}
