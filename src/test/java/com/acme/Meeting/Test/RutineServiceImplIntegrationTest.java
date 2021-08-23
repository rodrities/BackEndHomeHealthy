package com.acme.Meeting.Test;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.repository.RutineRepository;
import com.acme.homehealthy.Meeting.domain.service.DietService;
import com.acme.homehealthy.Meeting.domain.service.RutineService;
import com.acme.homehealthy.Meeting.service.DietServiceImpl;
import com.acme.homehealthy.Meeting.service.RutineServiceImpl;
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
public class RutineServiceImplIntegrationTest {
    @Autowired
    private RutineService rutineService;

    @MockBean
    private RutineRepository rutineRepository;

    @TestConfiguration
    static class RutineServiceImplConfiguration{
        @Bean
        public RutineService postService(){
            return new RutineServiceImpl();
        }
    }

    @Test
    @DisplayName("When createRutine But With An Same Name Return This Rutine Name Is Begin Used")
    public void whenCreateRutineButWithAnSameNameReturnThisRutineNameIsBeginUsed() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Rutine rutine = new Rutine();
        rutine.setId(1L);
        rutine.setName("Saltarin");
        // NO funca por la nueva version
        //Mockito.when(rutineRepository.findRoutineByName(rutine.getName()))
          //      .thenReturn(Optional.of(rutine));
        String expectedMessage = "This rutine name is begin used";
        //Act
        Rutine rutine1 = new Rutine();
        rutine1.setId(2L);
        rutine1.setName("Saltarin");
        Throwable exception = catchThrowable(()-> {
            //Rutine result = rutineService.createRutine(rutine1);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When findDiet But Diet Not Exists Return Resource Diet Not Found For Id With Value 1")
    public void WhenfindDietButDietNotExistsReturnResourceDietNotFoundForIdWithValue1() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Mockito.when(rutineRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Rutine","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Rutine result = rutineService.getRutineById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
