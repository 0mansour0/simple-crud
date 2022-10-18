package com.task.simple.repositories;

import com.task.simple.models.OwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerModel,Long> {
    OwnerModel getOwnerModelById(Long id);
}
