package com.example.email.emailservice.repo;


import com.example.email.emailservice.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OTPRepo extends JpaRepository<OTP,String> {

    Optional<OTP>findByEmail(String email);
}
