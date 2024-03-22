package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.RangeProductServiceImpl;
import com.example.TBTDD.persistence.DTO.RangeProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rangeProduct")
@Tag(name = "range resources")
public class RangeProductController {
    private final RangeProductServiceImpl rangeProductService;

    public RangeProductController(RangeProductServiceImpl rangeProductService) {
        this.rangeProductService = rangeProductService;
    }
    @Operation(summary = "Get all Range's for the application")
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<RangeProductDTO> findAllRangeProducts() {
        return rangeProductService.findAllRangeProducts();
    }

    @Operation(summary = "Get all Range's by ID for the application")
    @GetMapping("/getRangeProductById/{rangeProductId}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public RangeProductDTO getRangeProductById(String rangeProductId) {
        return rangeProductService.getRangeProductById(rangeProductId);
    }

    @Operation(summary = "Get all Range's product by client ID for the application")
    @GetMapping("/findRangeProductByClientId/{clientId}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<RangeProductDTO> findRangeProductByClientId(@PathVariable int clientId) {
        return rangeProductService.findRangeProductByClientId(clientId);
    }



}
