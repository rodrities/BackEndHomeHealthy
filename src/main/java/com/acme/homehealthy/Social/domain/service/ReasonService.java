package com.acme.homehealthy.Social.domain.service;

import com.acme.homehealthy.Social.domain.model.Reason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ReasonService {
    Page<Reason> getAllReasons(Pageable pageable);
    Reason getReasonById(Long id);
    Reason createReason(Reason reasonRequest);
    Reason updateReason(Long id, Reason reasonRequest);
    ResponseEntity<?> deleteReason(Long id);
}
