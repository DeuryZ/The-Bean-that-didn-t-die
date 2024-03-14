package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> findAllPayments();
    PaymentDTO getPaymentById(String paymentId);
}
