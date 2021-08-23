package com.acme.Membership.Test;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.MemberShip.domain.model.Plan;
import com.acme.homehealthy.MemberShip.domain.model.Subscription;
import com.acme.homehealthy.MemberShip.domain.repository.PlanRepository;
import com.acme.homehealthy.MemberShip.domain.repository.SubscriptionRepository;
import com.acme.homehealthy.MemberShip.domain.service.PlanService;
import com.acme.homehealthy.MemberShip.domain.service.SubscriptionService;
import com.acme.homehealthy.MemberShip.service.PlanServiceImpl;
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
public class PlanServiceImplIntegrationTest {

    @Autowired
    private PlanService planService;

    @MockBean
    private PlanRepository planRepository;

    @TestConfiguration
    static class PlanServiceImplTestConfiguration {
        @Bean
        public PlanService postService() {
            return new PlanServiceImpl();
        }
    }

    @Test
    @DisplayName("When createPlan But Using The Same Name Of A Plan")
    public void whe11n(){
        //Arrange
        String message= "This name is begin used in other plan";
        Plan plan = new Plan();
        plan.setId(1L);
        plan.setName("Nivel 1");
        Mockito.when(planRepository.findPlanByName(plan.getName()))
                .thenReturn(Optional.of(plan));
        //Act
        Plan plan2 = new Plan();
        plan2.setId(2L);
        plan2.setName("Nivel 1");

        Throwable exception = catchThrowable(()-> {
            Plan result = planService.createPlan(plan2);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("When findPlanById But The PlanId Not Existing")
    public void whe111n(){
        //Arrange
        String template= "Resource %s not found for %s with value %s";
        Mockito.when(planRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Plan","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Plan result = planService.getPlanById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
