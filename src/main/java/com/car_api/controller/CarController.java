package com.car_api.controller;

import com.car_api.model.Car;
import com.car_api.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller.
 * @author shubham singh rawat.
 * @version 1.0 .
 */
@RestController
@RequestMapping(path = "/car/v1")
public class CarController {
    @Autowired
    CarService carService;
    @PostMapping(path = "/add")
    public @ResponseBody String addCar(@RequestBody Car receivedCar){
        return carService.addCar(receivedCar);
    }
    @GetMapping(path = "/all")
    public @ResponseBody List<Car> fetchAll(){
        return carService.fetchAll();
    }
    @PutMapping(path = "/edit")
    public @ResponseBody String editCar(@RequestBody Car receivedCar){
        return carService.editCar(receivedCar);
    }
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteCar(@RequestBody Car receivedCar){
        return carService.deleteCar(receivedCar);
    }
}
