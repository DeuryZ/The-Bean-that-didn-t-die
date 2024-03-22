package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.embeddable.OrderDetailId;
import com.example.TBTDD.persistence.entity.Order;
import com.example.TBTDD.persistence.entity.OrderDetail;

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

    public static OrderDetailDTO toDTO(OrderDetail orderDetail) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setUnitPrice(orderDetail.getUnitPrice());
        orderDetailDTO.setLineNumber(orderDetail.getLineNumber());
        return orderDetailDTO;
    }

    public static OrderDetail toEntity(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailDTO.getId());
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setUnitPrice(orderDetailDTO.getUnitPrice());
        orderDetail.setLineNumber(orderDetailDTO.getLineNumber());
        return orderDetail;
    }

}
