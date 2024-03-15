package com.example.TBTDD.persistence.DTO;

import com.example.TBTDD.persistence.entity.Order;

import java.time.LocalDate;

public class OrderDTO {
    private int  orderCode;
    private LocalDate dateOrder;
    private LocalDate expectedDate;
    private LocalDate deliveredDate;
    private String state;
    private String comments;

    public OrderDTO() {
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCode=" + orderCode +
                ", dateOrder=" + dateOrder +
                ", expectedDate=" + expectedDate +
                ", deliveredDate=" + deliveredDate +
                ", state='" + state + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderCode(order.getOrderCode());
        orderDTO.setDateOrder(order.getDateOrder());
        orderDTO.setExpectedDate(order.getExpectedDate());
        orderDTO.setDeliveredDate(order.getDeliveredDate());
        orderDTO.setState(order.getState());
        orderDTO.setComments(order.getComments());
        return orderDTO;
    }

    public static Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderCode(orderDTO.getOrderCode());
        order.setDateOrder(orderDTO.getDateOrder());
        order.setExpectedDate(orderDTO.getExpectedDate());
        order.setDeliveredDate(orderDTO.getDeliveredDate());
        order.setState(orderDTO.getState());
        order.setComments(orderDTO.getComments());
        return order;
    }
}
