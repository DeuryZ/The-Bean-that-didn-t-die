package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.embeddable.OrderDetailId;

import java.math.BigDecimal;

public class OrderDetailDTO {

    private OrderDetailId id;
    private int quantity;
    private BigDecimal unitPrice;
    private short lineNumber;

    public OrderDetailDTO() {
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

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
