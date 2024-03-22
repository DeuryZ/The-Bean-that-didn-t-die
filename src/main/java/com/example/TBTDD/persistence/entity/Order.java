package com.example.TBTDD.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "pedido")
public class Order {

    @Id
    @Column(name="codigo_pedido", length = 11)
    private int  orderCode;


    @Column(name = "fecha_pedido")
    private LocalDate dateOrder;

    @Column(name = "fecha_esperada")
    private LocalDate expectedDate;

    @Column (name="fecha_entregada",nullable = true )
    private LocalDate deliveredDate;

    @Column (name="estado", length = 15)
    private String state;

    @Column (name = "comentarios", nullable = true)
    private String comments;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "codigo_cliente")
    private Client client;


    public Order() {
    }
    public Order(int orderCode, LocalDate dateOrder, LocalDate expectedDate, LocalDate deliveredDate, String state, String comments ,Client clients) {
        this.orderCode = orderCode;
        this.dateOrder = dateOrder;
        this.expectedDate = expectedDate;
        this.deliveredDate = deliveredDate;
        this.state = state;
        this.comments = comments;
        this.client = clients;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public LocalDate getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}