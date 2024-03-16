package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findAllOrders();
    OrderDTO getOrderById(Integer orderId);
    List<Object> getStates();
    List<Object> getOrdersDeliveredAfterExpected();
    List<Object> getOrdersInDelivery(int days);
    List<OrderDTO> getOrdersByStateAndYear(String state, int year);
    List<OrderDTO> getOrdersByStateAndMonth(String state, int month);
}
