package com.task.simple.repositories;

import com.task.simple.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarModel,Long> {
    CarModel getCarModelById(Long id);
}
