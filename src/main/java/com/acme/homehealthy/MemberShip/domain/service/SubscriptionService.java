package com.acme.homehealthy.MemberShip.domain.service;

import com.acme.homehealthy.MemberShip.domain.model.Subscription;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {
    com.acme.homehealthy.MemberShip.domain.model.Subscription getOrderSubscriptionById(Long id);
    com.acme.homehealthy.MemberShip.domain.model.Subscription createOrderSubscription(Long planId, Long customerId, com.acme.homehealthy.MemberShip.domain.model.Subscription subscription);
    com.acme.homehealthy.MemberShip.domain.model.Subscription updateOrderSubscription(Long id, Long planId, Long customerId, com.acme.homehealthy.MemberShip.domain.model.Subscription subscription);
    ResponseEntity<?> deleteOrderSubscription(Long id);
}
