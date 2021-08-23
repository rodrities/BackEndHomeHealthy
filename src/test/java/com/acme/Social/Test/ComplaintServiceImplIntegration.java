package com.acme.Social.Test;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Social.domain.model.Complaint;
import com.acme.homehealthy.Social.domain.model.Reason;
import com.acme.homehealthy.Social.domain.repository.ComplaintRepository;
import com.acme.homehealthy.Social.domain.repository.ReasonRepository;
import com.acme.homehealthy.Social.domain.repository.ScoreRepository;
import com.acme.homehealthy.Social.domain.service.ComplaintService;
import com.acme.homehealthy.Social.domain.service.ReasonService;
import com.acme.homehealthy.Social.service.ComplaintServiceImpl;
import com.acme.homehealthy.Social.service.ReasonServiceImpl;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
public class ComplaintServiceImplIntegration {

    @Autowired
    private ComplaintService complaintService;

    @MockBean
    private ComplaintRepository complaintRepository;

    @MockBean
    private ReasonRepository reasonRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @TestConfiguration
    static class ComplaintServiceImplConfiguration{
        @Bean
        public ComplaintService postService(){
            return new ComplaintServiceImpl();
        }
    }

    @Test
    @DisplayName("When createComplaint But CustomerId Not Exists Return Resource Customer not found for Id with value 1")
    public void  asd() {
        //Arrange
        Reason reason = new Reason();
        reason.setId(1L);
        String template = ("Resource %s not found for %s with value %s");
        Mockito.when(reasonRepository.findById(1L))
                .thenReturn(Optional.of(reason));
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Customer","Id",1L);
        //Act
        Complaint complaint = new Complaint();
        complaint.setId(1L);
        Throwable exception = catchThrowable(()-> {
            Complaint result = complaintService.createComplaint(1L,1L,complaint);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When createComplaint But ReasonId Not Exists Return Resource Reason not found for Id with value 1")
    public void  aasd() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Customer customer = new Customer();
        customer.setId(1L);
        Mockito.when(reasonRepository.findById(1L))
                .thenReturn(Optional.empty());
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
        String expectedMessage = String.format(template, "Reason","Id",1L);
        //Act
        Complaint complaint = new Complaint();
        complaint.setId(1L);
        Throwable exception = catchThrowable(()-> {
            Complaint result = complaintService.createComplaint(1L,1L,complaint);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    @DisplayName("When findComplaintById But ComplaintId Not Exists Return Resource Complaint not found for Id with value 1")
    public void aaasd() {
        //Arrange
        String template = ("Resource %s not found for %s with value %s");
        Mockito.when(complaintRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Complaint","Id",1L);
        //Act
        Throwable exception = catchThrowable(()-> {
            Complaint result = complaintService.getComplaintById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }
}
