package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.entity.Client;
import com.example.TBTDD.persistence.entity.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentDTO {
    private String transactionId;
    private int clientId;
    private String clientName;
    private String paymentMethod;
    private LocalDate date;
    private BigDecimal total;

    public PaymentDTO() {
    }

    public PaymentDTO(String transactionId, int clientId, String clientName, String paymentMethod, LocalDate date, BigDecimal total) {
        this.transactionId = transactionId;
        this.clientId = clientId;
        this.clientName = clientName;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.total = total;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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
    public static PaymentDTO toDTO(Payment payment){
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setTransactionId(payment.getTransactionId());
        paymentDTO.setClientId(payment.getClient().getClientId());
        paymentDTO.setClientName(payment.getClient().getClientName());
        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
        paymentDTO.setDate(payment.getDate());
        paymentDTO.setTotal(payment.getTotal());
        return paymentDTO;
    }
    public static Payment toEntity(PaymentDTO paymentDTO){
        Payment payment = new Payment();
        payment.setTransactionId(paymentDTO.getTransactionId());
        Client client = new Client();
        client.setClientId(paymentDTO.getClientId());
        payment.setClient(client);
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setDate(paymentDTO.getDate());
        payment.setTotal(paymentDTO.getTotal());
        return payment;
    }
}
