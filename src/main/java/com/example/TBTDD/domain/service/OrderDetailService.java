package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.OrderDetailDTO;
import com.example.TBTDD.persistence.embeddable.OrderDetailId;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDTO> findAllOrderDetails();
    OrderDetailDTO getOrderDetail(OrderDetailId orderDetailId);
}
