package com.acme.homehealthy.Meeting.controller;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.service.DietService;
import com.acme.homehealthy.Meeting.resource.DietResource;
import com.acme.homehealthy.Meeting.resource.SaveDietResource;

import com.acme.homehealthy.Meeting.resource.SessionResource;
import com.acme.homehealthy.Social.domain.model.Review;
import com.acme.homehealthy.Social.resource.ReviewResource;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name = "Diet", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class DietController {
    @Autowired
    private DietService dietService;

    @Autowired
    private ModelMapper mapper;

    /*@GetMapping("/customers/{customerId}/diets")
    public Page<DietResource> getAllDietsByUserId(
            @PathVariable(value = "customerId") Long customerId,
            Pageable pageable) {
        Page<Diet> commentPage = dietService.getAllDietsByUserId(customerId, pageable);
        List<DietResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }*/

    @Operation(summary = "Find all diets")
    @GetMapping("/diets")
    public Page<DietResource> getAllDiets(Pageable pageable){
        Page<Diet> reviews = dietService.getAllDiets(pageable);
        List<DietResource> resources = reviews.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find diets by customer Id")
    @GetMapping("/customers/{customerId}/diets")
    public Page<DietResource> getAllDietsByUserId(
            @PathVariable(value = "customerId") Long customerId,
            Pageable pageable) {
        Page<Diet> commentPage = dietService.getAllDietsByUserId(customerId, pageable);
        List<DietResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find diets by collaborator Id")
    @GetMapping("/collaborators/{collaboratorId}/diets")
    public Page<DietResource> getAllDietsByCollaboratorId(
            @PathVariable(value = "collaboratorId") Long collaboratorId,
            Pageable pageable) {
        Page<Diet> commentPage = dietService.getAllDietsByCollaboratorId(collaboratorId, pageable);
        List<DietResource> resources = commentPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find diet by Id")
    @GetMapping("/diets/{dietId}")
    public DietResource getDietname(@Valid @PathVariable (value = "dietId") Long dietId){
        return convertToResource(dietService.getDietById(dietId));
    }


    //Version antigua
    /*@PostMapping("/diets/sessions/{id}")
    public DietResource createDiet(@Valid @RequestBody SaveDietResource resource,
                                    @Valid @PathVariable (value = "id") Long id){
        Diet diet = convertToEntity(resource);
        return convertToResource(dietService.createDiet(diet,id));
    }*/

    @Operation(summary = "Create a diet")
    @PostMapping("/diets/{collaboratorId}/{customerId}")
    public DietResource createDiet(@Valid @RequestBody SaveDietResource resource,
                                   @Valid @PathVariable (value = "customerId") Long customerId,
                                   @Valid @PathVariable (value = "collaboratorId") Long collaboratorId){
        return convertToResource(dietService.createDiet(customerId,collaboratorId,
                convertToEntity(resource)));
        }

    @Operation(summary = "Update a diet")
    @PutMapping("/diets/{dietId}/{sessionId}")
    public DietResource updateDiet( @Valid @PathVariable (value = "dietId") Long dietId,
                                    @Valid @RequestBody SaveDietResource resource,
                                    @Valid @PathVariable (value = "sessionId") Long sessionId){
        Diet diet = convertToEntity(resource);
        return convertToResource(dietService.updateDiet(dietId,diet, sessionId));
    }

    @Operation(summary = "Delete a diet")
    @DeleteMapping("/diets/{name}")
    public ResponseEntity<?> deleteDiet(@Valid @PathVariable (value = "name") String name){
        return  dietService.deleteDiet(name);
    }

    //@GetMapping("/diets/sessions/{id}")
    //public DietResource getDietBySessionId(Long id){
       // return convertToResource(dietService.getDietBySessionId(id));
    //}


    private Diet convertToEntity(SaveDietResource resource){
        return mapper.map(resource, Diet.class);
    }

    private DietResource convertToResource(Diet diet){
        return mapper.map(diet, DietResource.class);
    }
}
