package com.task.simple.services;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.task.simple.dto.CarDTO;
import com.task.simple.models.CarModel;
import com.task.simple.models.QCarModel;
import com.task.simple.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;
    @Autowired
    OwnerService ownerService;
    @Autowired
    EntityManager em;
    JPAQuery<CarModel> queryFactory;
    QCarModel qCar;

    @Override
    public CarModel add(CarDTO carDTO) {
        CarModel carModel = carDTO.mapping();
        carModel.setOwnerId(Optional.ofNullable(ownerService.getById(carDTO.getOwnerId()))
                .orElseThrow(()-> new EntityNotFoundException("Not Found")));

        return carRepository.saveAndFlush(carModel);
    }

    @Override
    public CarModel getById(Long id){
        return Optional.ofNullable(carRepository.getCarModelById(id))
                .orElseThrow(()-> new EntityNotFoundException("Not Found"));
    }

    @Override
    public List<CarModel> getAll(CarSearchCriteria carSearchCriteria){
        boolean returnResult = false;

        queryFactory = new JPAQuery<>(em);
        qCar = QCarModel.carModel;

        BooleanBuilder where = new BooleanBuilder();

        if(!carSearchCriteria.getModel().isEmpty()){
            where.and(qCar.model.contains(carSearchCriteria.getModel()));
            returnResult = true;
        }
        if(!carSearchCriteria.getPlate().isEmpty()){
            where.and(qCar.plate.contains(carSearchCriteria.getPlate()));
            returnResult = true;
        }
        if(!carSearchCriteria.getOwnerName().isEmpty()){
            where.and(qCar.ownerId.name.contains(carSearchCriteria.getOwnerName()));
            returnResult = true;
        }

        if(returnResult){
            return queryFactory
                    .select(qCar)
                    .from(qCar)
                    .where(where)
                    .fetch();
        }else {
            return queryFactory
                    .select(qCar)
                    .from(qCar)
                    .fetch();
        }
    }
}
