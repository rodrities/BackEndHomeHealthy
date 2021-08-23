package com.acme.homehealthy.Social.service;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Social.domain.model.Complaint;
import com.acme.homehealthy.Social.domain.model.Reason;
import com.acme.homehealthy.Social.domain.repository.ComplaintRepository;
import com.acme.homehealthy.Social.domain.repository.ReasonRepository;
import com.acme.homehealthy.Social.domain.service.ComplaintService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public Page<Complaint> getAllComplaints(Pageable pageable) {
        return complaintRepository.findAll(pageable);
    }

    @Override
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Complaint","Id",id));
    }

    @Override
    public Complaint createComplaint(Long customerId, Long reasonId, Complaint complaintRequest) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerId));
        Reason reason = reasonRepository.findById(reasonId).orElseThrow(()->new ResourceNotFoundException("Reason","Id",reasonId));
        complaintRequest.setCustomer(customer);
        complaintRequest.setReason(reason);
        return complaintRepository.save(complaintRequest);
    }

    @Override
    public Complaint updateComplaint(Long customerId, Long reasonId, Long complaintId, Complaint complaintRequest) {

        Complaint complaint = complaintRepository.findById(complaintId).orElseThrow(()->new ResourceNotFoundException("Complaint","Id",complaintId));
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerId));
        Reason reason = reasonRepository.findById(reasonId).orElseThrow(()->new ResourceNotFoundException("Reason","Id",reasonId));

        return complaintRepository.save(complaint.setCustomer(customer)
        .setDescription(complaintRequest.getDescription())
        .setReason(reason));
    }

    @Override
    public ResponseEntity<?> deleteComplaint(Long id) {
        Complaint complaint = complaintRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Complaint","Id",id));
        complaintRepository.delete(complaint);
        return ResponseEntity.ok().build();
    }
}
