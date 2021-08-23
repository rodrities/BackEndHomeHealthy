package com.acme.homehealthy.MemberShip.service;

import com.acme.homehealthy.MemberShip.domain.model.Plan;
import com.acme.homehealthy.MemberShip.domain.repository.PlanRepository;
import com.acme.homehealthy.MemberShip.domain.service.PlanService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public Page<Plan> getAllPlans(Pageable pageable) {
        return planRepository.findAll(pageable);
    }

    @Override
    public Page<Plan> getAllPlansByPriceLessThanEqual(Long price, Pageable pageable) {
        return planRepository.findPlanByPriceLessThanEqual(price, pageable).orElseThrow(()->new ResourceNotFoundException("asd"));
    }

    @Override
    public Plan getPlanById(Long id) {
        return planRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Plan","Id",id));
    }

    @Override
    public Plan getPlanByName(String name) {
        return planRepository.findPlanByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Plan", "Name", name));
    }

    @Override
    public Plan createPlan(Plan plan) {
        Plan existingName = planRepository.findPlanByName(plan.getName())
                .orElse(null);
        if(existingName != null){
            throw new ResourceNotFoundException("This name is begin used in other plan");
        }
        return planRepository.save(plan);
    }

    @Override
    public Plan updatePlan(Long id, Plan plan) {
        Plan existingPlan = planRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Plan","Id",id));
        if(existingPlan.getName() != plan.getName()) {
            Plan existingPlanName = planRepository.findPlanByName(plan.getName())
                    .orElse(null);
            if (existingPlanName != null) {
                throw new ResourceNotFoundException("This name is begin used in other plan");
            }
        }

        return planRepository.save(
                existingPlan.setDescription(plan.getDescription())
                .setMaxSession(plan.getMaxSession())
                .setPrice(plan.getPrice())
                .setName(plan.getName())
        );
    }

    @Override
    public ResponseEntity<?> deletePlan(Long id) {
        Plan existingPlan = planRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Plan","Id",id));
        planRepository.delete(existingPlan);
        return ResponseEntity.ok().build();
    }
}
