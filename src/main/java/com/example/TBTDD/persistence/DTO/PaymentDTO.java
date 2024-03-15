package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.entity.Client;
import com.example.TBTDD.persistence.entity.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentDTO {
    private String transactionId;
    private Client client;
    private String paymentMethod;
    private LocalDate date;
    private BigDecimal total;

    public PaymentDTO() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "transactionId='" + transactionId + '\'' +
                ", client=" + client +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", date=" + date +
                ", total=" + total +
                '}';
    }

    public static PaymentDTO toDTO(com.example.TBTDD.persistence.entity.Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setTransactionId(payment.getTransactionId());
        paymentDTO.setClient(payment.getClient());
        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
        paymentDTO.setDate(payment.getDate());
        paymentDTO.setTotal(payment.getTotal());
        return paymentDTO;
    }

    public static Payment toEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setTransactionId(paymentDTO.getTransactionId());
        payment.setClient(paymentDTO.getClient());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setDate(paymentDTO.getDate());
        payment.setTotal(paymentDTO.getTotal());
        return payment;
    }
}
