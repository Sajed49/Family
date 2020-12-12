package com.sajed.controller;

import com.sajed.models.Child;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChildControllerTest {

    ChildController childController;


    @BeforeEach
    void setUp() {
        childController = new ChildController();
    }

    @Test
    void cleanErrorTest1() {

        Child expectedChild = new Child();
        expectedChild.setChildId(null);

        Child input = new Child();
        input.setChildId(0);

        childController.cleanError(input);

        assertEquals(expectedChild, input);
    }

    @Test
    void cleanErrorTest2() {

        Child expectedChild = new Child();
        expectedChild.setChildId(5);

        Child input = new Child();
        input.setChildId(5);

        childController.cleanError(input);

        assertEquals(expectedChild, input);
    }
}