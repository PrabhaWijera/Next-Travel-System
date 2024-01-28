package com.example.user_server.user.repo;

import com.example.user_server.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_repo extends JpaRepository<UserEntity,String> {


    Optional<UserEntity> findByUserName (String userName);



}
