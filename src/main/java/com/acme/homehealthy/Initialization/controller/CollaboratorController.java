package com.acme.homehealthy.Initialization.controller;


import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.service.CollaboratorService;
import com.acme.homehealthy.Initialization.resource.CollaboratorResource;
import com.acme.homehealthy.Initialization.resource.SaveCollaboratorResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apiguardian.api.API;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Collaborators", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class CollaboratorController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CollaboratorService collaboratorService;

    @Operation(summary="Find all collaborators")
    @GetMapping("/collaborators")
    public Page<CollaboratorResource> getAllCollaborators(Pageable pageable){
        Page<Collaborator> collaborators = collaboratorService.getAllCollaborators(pageable);
        List<CollaboratorResource> resources = collaborators.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find collaborator by Id")
    @GetMapping("/collaborators/{collaboratorId}")
    public CollaboratorResource getCollaboratorById(@Valid @PathVariable (value = "collaboratorId") Long collaboratorId){
        return convertToResource(collaboratorService.getCollaboratorById(collaboratorId));
    }

    @Operation(summary = "Find collaborator by username and password")
    @GetMapping("/collaborators/{username}/{password}")
    public CollaboratorResource getCollaboratorByUsernameAndPassword(   @Valid @PathVariable (value = "username") String username,
                                                                        @Valid @PathVariable (value = "password") String password){
        return convertToResource(collaboratorService.getCollaboratorByUsernameAndPassword(username,password));
    }

    @Operation(summary = "Create a new collaborator")
    @PostMapping("/collaborators")
    public CollaboratorResource createCollaborator(@Valid @RequestBody SaveCollaboratorResource resource){
        Collaborator collaborator = convertToEntity(resource);
        return convertToResource(collaboratorService.createCollaborator(collaborator));
    }

    @Operation(summary = "Update a existing collaborator")
    @PutMapping("/collaborators/{collaboratorId}")
    public CollaboratorResource updateCollaborator(@Valid @PathVariable (value = "collaboratorId") Long id,
                                                   @Valid @RequestBody SaveCollaboratorResource resource){
        Collaborator collaborator = convertToEntity(resource);
        return convertToResource(collaboratorService.updateCollaborator(id,collaborator));
    }

    @Operation(summary = "Delete a collaborator")
    @DeleteMapping("/collaborators/{username}")
    public ResponseEntity<?> deleteCollaborator(@Valid @PathVariable (value = "username") String username){
        collaboratorService.deleteCollaborator(username);
        return ResponseEntity.ok().build();
    }

    private CollaboratorResource convertToResource(Collaborator resource){
        return mapper.map(resource, CollaboratorResource.class);
    }

    private Collaborator convertToEntity(SaveCollaboratorResource resource){
        return mapper.map(resource,Collaborator.class);
    }
}
