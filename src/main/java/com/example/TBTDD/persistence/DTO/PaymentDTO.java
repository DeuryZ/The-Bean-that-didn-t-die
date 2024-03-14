package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.entity.Client;

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
}
