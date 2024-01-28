package com.example.prabhash.paymentserver.repo;

import com.example.prabhash.paymentserver.entity.Payment_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment_entity,String> {
}
