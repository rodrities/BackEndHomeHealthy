package com.acme.homehealthy.MemberShip.domain.service;

import com.acme.homehealthy.MemberShip.domain.model.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PlanService {
    Page<Plan> getAllPlans(Pageable pageable);
    Page<Plan> getAllPlansByPriceLessThanEqual(Long price, Pageable pageable);
    Plan getPlanById(Long id);
    Plan getPlanByName(String name);
    Plan createPlan(Plan plan);
    Plan updatePlan(Long id, Plan plan);
    ResponseEntity<?> deletePlan(Long id);
}
