package com.example.TBTDD.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.*;

@Entity
@Table(name = "pago")
public class Payment {

    @Id
    @Column(name = "id_transaccion", length = 50)
    private String transactionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "codigo_cliente", name = "codigo_cliente", nullable = false)
    private Client client;

    @Column(name="forma_pago", length = 40)
    private String paymentMethod;


    @Column(name="fecha_pago")
    private LocalDate date;

    @Column(name="total", precision = 15, scale = 2)
    private BigDecimal total;

    public Payment() {
    }

    public Payment(Client client, String paymentMethod, String transactionId, LocalDate date, BigDecimal total) {
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.date = date;
        this.total = total;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }



}
