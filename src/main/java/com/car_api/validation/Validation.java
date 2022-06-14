package com.car_api.validation;

import com.car_api.model.Car;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validation {
    public String checkCarEntry(Car receivedCar){
        String error = "";
        if (receivedCar.getBrand() == null){
            error += "Brand cannot be empty.\n";
        }
        if (receivedCar.getCarModel() == null){
            error += "Model cannot be empty.\n";
        }
        if (receivedCar.getCategory() == null){
            error += "Category cannot be empty.\n";
        }
        if (receivedCar.getReleaseDate() == null){
            error += "ReleaseDate cannot be empty.\n";
        } else {
            if (checkDateFormat(receivedCar.getReleaseDate()) != "") {
                error += checkDateFormat(receivedCar.getReleaseDate());
            }
        }
        if (receivedCar.getPrice() == null){
            error += "Price cannot be empty.\n";
        }
        if (receivedCar.getMileage() == 0){
            error += "Mileage cannot be empty.\n";
        }
        return error;
    }
    public String checkDateFormat(String date){
        String regex = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        if (!matcher.matches()){
            return  "Refer to this [format dd-mm-yyyy]\n";
        }
        return "";
    }
}
