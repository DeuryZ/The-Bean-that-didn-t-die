package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.OrderRepository;
import com.example.TBTDD.domain.service.OrderService;
import com.example.TBTDD.persistence.DTO.OrderDTO;
import com.example.TBTDD.persistence.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderDTO> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();
        orders.forEach(order -> {
            OrderDTO orderDTO = OrderDTO.toDTO(order);
            orderDTOs.add(orderDTO);
        });
        return orderDTOs;
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId).get();
        OrderDTO orderDTO = OrderDTO.toDTO(order);
        return orderDTO;
    }


}
