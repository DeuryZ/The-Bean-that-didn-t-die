package com.example.TBTDD.persistence.entity;


import com.example.TBTDD.persistence.embeddable.OrderDetailId;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "detalle_pedido")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @Column(name = "cantidad", length = 11)
    private int quantity;

    @Column (name ="precio_unidad", precision= 15 ,scale =2)
    private BigDecimal unitPrice;

    @Column (name = "numero_linea", length = 6)
    private short lineNumber;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailId id, int quantity, BigDecimal unitPrice, short lineNumber) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.lineNumber = lineNumber;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(short lineNumber) {
        this.lineNumber = lineNumber;
    }
}
