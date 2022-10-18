package com.task.simple.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
@Data
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MODEL",nullable = false)
    private String model;
    @Column(name = "PLATE",unique = true,nullable = false)
    private String plate;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID",referencedColumnName = "ID",nullable = false)
    private OwnerModel ownerId;
}
