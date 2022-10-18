package com.task.simple.controllers;

import com.task.simple.dto.CarDTO;
import com.task.simple.models.CarModel;
import com.task.simple.services.CarSearchCriteria;
import com.task.simple.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping
    public ResponseEntity<CarModel> add(@RequestBody CarDTO carDTO){
        try{
            return new ResponseEntity<>(carService.add(carDTO), HttpStatus.OK);
        }catch (EntityNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping
    public ResponseEntity<CarModel> getById(@RequestParam Long id){
        try{
            return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
        }catch (EntityNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("list")
    public ResponseEntity<List<CarModel>> getAll(CarSearchCriteria carSearchCriteria){
        return new ResponseEntity<>(carService.getAll(carSearchCriteria),HttpStatus.OK);
    }
}
