package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.OrderServiceImpl;
import com.example.TBTDD.persistence.DTO.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/all")
    public List<OrderDTO> findAllOrders() {
        return orderService.findAllOrders();
    }

    @RequestMapping("/findOrderById/{orderId}")
    public OrderDTO getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @RequestMapping("/getStates")
    public List<Object> getStates() {
        return orderService.getStates();
    }

    @RequestMapping("/getOrdersDeliveredAfterExpected")
    public List<Object> getOrdersDeliveredAfterExpected() {
        return orderService.getOrdersDeliveredAfterExpected();
    }

    @RequestMapping("/getOrdersInDelivery/{days}")
    public List<Object> getOrdersInDelivery(@PathVariable int days) {
        return orderService.getOrdersInDelivery(days);
    }

    @RequestMapping("/getOrdersByStateAndYear/{state}/{year}")
    public List<OrderDTO> getOrdersByStateAndYear(@PathVariable String state, @PathVariable int year) {
        return orderService.getOrdersByStateAndYear(state, year);
    }

    @RequestMapping("/getOrdersByStateAndMonth/{state}/{month}")
    public List<OrderDTO> getOrdersByStateAndMonth(@PathVariable String state, @PathVariable int month) {
        return orderService.getOrdersByStateAndMonth(state, month);
    }
    @GetMapping("/amount-by-state")
    public List<Object[]> amountOrderState() {
        return orderService.amountOrderState();
    }

    @GetMapping("/first-last-dates-by-client") // Retorna vacia
    public List<Object[]> findFirstAndLastOrderDatesByClient() {
        return orderService.findFirstAndLastOrderDatesByClient();
    }

    @GetMapping("/sum-total-quantity-by-order")
    public List<Object[]> sumTotalQuantityByOrder() {
        return orderService.sumTotalQuantityByOrder();
    }

}
