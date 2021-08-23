package com.acme.Social.Test;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Social.domain.model.Complaint;
import com.acme.homehealthy.Social.domain.model.Reason;
import com.acme.homehealthy.Social.domain.model.Review;
import com.acme.homehealthy.Social.domain.model.Score;
import com.acme.homehealthy.Social.domain.repository.ReviewRepository;
import com.acme.homehealthy.Social.domain.repository.ScoreRepository;
import com.acme.homehealthy.Social.domain.service.ReasonService;
import com.acme.homehealthy.Social.domain.service.ReviewService;
import com.acme.homehealthy.Social.service.ReasonServiceImpl;
import com.acme.homehealthy.Social.service.ReviewServiceImpl;
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
public class ReviewServiceImplIntegration {

    @Autowired
    private ReviewService reviewService;

    @MockBean
    private CollaboratorRepository collaboratorRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private ReviewRepository reviewRepository;

    @MockBean
    private ScoreRepository scoreRepository;

    @TestConfiguration
    static class ReviewServiceImplConfiguration{
        @Bean
        public ReviewService postService(){
            return new ReviewServiceImpl();
        }
    }

    @Test
    @DisplayName("When createReview But CustomerId Not Exists Return Resource Customer not found for Id with value 1")
    public void  adaasd() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");

        Collaborator collaborator = new Collaborator();
        collaborator.setId(1L);

        Score score = new Score();
        score.setId(1L);
        Mockito.when(collaboratorRepository.findById(1L))
                .thenReturn(Optional.of(collaborator));
        Mockito.when(scoreRepository.findById(1L))
                .thenReturn(Optional.of(score));
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Customer","Id",1L);
        //Act
        Review review = new Review();
        review.setDescription("Buena enseñanza");
        Throwable exception = catchThrowable(()-> {
            Review result = reviewService.createReview(1L,1L,1L,review);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When createReview But CollaboratorId Not Exists Return Resource Collaborator not found for Id with value 1")
    public void  raasd() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");

        Customer customer = new Customer();
        customer.setId(1L);

        Collaborator collaborator = new Collaborator();
        collaborator.setId(1L);

        Score score = new Score();
        score.setId(1L);
        Mockito.when(collaboratorRepository.findById(1L))
                .thenReturn(Optional.empty());
        Mockito.when(scoreRepository.findById(1L))
                .thenReturn(Optional.of(score));
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
        String expectedMessage = String.format(template, "Collaborator","Id",1L);
        //Act
        Review review = new Review();
        review.setDescription("Buena enseñanza");
        Throwable exception = catchThrowable(()-> {
            Review result = reviewService.createReview(1L,1L,1L,review);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When createReview But ScoreId Not Exists Return Resource Score not found for Id with value 1")
    public void yaasd() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");

        Customer customer = new Customer();
        customer.setId(1L);

        Collaborator collaborator = new Collaborator();
        collaborator.setId(1L);

        Score score = new Score();
        score.setId(1L);
        Mockito.when(collaboratorRepository.findById(1L))
                .thenReturn(Optional.of(collaborator));
        Mockito.when(scoreRepository.findById(1L))
                .thenReturn(Optional.empty());
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
        String expectedMessage = String.format(template, "Score","Id",1L);
        //Act
        Review review = new Review();
        review.setDescription("Buena enseñanza");
        Throwable exception = catchThrowable(()-> {
            Review result = reviewService.createReview(1L,1L,1L,review);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
