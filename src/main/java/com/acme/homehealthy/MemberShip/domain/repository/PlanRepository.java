package com.acme.homehealthy.MemberShip.domain.repository;

import com.acme.homehealthy.MemberShip.domain.model.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan,Long> {
    Optional<Plan> findPlanByName(String name);
    Optional<Page<Plan>> findPlanByPriceLessThanEqual(Long price, Pageable pageable);
}
