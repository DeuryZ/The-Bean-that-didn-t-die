package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.OrderDetailDTO;
import com.example.TBTDD.persistence.embeddable.OrderDetailId;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {
    List<OrderDetailDTO> findAllOrderDetails();
    OrderDetailDTO getOrderDetail(OrderDetailId orderDetailId);

    List<Object[]> findBestSellingProducts();

    Object[] calculateBilling();
    List<Object[]> calculateBillingByProduct();

    List<Object[]> calculateBillingByProductWithOR();
    List<Object[]> showVentsGreaterthan3000();
}
