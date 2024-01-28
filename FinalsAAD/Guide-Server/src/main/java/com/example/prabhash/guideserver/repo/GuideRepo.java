package com.example.prabhash.guideserver.repo;

import com.example.prabhash.guideserver.entity.Guide_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepo extends MongoRepository<Guide_entity,String> {
    Optional<Guide_entity> findByGuideName(String guideName);


}
