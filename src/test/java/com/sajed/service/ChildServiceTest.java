package com.sajed.service;

import com.sajed.main.FamilyApplication;
import com.sajed.models.Child;
import com.sajed.repository.ChildRepository;
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
class ChildServiceTest {

    @Autowired
    private ChildService childService;

    @MockBean
    private ChildRepository childRepository;

    @BeforeEach
    void setUp() {
        Child john = new Child("john");
        Child bob = new Child("bob");
        Child alex = new Child("alex");

        List<Child> allChilds = Arrays.asList(john, bob, alex);
        Mockito.when(childService.findByIsDeletedFalse()).thenReturn(allChilds);
        Mockito.when(childService.save(alex)).thenReturn(alex);
    }


    @Test
    public void givenAllChildsThenReturn3Records() {
        Child alex = new Child("alex");
        Child john = new Child("john");
        Child bob = new Child("bob");

        List<Child> allChilds = childService.findByIsDeletedFalse();
        assertThat(allChilds).hasSize(3).extracting(Child::getFirstName).contains(alex.getFirstName(),
                john.getFirstName(), bob.getFirstName());
        assertThat(allChilds).hasSize(3).extracting(Child::getIsDeleted).contains(alex.getIsDeleted(),
                john.getIsDeleted(), bob.getIsDeleted());

    }


    @Test
    public void save() {
        Child alex = new Child("alex");

        Child found = childService.save(alex);
        assertEquals(alex, found);

    }

}