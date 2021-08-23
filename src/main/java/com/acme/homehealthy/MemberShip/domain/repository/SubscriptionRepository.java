package com.acme.homehealthy.MemberShip.domain.repository;

import com.acme.homehealthy.MemberShip.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
