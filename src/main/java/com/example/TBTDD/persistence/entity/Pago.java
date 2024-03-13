package com.example.TBTDD.persistence.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity(name = "pago")
public class Pago {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente clientId;

    @Column(name="forma_pago", length = 40)
    private String paymentMethod;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion", length = 50)
    private String transactionId;

    @Column(name="fecha_pago")
    private LocalDate date;

    @Column(name="total", precision = 15, scale = 2)
    private double total;

    public Pago() {
    }

    public Pago(Cliente clientId, String paymentMethod, String transactionId, LocalDate date, double total) {
        this.clientId = clientId;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.date = date;
        this.total = total;
    }

    public Cliente getClientId() {
        return clientId;
    }

    public void setClientId(Cliente clientId) {
        this.clientId = clientId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "clientId=" + clientId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", date=" + date +
                ", total=" + total +
                '}';
    }

}
