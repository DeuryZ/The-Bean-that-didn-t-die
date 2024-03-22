package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.OrderServiceImpl;
import com.example.TBTDD.persistence.DTO.OrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "order resources")
public class OrderController {
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
    @Operation(summary = "Get all Orders for the application")
    @RequestMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<OrderDTO> findAllOrders() {
        return orderService.findAllOrders();
    }

    @Operation(summary = "Get all order by id for the application")
    @RequestMapping("/findOrderById/{orderId}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public OrderDTO getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @Operation(summary = "Get all states for the application")
    @RequestMapping("/getStates")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> getStates() {
        return orderService.getStates();
    }
    @Operation(summary = "Get all orders delivered after expected for the application")
    @RequestMapping("/getOrdersDeliveredAfterExpected")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> getOrdersDeliveredAfterExpected() {
        return orderService.getOrdersDeliveredAfterExpected();
    }

    @Operation(summary = "Get all orders delivered in a time of days for the application")
    @RequestMapping("/getOrdersInDelivery/{days}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> getOrdersInDelivery(@PathVariable int days) {
        return orderService.getOrdersInDelivery(days);
    }

    @Operation(summary = "Get all orders by state and year  for the application")
    @RequestMapping("/getOrdersByStateAndYear/{state}/{year}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<OrderDTO> getOrdersByStateAndYear(@PathVariable String state, @PathVariable int year) {
        return orderService.getOrdersByStateAndYear(state, year);
    }

    @Operation(summary = "Get  orders by state and month  for the application")
    @RequestMapping("/getOrdersByStateAndMonth/{state}/{month}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<OrderDTO> getOrdersByStateAndMonth(@PathVariable String state, @PathVariable int month) {
        return orderService.getOrdersByStateAndMonth(state, month);
    }
    @Operation(summary = "Get  amount by state for the application")
    @GetMapping("/amount-by-state")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object[]> amountOrderState() {
        return orderService.amountOrderState();
    }

    @Operation(summary = "Get the first and last order date by client for the application")
    @GetMapping("/first-last-dates-by-client") // Retorna vacia
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object[]> findFirstAndLastOrderDatesByClient() {
        return orderService.findFirstAndLastOrderDatesByClient();
    }
    @Operation(summary = "Get a sum by quantity order for the application")
    @GetMapping("/sum-total-quantity-by-order")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object[]> sumTotalQuantityByOrder() {
        return orderService.sumTotalQuantityByOrder();
    }

}
