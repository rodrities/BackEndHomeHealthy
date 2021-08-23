package com.acme.homehealthy.Social.domain.service;

import com.acme.homehealthy.Social.domain.model.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ComplaintService {
    Page<Complaint> getAllComplaints(Pageable pageable);
    Complaint getComplaintById(Long id);
    Complaint createComplaint(Long customerId, Long reasonId, Complaint complaintRequest);
    Complaint updateComplaint(Long customerId, Long reasonId, Long complaintId, Complaint complaintRequest);
    ResponseEntity<?> deleteComplaint(Long id);
}
