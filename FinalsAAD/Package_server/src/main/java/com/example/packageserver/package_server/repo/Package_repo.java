package com.example.packageserver.package_server.repo;

import com.example.packageserver.package_server.entity.Package_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Package_repo extends JpaRepository<Package_entity,String> {
    @Query("SELECT p.package_id from Package_entity p order by p.package_id DESC ")
    List<Integer> getAllID();

    Optional<Package_entity> findByPackageCategory(String category);
}
