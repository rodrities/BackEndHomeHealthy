package com.acme.Meeting.Test;

import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Meeting.domain.repository.SessionRepository;
import com.acme.homehealthy.Meeting.domain.service.SessionService;
import com.acme.homehealthy.Meeting.service.SessionServiceImpl;
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
public class SessionServiceImplIntegrationTest {
    @Autowired
    private SessionService sessionService;

    @MockBean
    private SessionRepository sessionRepository;

    @MockBean
    private CustomerRepository customerRepository;


    @TestConfiguration
    static class SessionServiceImplConfiguration{
        @Bean
        public SessionService postService(){
            return new SessionServiceImpl();
        }
    }

    @Test
    @DisplayName("When findSession But With CustomerId and SessionId Return Session Not Found With Id 1 And CustomerId 1")
    public void WhenfindSessionButWithCustomerIdAndSessionIdReturnSessionNotFoundWithId1AndCustomerId1() {
        //Arrange
        Mockito.when(sessionRepository.findByIdAndCustomerId(1L,1L))
                .thenReturn(Optional.empty());
        String expectedMessage = "Session not found with Id 1 and CustomerId 1";
        //Act
        Throwable exception = catchThrowable(()-> {
            Session result = sessionService.getSessionByIdAndUserId(1L,1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When createSession But CustomerId Not Exists Return Resource Customer Not Found For Id With Value 1")
    public void WhencreateSessionButCustomerIdNotExistsReturnResourceCustomerNotFoundForIdWithValue1() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template,"User","Id",1);
        //Act
        Session session = new Session();
        session.setId(1L);
        Throwable exception = catchThrowable(()-> {
            Session result = sessionService.createSession(1L,1L,session);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }


}
