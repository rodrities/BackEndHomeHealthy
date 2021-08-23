package com.acme.homehealthy.Social.controller;


import com.acme.homehealthy.Social.domain.model.Complaint;
import com.acme.homehealthy.Social.domain.service.ComplaintService;
import com.acme.homehealthy.Social.resource.ComplaintResource;
import com.acme.homehealthy.Social.resource.SaveComplaintResource;
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

@Tag(name = "Complaint", description = "Social API")
@RestController
@RequestMapping("api/")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/complaints")
    public Page<ComplaintResource> getAllComplaints(Pageable pageable){
        Page<Complaint> complaints = complaintService.getAllComplaints(pageable);
        List<ComplaintResource> resources = complaints.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/complaints/{complaintId}")
    public ComplaintResource getComplaintById(@Valid @PathVariable(name = "complaintId") Long complaintId){
        return convertToResource(complaintService.getComplaintById(complaintId));
    }

    @PostMapping("/complaints/{customerId}/{reasonId}")
    public ComplaintResource createComplaint(@Valid @PathVariable(name = "customerId") Long customerId,
                                             @Valid @PathVariable(name = "reasonId") Long reasonId,
                                             @Valid @RequestBody SaveComplaintResource resource){
        Complaint complaint = convertToEntity(resource);
        return convertToResource(complaintService.createComplaint(customerId,reasonId,complaint));
    }

    @PutMapping("/complaints/{complaintId}/{customerId}/{reasonId}")
    public ComplaintResource updateComplaint(@Valid @PathVariable(name = "complaintId") Long complaintId,
                                             @Valid @PathVariable(name = "customerId") Long customerId,
                                             @Valid @PathVariable(name = "reasonId") Long reasonId,
                                             @Valid @RequestBody SaveComplaintResource resource){
        Complaint complaint = convertToEntity(resource);
        return convertToResource(complaintService.updateComplaint(customerId,reasonId,complaintId,complaint));
    }

    @DeleteMapping("/complaints/{complaintId}")
    public ResponseEntity<?> deleteComplaint(@Valid @PathVariable(name = "complaintId") Long complaintId){
        complaintService.deleteComplaint(complaintId);
        return ResponseEntity.ok().build();
    }

    private Complaint convertToEntity(SaveComplaintResource resource){
        return mapper.map(resource,Complaint.class);
    }

    private ComplaintResource convertToResource(Complaint complaint){
        return mapper.map(complaint,ComplaintResource.class);
    }
}
