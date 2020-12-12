package com.sajed.controller;

import com.sajed.models.Adult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdultControllerTest {

    AdultController adultController;

    @BeforeEach
    void setUp() {
        adultController = new AdultController();
    }

    @Test
    void cleanErrorTest1() {

        Adult expectedAdult = new Adult();
        expectedAdult.setAdultId(null);

        Adult input = new Adult();
        input.setAdultId(0);

        adultController.cleanError(input);

        assertEquals(expectedAdult, input);
    }

    @Test
    void cleanErrorTest2() {

        Adult expectedAdult = new Adult();
        expectedAdult.setAdultId(5);

        Adult input = new Adult();
        input.setAdultId(5);

        adultController.cleanError(input);

        assertEquals(expectedAdult, input);
    }
}