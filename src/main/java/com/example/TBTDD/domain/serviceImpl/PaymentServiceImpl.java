package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.PaymentRepository;
import com.example.TBTDD.domain.service.PaymentService;
import com.example.TBTDD.persistence.DTO.PaymentDTO;
import com.example.TBTDD.persistence.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentDTO> findAllPayments() {
        List<PaymentDTO> paymentDTOs = new ArrayList<>();
        List<Payment> payments = paymentRepository.findAll();
        payments.forEach(payment -> {
            PaymentDTO paymentDTO = PaymentDTO.toDTO(payment);
            paymentDTOs.add(paymentDTO);
        });
        return paymentDTOs;
    }

    @Override
    public PaymentDTO getPaymentById(String paymentId) {
        Payment payment = paymentRepository.findById(paymentId).get();
        PaymentDTO paymentDTO = PaymentDTO.toDTO(payment);
        return paymentDTO;
    }
}
