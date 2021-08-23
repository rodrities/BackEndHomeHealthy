package com.acme.homehealthy.Meeting.controller;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.service.RutineService;

import com.acme.homehealthy.Meeting.resource.DietResource;
import com.acme.homehealthy.Meeting.resource.RutineResource;
import com.acme.homehealthy.Meeting.resource.SaveDietResource;
import com.acme.homehealthy.Meeting.resource.SaveRutineResource;
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

@Tag(name = "Routine", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class RutineController {
    @Autowired
    private RutineService rutineService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/rutines")
    public Page<RutineResource> getAllRutines(Pageable pageable){
        Page<Rutine> reviews = rutineService.getAllRutines(pageable);
        List<RutineResource> resources = reviews.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/customers/{customerId}/rutines")
    public Page<RutineResource> getAllRutinesByUserId(
            @PathVariable(value = "customerId") Long customerId,
            Pageable pageable) {
        Page<Rutine> commentPage = rutineService.getAllRutinesByUserId(customerId, pageable);
        List<RutineResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }
    @GetMapping("/collaborators/{collaboratorId}/rutines")
    public Page<RutineResource> getAllRutinesByCollaboratorId(
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            Pageable pageable) {
        Page<Rutine> commentPage = rutineService.getAllRutinesByCollaboratorId(collaboratorId, pageable);
        List<RutineResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/rutines/{rutineId}")
    public RutineResource getRutinename(@Valid @PathVariable (value = "rutineId") Long rutineId){
        return convertToResource(rutineService.getRutineById(rutineId));
    }


    @PostMapping("/rutines/{collaboratorId}/{customerId}")
    public RutineResource createRutine(@Valid @RequestBody SaveRutineResource resource,
                                   @Valid @PathVariable (value = "customerId") Long customerId,
                                   @Valid @PathVariable (value = "collaboratorId") Long collaboratorId){
        return convertToResource(rutineService.createRutine(customerId,collaboratorId,
                convertToEntity(resource)));
    }

    //no funciona
    @PutMapping("/rutines/{rutineId}/{sessionId}")
    public RutineResource updateRutine( @Valid @PathVariable (value = "rutineId") Long rutineId,
                                    @Valid @RequestBody SaveRutineResource resource,
                                    @Valid @PathVariable (value = "sessionId") Long sessionId){
        Rutine rutine = convertToEntity(resource);
        return convertToResource(rutineService.updateRutine(rutineId,rutine, sessionId));
    }


    @DeleteMapping("/rutines/{name}")
    public ResponseEntity<?> deleteRutine(@Valid @PathVariable (value = "name") String name){
        return  rutineService.deleteRutine(name);
    }

    private Rutine convertToEntity(SaveRutineResource resource){
        return mapper.map(resource, Rutine.class);
    }

    private RutineResource convertToResource(Rutine rutine){
        return mapper.map(rutine, RutineResource.class);
    }
}
