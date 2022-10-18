package com.task.simple.services;

import com.task.simple.models.OwnerModel;
import org.hibernate.PropertyValueException;

public interface OwnerService {
    OwnerModel add(OwnerModel ownerModel) throws PropertyValueException;

    OwnerModel getById(Long id);
}
