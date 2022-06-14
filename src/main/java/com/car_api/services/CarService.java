package com.car_api.services;

import com.car_api.model.Car;
import com.car_api.repository.CarRepository;
import com.car_api.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    Validation validation;

    /**
     * for creating new car entry.
     * @param receivedCar user input.
     * @return [string] status of query.
     */
    public String addCar(final Car receivedCar){
        String error= validation.checkCarEntry(receivedCar);
        if (error == ""){
            carRepository.save(receivedCar);
            return "Car Saved.";
        }
        return error;
    }

    /**
     * To fetch all entries.
     * @return list of entries.
     */
    public List<Car> fetchAll(){
        return carRepository.findAll();
    }

    /**
     * to edit entry.
     * @param receivedCar input from user.
     * @return [string] status of the query.
     */
    public String editCar(final Car receivedCar){
        Car carForUpdation;
        String error = "";
        if (carRepository.existsById(receivedCar.getId())){
            carForUpdation = carRepository.getReferenceById(receivedCar.getId());
            if (receivedCar.getBrand() != null){
                carForUpdation.setBrand(receivedCar.getBrand());
            }
            if (receivedCar.getCarModel() != null){
                carForUpdation.setCarModel(receivedCar.getCarModel());
            }
            if(receivedCar.getCategory() != null){
                carForUpdation.setCategory(receivedCar.getCategory());
            }
            if (receivedCar.getMileage() != 0){
                carForUpdation.setMileage(receivedCar.getMileage());
            }
            if (receivedCar.getPrice() != null){
                carForUpdation.setPrice(receivedCar.getPrice());
            }
            if (receivedCar.getReleaseDate() != null){
                error = validation.checkDateFormat(receivedCar.getReleaseDate());
                if (error == ""){
                    carForUpdation.setReleaseDate(receivedCar.getReleaseDate());
                }
            }
            if(error == ""){
                carRepository.save(carForUpdation);
                return "Car is edited";
            }
            return error;
        }

        return "Car Does not exist";
    }

    /**
     * to delete previous entry.
     * @param receivedCar input form user.
     * @return [string] status of query.
     */
    public String deleteCar(final Car receivedCar){
        if (carRepository.existsById(receivedCar.getId())){
            carRepository.deleteById(receivedCar.getId());
            return "Car is deleted";
        }
        return "Car does not exist";
    }
}
