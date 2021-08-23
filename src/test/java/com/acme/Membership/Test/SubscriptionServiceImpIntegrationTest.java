package com.acme.Membership.Test;


import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.MemberShip.domain.model.Plan;
import com.acme.homehealthy.MemberShip.domain.model.Subscription;
import com.acme.homehealthy.MemberShip.domain.repository.PlanRepository;
import com.acme.homehealthy.MemberShip.domain.repository.SubscriptionRepository;
import com.acme.homehealthy.MemberShip.domain.service.SubscriptionService;
import com.acme.homehealthy.MemberShip.service.SubscriptionServiceImpl;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
public class SubscriptionServiceImpIntegrationTest {

    @Autowired
    private SubscriptionService subscriptionService;

    @MockBean
    private SubscriptionRepository subscriptionRepository;

    @MockBean
    private PlanRepository planRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @TestConfiguration
    static class SubscriptionServiceImplTestConfiguration {
        @Bean
        public SubscriptionService postService() {
            return new SubscriptionServiceImpl();
        }
    }

    @Test
    @DisplayName("When createSubscriptionPlan Without An Existing Plan")
    public void when(){
        //Arrange
        String template= "Resource %s not found for %s with value %s";
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Source");
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
        Mockito.when(planRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Plan","Id",1L);
        //Act
        Subscription subscription = new Subscription();
        subscription.setId(1L);
        Throwable exception = catchThrowable(()-> {
            Subscription saveSubscription = subscriptionService.createOrderSubscription(1L,1L,subscription);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When createSubscriptionPlan Without An Existing Customer")
    public void whena(){
        //Arrange
        String template= "Resource %s not found for %s with value %s";
        Plan plan = new Plan();
        plan.setId(1L);
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.empty());
        Mockito.when(planRepository.findById(1L))
                .thenReturn(Optional.of(plan));
        String expectedMessage = String.format(template, "Customer","Id",1L);
        //Act
        Subscription subscription = new Subscription();
        subscription.setId(1L);
        Throwable exception = catchThrowable(()-> {
            Subscription saveSubscription = subscriptionService.createOrderSubscription(1L,1L,subscription);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When findSubscriptionPlanById Without An Existing Subscription")
    public void whenaa(){
        //Arrange
        String template= "Resource %s not found for %s with value %s";
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.empty());
        Mockito.when(planRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Subscription","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Subscription saveSubscription = subscriptionService.getOrderSubscriptionById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
