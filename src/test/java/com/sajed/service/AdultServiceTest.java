package com.sajed.service;

import com.sajed.main.FamilyApplication;
import com.sajed.models.Adult;
import com.sajed.repository.AdultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = FamilyApplication.class)
class AdultServiceTest {

    @Autowired
    private AdultService adultService;

    @MockBean
    private AdultRepository adultRepository;

    @BeforeEach
    void setUp() {

        Adult john = new Adult("john");
        Adult bob = new Adult("bob");
        Adult alex = new Adult("alex");

        List<Adult> allAdults = Arrays.asList(john, bob, alex);
        Mockito.when(adultService.findByIsDeletedFalse()).thenReturn(allAdults);
        Mockito.when(adultService.save(alex)).thenReturn(alex);

    }


    @Test
    public void givenAllAdultsThenReturn3Records() {
        Adult alex = new Adult("alex");
        Adult john = new Adult("john");
        Adult bob = new Adult("bob");

        List<Adult> allAdults = adultService.findByIsDeletedFalse();
        assertThat(allAdults).hasSize(3).extracting(Adult::getFirstName).contains(alex.getFirstName(),
                john.getFirstName(), bob.getFirstName());
        assertThat(allAdults).hasSize(3).extracting(Adult::getIsDeleted).contains(alex.getIsDeleted(),
                john.getIsDeleted(), bob.getIsDeleted());

    }


    @Test
    public void save() {
        Adult alex = new Adult("alex");

        Adult found = adultService.save(alex);
        assertEquals(alex, found);

    }
}