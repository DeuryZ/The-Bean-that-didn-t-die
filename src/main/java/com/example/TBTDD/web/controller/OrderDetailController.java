package com.example.TBTDD.web.controller;


import com.example.TBTDD.domain.service.OrderDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderDetail")
@Tag(name = "orderDetail resources")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;


    @Operation(summary = "Get best selling products for the application")
    @GetMapping("/best-selling")
    public List<Object[]> getBestSellingProducts() {
        return orderDetailService.findBestSellingProducts();
    }

    @Operation(summary = "Get the calculate billing products for the application")
    @GetMapping("/calculate")
    public Object[] calculateBilling() {
        return orderDetailService.calculateBilling();
    }

    @Operation(summary = "Get the billing by product  for the application")
    @GetMapping("/billing-by-product")
    public List<Object[]> calculateBillingByProduct() {
        return orderDetailService.calculateBillingByProduct();
    }

    @Operation(summary = "Get the billing by product with or  for the application")
    @GetMapping("/billing-by-productWithOR")
    public List<Object[]> calculateBillingByProductWithOR() {
        return orderDetailService.calculateBillingByProductWithOR();
    }

    @Operation(summary = "Get vents greater than 3000 for the application")
    @GetMapping("/vents-greater-than-3000")
    public List<Object[]> showVentsGreaterthan3000() {
        return orderDetailService.showVentsGreaterthan3000();
    }
}