package com.acme.Social.Test;

import com.acme.homehealthy.Social.domain.model.Reason;
import com.acme.homehealthy.Social.domain.model.Score;
import com.acme.homehealthy.Social.domain.repository.ReasonRepository;
import com.acme.homehealthy.Social.domain.service.ReasonService;
import com.acme.homehealthy.Social.service.ReasonServiceImpl;
import com.acme.homehealthy.Social.service.ScoreServiceImpl;
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
public class ReasonServiceImplIntegration {

    @Autowired
    private ReasonService reasonService;

    @MockBean
    private ReasonRepository reasonRepository;

    @TestConfiguration
    static class ReasonServiceImplConfiguration{
        @Bean
        public ReasonService postService(){
            return new ReasonServiceImpl();
        }
    }


    @Test
    @DisplayName("When createScored With An Name Existis Return Message This Description Exists")
    public void  asd() {
        //Arrange
        String message= "This description exists";
        Reason reason = new Reason();
        reason.setId(1L);
        reason.setDescription("¿Problemas con la aplicacion web?");
        Mockito.when(reasonRepository.findReasonByDescription(reason.getDescription()))
                .thenReturn(Optional.of(reason));
        //Act
        Reason reason2 = new Reason();
        reason2.setId(2L);
        reason2.setDescription("¿Problemas con la aplicacion web?");

        Throwable exception = catchThrowable(()-> {
            Reason result = reasonService.createReason(reason2);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("When findById With An Id Not Existis Return Message Resource Reason Not Found For Id With Value 1")
    public void aasd() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Mockito.when(reasonRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Reason","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Reason result = reasonService.getReasonById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
