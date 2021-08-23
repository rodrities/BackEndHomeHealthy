package com.acme.homehealthy.MemberShip.controller;

import com.acme.homehealthy.MemberShip.domain.service.SubscriptionService;
import com.acme.homehealthy.MemberShip.resource.OrderSubscriptionResource;
import com.acme.homehealthy.MemberShip.resource.SaveOrderSubscriptionResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Subscription", description = "Membership API")
@RestController
@RequestMapping("api/")
public class SubscriptionController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SubscriptionService subscriptionService;

    //OrderSubscription getOrderSubscriptionById(Long id);
    @GetMapping("/subscription/{orderSubscriptionId}")
    public OrderSubscriptionResource getOrderSubscriptionById(@Valid @PathVariable (name = "orderSubscriptionId") Long id){
        return convertToResource(subscriptionService.getOrderSubscriptionById(id));
    }

    //OrderSubscription createOrderSubscription(OrderSubscription subscription);
    @PostMapping("/subscription/{planId}/{customerId}")
    public OrderSubscriptionResource createOrderSubscription(@Valid @RequestBody SaveOrderSubscriptionResource resource,
                                                             @Valid @PathVariable (value = "planId") Long planId,
                                                             @Valid @PathVariable (value = "customerId") Long customerId){
        com.acme.homehealthy.MemberShip.domain.model.Subscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.createOrderSubscription(planId,customerId,subscription));
    }

    //OrderSubscription updateOrderSubscription(Long id, OrderSubscription subscription);
    @PutMapping("/subscription/{orderSubscriptionId}/{planId}/{customerId}")
    public OrderSubscriptionResource updateOrderSubscription(@Valid @PathVariable (name = "orderSubscriptionId") Long id,
                                                             @Valid @PathVariable (name = "planId") Long planId,
                                                             @Valid @PathVariable (name = "customerId") Long customerId,
                                                             @Valid @RequestBody SaveOrderSubscriptionResource resource){
        com.acme.homehealthy.MemberShip.domain.model.Subscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.updateOrderSubscription(id,planId,customerId,subscription));
    }

    //ResponseEntity<?> deleteOrderSubscription(Long id);
    @DeleteMapping("/subscription/{orderSubscriptionId}")
    public ResponseEntity<?> deleteOrderSubscription(@Valid @PathVariable (name = "orderSubscriptionId") Long id){
        subscriptionService.deleteOrderSubscription(id);
        return ResponseEntity.ok().build();
    }

    private com.acme.homehealthy.MemberShip.domain.model.Subscription convertToEntity(SaveOrderSubscriptionResource resource){
        return mapper.map(resource, com.acme.homehealthy.MemberShip.domain.model.Subscription.class);
    }

    private OrderSubscriptionResource convertToResource(com.acme.homehealthy.MemberShip.domain.model.Subscription subscription){
        return mapper.map(subscription, OrderSubscriptionResource.class);
    }
}
