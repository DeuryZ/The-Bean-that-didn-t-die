package com.example.TBTDD.web.controller;


import com.example.TBTDD.domain.service.OrderDetailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

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
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;



    @GetMapping("/best-selling")
    public List<Object[]> getBestSellingProducts() {
        return orderDetailService.findBestSellingProducts();
    }

    @GetMapping("/calculate")
    public Object[] calculateBilling() {
        return orderDetailService.calculateBilling();
    }
    @GetMapping("/billing-by-product")
    public List<Object[]> calculateBillingByProduct() {
        return orderDetailService.calculateBillingByProduct();
    }


    @GetMapping("/billing-by-productWithOR")
    public List<Object[]> calculateBillingByProductWithOR() {
        return orderDetailService.calculateBillingByProductWithOR();
    }


    @GetMapping("/vents-greater-than-3000")
    public List<Object[]> showVentsGreaterthan3000() {
        return orderDetailService.showVentsGreaterthan3000();
    }
}