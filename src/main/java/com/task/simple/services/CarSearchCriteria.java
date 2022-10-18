package com.task.simple.services;

import lombok.Data;

@Data
public class CarSearchCriteria {
    private String model;
    private String plate;
    private String ownerName;
}
