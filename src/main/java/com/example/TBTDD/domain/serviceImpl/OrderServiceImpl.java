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

    @Override
    public List<Object> getStates() {
        List<Object> states = orderRepository.getStates();
        return states;
    }

    @Override
    public List<Object> getOrdersDeliveredAfterExpected() {
        List<Object> orders = orderRepository.getOrdersDeliveredAfterExpected();

        return orders;
    }

    @Override
    public List<Object> getOrdersInDelivery(int days) {
        List<Object> orders = orderRepository.getOrdersInDelivery(days);
        return orders;
    }

    @Override
    public List<OrderDTO> getOrdersByStateAndYear(String state, int year) {
        List<Order> orders = orderRepository.getOrdersByStateAndYear(state, year);
        List<OrderDTO> orderDTOs = new ArrayList<>();
        orders.forEach(order -> {
            OrderDTO orderDTO = OrderDTO.toDTO(order);
            orderDTOs.add(orderDTO);
        });
        return orderDTOs;
    }

    @Override
    public List<OrderDTO> getOrdersByStateAndMonth(String state, int month) {
        List<Order> orders = orderRepository.getOrdersByStateAndMonth(state, month);
        List<OrderDTO> orderDTOs = new ArrayList<>();
        orders.forEach(order -> {
            OrderDTO orderDTO = OrderDTO.toDTO(order);
            orderDTOs.add(orderDTO);
        });
        return orderDTOs;
    }

    @Override
    public List<Object[]> amountOrderState() {
        return orderRepository.amountOrderState();
    }

    @Override
    public List<Object[]> findFirstAndLastOrderDatesByClient() {
        return orderRepository.findFirstAndLastOrderDatesByClient();
    }
    @Override
    public List<Object[]> sumTotalQuantityByOrder() {
        return orderRepository.sumTotalQuantityByOrder();
    }
}
