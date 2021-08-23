package com.acme.homehealthy.Social.service;

import com.acme.homehealthy.Social.domain.model.Reason;
import com.acme.homehealthy.Social.domain.repository.ReasonRepository;
import com.acme.homehealthy.Social.domain.service.ReasonService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReasonServiceImpl implements ReasonService {

    @Autowired
    private ReasonRepository reasonRepository;

    @Override
    public Page<Reason> getAllReasons(Pageable pageable) {
        return reasonRepository.findAll(pageable);
    }

    @Override
    public Reason getReasonById(Long id) {
        return reasonRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Reason","Id", id));
    }

    @Override
    public Reason createReason(Reason reasonRequest) {
        Reason existName = reasonRepository.findReasonByDescription(reasonRequest.getDescription()).orElse(null);
        if(existName != null){
            throw new ResourceNotFoundException("This description exists");
        }

        return reasonRepository.save(reasonRequest);

    }

    @Override
    public Reason updateReason(Long id, Reason reasonRequest) {
        Reason existReason = reasonRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Reason","Id",id));
        Reason existName = reasonRepository.findReasonByDescription(reasonRequest.getDescription()).orElse(null);
        if(existReason.getDescription() != reasonRequest.getDescription()) {
            if (existName != null) {
                throw new ResourceNotFoundException("This description exists");
            }
        }
        return reasonRepository.save(existReason.setDescription(reasonRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteReason(Long id) {
        Reason existReason = reasonRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Reason","Id",id));
        reasonRepository.delete(existReason);
        return ResponseEntity.ok().build();
    }
}
