package com.acme.Initialization.Test;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Initialization.domain.service.CollaboratorService;
import com.acme.homehealthy.Initialization.domain.service.CustomerService;
import com.acme.homehealthy.Initialization.service.CollaboratorServiceImpl;
import com.acme.homehealthy.Initialization.service.CustomerServiceImpl;
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
public class CustomerServiceImplIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @TestConfiguration
    static class CustomerServiceImplConfiguration{
        @Bean
        public CustomerService postService(){
            return new CustomerServiceImpl();
        }
    }

    @Test
    @DisplayName("When createReview But ScoreId Not Exists Return Resource Score not found for Id with value 1")
    public void CreteReviewButNotExists() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setUsername("Hugox");
        customer.setEmail("hugo@gmail.com");
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Customer","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Customer result = customerService.getCustomerById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When createReview But ScoreId Not Exists Return Resource Score not found for Id with value 1")
    public void CreateReview() {
        //Arrange
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setUsername("Hugox");
        customer.setEmail("hugo@gmail.com");
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
        Mockito.when(customerRepository.findCustomerByUsername("Hugox"))
                .thenReturn(Optional.of(customer));
        String expectedMessage = "This username is begin used by another user";
        //Act
        Customer customer1 = new Customer();
        customer1.setId(2L);
        customer1.setUsername("Hugox");
        Throwable exception = catchThrowable(()-> {
            Customer result = customerService.createCustomer(customer1);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
