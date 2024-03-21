package com.example.TBTDD.web.controller;


import com.example.TBTDD.domain.serviceImpl.PaymentServiceImpl;
import com.example.TBTDD.persistence.DTO.PaymentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment resources")
public class PaymentController {
    private final PaymentServiceImpl paymentService;

    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "Get all payments for the application")
    @RequestMapping("/all")
    public List<PaymentDTO> findAllPayments() {
        return paymentService.findAllPayments();
    }

    @Operation(summary = "Get all payments for id in the application")
    @RequestMapping("/getPaymentById/{paymentId}")
    public PaymentDTO getPaymentById(@PathVariable String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }
    @Operation(summary = "Get all payments for type and year organized in the application")
    @RequestMapping("/getPaymentsByTypeAndYearOrganized/{year}/{paymentType}")
    public List<PaymentDTO> getPaymentsByTypeAndYearOrganized( @PathVariable int year,  @PathVariable String paymentType) {
        return paymentService.getPaymentsByTypeAndYearOrganized(year, paymentType);
    }

    @Operation(summary = "Get all payments Methods for the application")
    @RequestMapping("/getPaymentMethods")
    public List<Object> getPaymentMethods() {
        return paymentService.getPaymentMethods();
    }

    @Operation(summary = "Get average payments in 2009 for the application")
    @GetMapping("/average-payment-2009")
    public Double findAveragePaymentAmountIn2009() {
        return paymentService.findAveragePaymentAmountIn2009();
    }

    @Operation(summary = "Get totally payments in a year for the application")
    @GetMapping("/total-by-year")
    public List<Object[]> getTotalPaymentsByYear() {
        return paymentService.getTotalPaymentsByYear();
    }

}
