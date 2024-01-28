package com.example.prabhash.hotelserver.repo;

import com.example.prabhash.hotelserver.entity.Hotel_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Hotel_repo extends JpaRepository<Hotel_entity,String> {
    Optional<Hotel_entity> findByHotelName(String hotelName);

    List<Hotel_entity> findByPackageId(String packageId);

}
