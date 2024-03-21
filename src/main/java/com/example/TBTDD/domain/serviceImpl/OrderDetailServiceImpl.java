package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.OrderDetailRepository;
import com.example.TBTDD.domain.service.OrderDetailService;
import com.example.TBTDD.persistence.DTO.OrderDetailDTO;
import com.example.TBTDD.persistence.embeddable.OrderDetailId;
import com.example.TBTDD.persistence.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetailDTO> findAllOrderDetails() {
        List<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();
        List<OrderDetail> orderDetailIds = orderDetailRepository.findAll();
        orderDetailIds.forEach(orderDetailId -> {
            OrderDetailDTO orderDetailDTO = OrderDetailDTO.toDTO(orderDetailId);
            orderDetailDTOs.add(orderDetailDTO);
        });
        return orderDetailDTOs;
    }

    @Override
    public OrderDetailDTO getOrderDetail(OrderDetailId orderDetailId) {
        OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).get();
        OrderDetailDTO orderDetailDTO = OrderDetailDTO.toDTO(orderDetail);
        return orderDetailDTO;
    }

    @Override
    public List<Object[]> findBestSellingProducts() {
        return orderDetailRepository.findBestSellingProducts();
    }

    @Override
    public Object[] calculateBilling() {
        return orderDetailRepository.calculateBilling();
    }
    @Override
    public List<Object[]> calculateBillingByProduct() {
        return orderDetailRepository.calculateBillingByProduct();
    }

    @Override
    public List<Object[]> calculateBillingByProductWithOR() {
        return orderDetailRepository.calculateBillingByProductWithOR();
    }

    @Override
    public List<Object[]> showVentsGreaterthan3000() {
        return orderDetailRepository.showVentsGreaterthan3000();
    }


    }