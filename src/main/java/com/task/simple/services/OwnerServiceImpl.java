package com.task.simple.services;

import com.task.simple.models.OwnerModel;
import com.task.simple.repositories.OwnerRepository;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public OwnerModel add(OwnerModel ownerModel) throws PropertyValueException{
        if(ownerModel.getAge() != null && ownerModel.getAge() < 18){
            //not the best exception for this situation but just for demonstration
            throw new RuntimeException("Can't be owner if you less than 18");
        }
            return ownerRepository.saveAndFlush(ownerModel);
    }

    @Override
    public OwnerModel getById(Long id){
        return Optional.ofNullable(ownerRepository.getOwnerModelById(id))
                .orElseThrow(()-> new EntityNotFoundException("Not Found"));
    }

}
