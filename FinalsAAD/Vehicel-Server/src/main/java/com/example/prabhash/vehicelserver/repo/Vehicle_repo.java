package com.example.prabhash.vehicelserver.repo;

import com.example.prabhash.vehicelserver.entity.Vehicle_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Vehicle_repo extends JpaRepository<Vehicle_entity,String> {
    Optional<Vehicle_entity> findByVehicleName(String vehicleName);
    Optional<Vehicle_entity> findByVehicleBrand(String vehicleBrand);


    List<Vehicle_entity> findByPackageId(String packageId);
}
