package com.acme.homehealthy.Social.controller;

import com.acme.homehealthy.Social.domain.model.Reason;
import com.acme.homehealthy.Social.domain.service.ReasonService;
import com.acme.homehealthy.Social.resource.ReasonResource;
import com.acme.homehealthy.Social.resource.SaveReasonResource;
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

@Tag(name = "Reason",description = "Social API")
@RestController
@RequestMapping("api/")
public class ReasonController {

    @Autowired
    private ReasonService reasonService;

    @Autowired
    private ModelMapper mapper;

    //Page<Reason> getAllReasons(Pageable pageable);
    @GetMapping("/reasons")
    public Page<ReasonResource> getAllReasons(Pageable pageable){
        Page<Reason> reasons = reasonService.getAllReasons(pageable);
        List<ReasonResource> resources = reasons.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    //Reason getReasonById(Long id);
    @GetMapping("/reasons/{reasonId}")
    public ReasonResource getReasonById(@Valid @PathVariable(name = "reasonId") Long reasonId){
        return convertToResource(reasonService.getReasonById(reasonId));
    }
    //Reason createReason(Reason reasonRequest);
    @PostMapping("/reasons")
    public ReasonResource createReasonById(@Valid @RequestBody SaveReasonResource resource){
        Reason reason = convertToEntity(resource);
        return convertToResource(reasonService.createReason(reason));
    }
    //Reason updateReason(Long id, Reason reasonRequest);
    @PutMapping("/reasons/{reasonId}")
    public ReasonResource updateReasonById(@Valid @PathVariable(name = "reasonId") Long reasonId,
                                        @Valid @RequestBody SaveReasonResource resource){
        Reason reason = convertToEntity(resource);
        return convertToResource(reasonService.updateReason(reasonId, reason));
    }
    //ResponseEntity<?> deleteReason(Long id);
    @DeleteMapping("/reasons/{reasonId}")
    public ResponseEntity<?> updateReasonById(@Valid @PathVariable(name = "reasonId") Long reasonId){
        reasonService.deleteReason(reasonId);
        return ResponseEntity.ok().build();
    }

    private Reason convertToEntity(SaveReasonResource resource){return mapper.map(resource, Reason.class);}
    private ReasonResource convertToResource(Reason reason){return mapper.map(reason,ReasonResource.class);}
}
