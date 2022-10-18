package com.task.simple.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OWNER")
@Data
public class OwnerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME",nullable = false)
    private String name;
    @Column(name = "AGE",nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "ownerId",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<CarModel> cars;
}
