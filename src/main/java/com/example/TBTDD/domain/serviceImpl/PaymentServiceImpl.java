package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.PaymentRepository;
import com.example.TBTDD.domain.service.PaymentService;
import com.example.TBTDD.persistence.DTO.PaymentDTO;
import com.example.TBTDD.persistence.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public List<PaymentDTO> findAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        payments.forEach(
                payment -> paymentDTOS.add(PaymentDTO.toDTO(payment))
        );
        return paymentDTOS;
    }

    @Override
    public PaymentDTO getPaymentById(String paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        if (payment.isPresent()) {
            return PaymentDTO.toDTO(payment.get());
        }
        return null;
    }

    @Override
    public List<PaymentDTO> getPaymentsByTypeAndYearOrganized(int year, String paymentType) {
        List<Payment> payments = paymentRepository.getPaymentsByTypeAndYearOrganized(year, paymentType);
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        payments.forEach(
                payment -> paymentDTOS.add(PaymentDTO.toDTO(payment))
        );
        return paymentDTOS;
    }

    @Override
    public List<Object> getPaymentMethods() {
        return paymentRepository.getPaymentMethods();
    }

    @Override
    public Double findAveragePaymentAmountIn2009() {
        return paymentRepository.findAveragePaymentAmountIn2009();
    }

    @Override
    public List<Object[]> getTotalPaymentsByYear() {
        return paymentRepository.getTotalPaymentsByYear();
    }

}
