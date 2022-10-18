package com.task.simple.dto;

import com.task.simple.models.CarModel;
import lombok.Data;

@Data
public class CarDTO {
    private String model;
    private String plate;
    private Long ownerId;

    public CarModel mapping(){
        CarModel carModel = new CarModel();

        carModel.setModel(model);
        carModel.setPlate(plate);

        return carModel;
    }
}
