package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> findAllPayments();
    PaymentDTO getPaymentById(String paymentId);
    List<PaymentDTO> getPaymentsByTypeAndYearOrganized(int year, String paymentType);
    List<Object> getPaymentMethods();
    Double findAveragePaymentAmountIn2009();
    List<Object[]> getTotalPaymentsByYear();
}
