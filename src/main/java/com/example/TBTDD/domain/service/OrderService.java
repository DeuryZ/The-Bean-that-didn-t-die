package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findAllOrders();
    OrderDTO getOrderById(Integer orderId);
}
