package com.example.TBTDD.web.controller;


import com.example.TBTDD.domain.serviceImpl.PaymentServiceImpl;
import com.example.TBTDD.persistence.DTO.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentServiceImpl paymentService;

    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping("/all")
    public List<PaymentDTO> findAllPayments() {
        return paymentService.findAllPayments();
    }

    @RequestMapping("/getPaymentById/{paymentId}")
    public PaymentDTO getPaymentById(@PathVariable String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @RequestMapping("/getPaymentsByTypeAndYearOrganized/{year}/{paymentType}")
    public List<PaymentDTO> getPaymentsByTypeAndYearOrganized( @PathVariable int year,  @PathVariable String paymentType) {
        return paymentService.getPaymentsByTypeAndYearOrganized(year, paymentType);
    }

    @RequestMapping("/getPaymentMethods")
    public List<Object> getPaymentMethods() {
        return paymentService.getPaymentMethods();
    }

}
