package com.acme.Meeting.Test;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.repository.CollaboratorRepository;
import com.acme.homehealthy.Initialization.domain.service.CollaboratorService;
import com.acme.homehealthy.Initialization.service.CollaboratorServiceImpl;
import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.service.DietService;
import com.acme.homehealthy.Meeting.service.DietServiceImpl;
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
public class DietServiceImplIntegrationTest {
    @Autowired
    private DietService dietService;

    @MockBean
    private DietRepository dietRepository;

    @TestConfiguration
    static class DietServiceImplConfiguration{
        @Bean
        public DietService postService(){
            return new DietServiceImpl();
        }
    }

    @Test
    @DisplayName("When createDiet But With An Same Name Return This Diet Name Is Begin Used")
    public void whenCreateDietButWithAnSameNameReturnThisDietNameIsBeginUsed() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Diet diet = new Diet();
        diet.setId(1L);
        diet.setName("Brocolin");
        Mockito.when(dietRepository.findDietByname(diet.getName()))
                .thenReturn(Optional.of(diet));
        String expectedMessage = "This diet name is begin used";
        //Act
        Diet diet1 = new Diet();
        diet1.setName("Brocolin");
        Throwable exception = catchThrowable(()-> {
            // Comentado porque se cambio el dietService
           // Diet result = dietService.createDiet(diet1,1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When findDiet But Diet Not Exists Return Resource Diet Not Found For Id With Value 1")
    public void WhenFindDietButDietNotExistsReturnResourceDietNotFoundForIdWithValue1() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Mockito.when(dietRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Diet","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Diet result = dietService.getDietById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
