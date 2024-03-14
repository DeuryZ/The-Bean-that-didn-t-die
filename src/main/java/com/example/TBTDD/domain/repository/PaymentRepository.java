package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
