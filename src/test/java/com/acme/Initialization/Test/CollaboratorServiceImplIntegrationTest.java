package com.acme.Initialization.Test;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Initialization.domain.service.CollaboratorService;
import com.acme.homehealthy.Initialization.service.CollaboratorServiceImpl;
import com.acme.homehealthy.Social.domain.model.Review;
import com.acme.homehealthy.Social.domain.model.Score;
import com.acme.homehealthy.Social.domain.service.ComplaintService;
import com.acme.homehealthy.Social.service.ComplaintServiceImpl;
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
public class CollaboratorServiceImplIntegrationTest {

    @Autowired
    private CollaboratorService collaboratorService;

    @MockBean
    private CollaboratorRepository collaboratorRepository;

    @TestConfiguration
    static class CollaboratorServiceImplConfiguration{
        @Bean
        public CollaboratorService postService(){
            return new CollaboratorServiceImpl();
        }
    }

    @Test
    @DisplayName("When createReview But ScoreId Not Exists Return Resource Score not found for Id with value 1")
    public void CreateReviewButNotExists() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");

        Collaborator collaborator = new Collaborator();
        collaborator.setId(1L);
        collaborator.setUsername("Hugox");
        collaborator.setEmail("hugo@gmail.com");
        Mockito.when(collaboratorRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Collaborator","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Collaborator result = collaboratorService.getCollaboratorById(1L);
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
        Collaborator collaborator = new Collaborator();
        collaborator.setId(1L);
        collaborator.setUsername("Hugox");
        collaborator.setEmail("hugo@gmail.com");
        Mockito.when(collaboratorRepository.findById(1L))
                .thenReturn(Optional.of(collaborator));
        Mockito.when(collaboratorRepository.findCollaboratorByUsername("Hugox"))
                .thenReturn(Optional.of(collaborator));
        String expectedMessage = "The username Hugox is begin used by another user";
        //Act
        Collaborator collaborator1 = new Collaborator();
        collaborator1.setId(2L);
        collaborator1.setUsername("Hugox");
        Throwable exception = catchThrowable(()-> {
            Collaborator result = collaboratorService.createCollaborator(collaborator1);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
