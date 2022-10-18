package com.task.simple.controllers;

import com.task.simple.models.OwnerModel;
import com.task.simple.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerModel> add(@RequestBody OwnerModel ownerModel){
        try{
            return new ResponseEntity<>(ownerService.add(ownerModel), HttpStatus.OK);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<OwnerModel> getById(@RequestParam Long id){
        try{
            return new ResponseEntity<>(ownerService.getById(id), HttpStatus.OK);
        }catch (EntityNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
