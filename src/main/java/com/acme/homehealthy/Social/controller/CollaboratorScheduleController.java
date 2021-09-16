package com.acme.homehealthy.Social.controller;


import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Meeting.resource.SaveSessionResource;
import com.acme.homehealthy.Meeting.resource.SessionResource;
import com.acme.homehealthy.Social.domain.model.CollaboratorSchedule;
import com.acme.homehealthy.Social.domain.service.CollaboratorScheduleService;
import com.acme.homehealthy.Social.resource.CollaboratorScheduleResource;
import com.acme.homehealthy.Social.resource.SaveCollaboratorSchedule;
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

@Tag(name = "CollaboratorSchedules", description = "Collaborator Schedules API")
@RestController
@RequestMapping("/api")
public class CollaboratorScheduleController {

    @Autowired
    private CollaboratorScheduleService collaboratorScheduleService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Find collaboratorSchedules by collaborator Id")
    @GetMapping("/collaborators/{collaboratorId}/schedules")
    public Page<CollaboratorScheduleResource> getAllCollaboratorSchedulesByCollaboratorId(
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            Pageable pageable) {
        Page<CollaboratorSchedule> commentPage = collaboratorScheduleService.getAllCollaboratorSchedulesByCollaboratorId(collaboratorId, pageable);
        List<CollaboratorScheduleResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find collaboratorSchedules by Id")
    @GetMapping("/collaborators/{collaboratorId}/schedules/{scheduleId}")
    public CollaboratorScheduleResource getCollaboratorScheduleByIdAndUser(
            @PathVariable(name = "collaboratorId") Long collaboratorId,
            @PathVariable(name = "scheduleId") Long scheduleId) {
        return convertToResource(collaboratorScheduleService.getCollaboratorScheduleByIdAndCollaboratorId(collaboratorId, scheduleId));
    }

    @Operation(summary = "Create collaboratorSchedule")
    @PostMapping("/collaborators/{collaboratorId}/schedules")
    public CollaboratorScheduleResource createCollaboratorSchedule(
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            @RequestBody SaveCollaboratorSchedule resource) {
        return convertToResource(collaboratorScheduleService.createCollaboratorSchedule(collaboratorId,
                convertToEntity(resource)));
    }

    @Operation(summary = "Update collaboratorSchedule")
    @PutMapping("/collaborators/{collaboratorId}/schedules/{schedulesId}")
    public CollaboratorScheduleResource updateSession(
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            @PathVariable(value = "schedulesId") Long schedulesIdId,
            @RequestBody SaveCollaboratorSchedule resource) {
        return null;
    }

    @Operation(summary = "Delete collaboratorSchedule")
    @DeleteMapping("/collaborators/{collaboratorId}/schedules/{schedulesId}")
    public ResponseEntity<?> deleteSession(
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            @PathVariable(value = "schedulesId") Long schedulesId) {
        return collaboratorScheduleService.deleteCollaboratorSchedule(collaboratorId, schedulesId);
    }

    private CollaboratorSchedule convertToEntity(SaveCollaboratorSchedule resource) {
        return mapper.map(resource, CollaboratorSchedule.class);
    }

    private CollaboratorScheduleResource convertToResource(CollaboratorSchedule entity) {
        return mapper.map(entity, CollaboratorScheduleResource.class);
    }
}
