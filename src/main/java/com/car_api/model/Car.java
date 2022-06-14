package com.car_api.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * model for Car entity.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue
    private @Getter int id;
    @NotEmpty(message = "Brand cannot be empty")
    private @Getter @Setter String brand;
    @NotEmpty(message = "Car model cannot be empty")
    private @Getter @Setter String carModel;
    @NotEmpty(message = "Category cannot be empty")
    private @Getter @Setter String category;
    @NotEmpty(message = "Price cannot be empty")
    private @Getter @Setter Long price;
    @NotEmpty(message = "Mileage cannot be empty")
    private @Getter @Setter float mileage;
    @NotEmpty(message = "Release date cannot be empty")
    private @Getter @Setter String releaseDate;


}
