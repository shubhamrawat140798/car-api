package com.car_api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    private Car car;
    /**
     * object creation for testing.
     */
    @BeforeEach
    void setup(){
        car = new Car();
    }
    /**
     * Tests for object.
     */
    @Test
    void Brand(){
        car.setBrand("Hyundai");
        assertEquals("Hyundai",car.getBrand());
    }
    @Test
    void CarModel(){
        car.setCarModel("Verna");
        assertEquals("Verna",car.getCarModel());
    }
    @Test
    void Category(){
        car.setCategory("Sedan");
        assertEquals("Sedan",car.getCategory());
    }
    @Test
    void Mileage(){
        car.setMileage(24.2F);
        assertEquals(24.2F,car.getMileage());
    }
    @Test
    void Price(){
        car.setPrice(933000L);
        assertEquals(933000L,car.getPrice());
    }
}