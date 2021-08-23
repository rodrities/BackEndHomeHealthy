package com.acme.homehealthy.MemberShip.service;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.MemberShip.domain.model.Plan;
import com.acme.homehealthy.MemberShip.domain.model.Subscription;
import com.acme.homehealthy.MemberShip.domain.repository.PlanRepository;
import com.acme.homehealthy.MemberShip.domain.repository.SubscriptionRepository;
import com.acme.homehealthy.MemberShip.domain.service.SubscriptionService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Subscription getOrderSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subscription","Id",id));
    }

    @Override
    public Subscription createOrderSubscription(Long planId, Long customerId, com.acme.homehealthy.MemberShip.domain.model.Subscription subscription) {
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer","Id",customerId));

        Plan existingPlan = planRepository.findById(planId).orElseThrow(()->new ResourceNotFoundException("Plan","Id",planId));

        subscription.setPlan(existingPlan);
        subscription.setCustomer(existingCustomer);
        subscription.setTotalPrice();
        return this.subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateOrderSubscription(Long id, Long planId, Long customerId, com.acme.homehealthy.MemberShip.domain.model.Subscription subscription) {
        Subscription orderSubscription = this.subscriptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Subscription","Id",id));

        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer","Id",customerId));

        Plan existingPlan = planRepository.findById(planId).orElseThrow(()->new ResourceNotFoundException("Plan","Id",planId));

        return this.subscriptionRepository.save(
                orderSubscription.setCustomer(existingCustomer)
                .setAmounthOfMonth(subscription.getAmounthOfMonth())
                .setPlan(existingPlan)
                .setTotalPrice()
                .setCustomer(existingCustomer)
        );
    }

    @Override
    public ResponseEntity<?> deleteOrderSubscription(Long id) {
        Subscription existingSubscription = subscriptionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Subscription","Id",id));
        subscriptionRepository.delete(existingSubscription);
        return ResponseEntity.ok().build();
    }
}
