package com.task.simple.services;

import com.task.simple.dto.CarDTO;
import com.task.simple.models.CarModel;

import java.util.List;

public interface CarService {
    CarModel add(CarDTO carDTO);

    CarModel getById(Long id);

    List<CarModel> getAll(CarSearchCriteria carSearchCriteria);
}
