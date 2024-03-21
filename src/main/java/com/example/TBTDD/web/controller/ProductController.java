package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.ProductServiceImpl;
import com.example.TBTDD.persistence.DTO.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Product  resources")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get all Products for the application")
    @RequestMapping("/all")
    public List<ProductDTO> getAllProducts() {
        return productService.findAllProducts();
    }

    @Operation(summary = "Get all Products by id for the application")
    @RequestMapping("/findProductById/{productId}")
    public ProductDTO getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @Operation(summary = "Get all Products by gama and stock for the application")
    @RequestMapping("/findProductByGamaAndStock/{rangeProductId}/{quantityInStock}")
    public List<ProductDTO> getProductByGamaAndStock(@PathVariable String rangeProductId, @PathVariable short quantityInStock) {
        return productService.getProductByGamaAndStock(rangeProductId, quantityInStock);
    }

    @Operation(summary = "Get  Products without order for the application")
    @RequestMapping("/findProductsWithoutOrder")
    public List<ProductDTO> getProductsWithoutOrder() {
        return productService.getProductsWithoutOrder();
    }

    @Operation(summary = "Get  Products most expensive and cheapest for the application")
    @RequestMapping("/expensive-cheap")
    public List<ProductDTO> productoExpensiveAndCheap() {
        return productService.productoExpensiveAndCheap();
    }


//    @GetMapping("/history")
//    public Object[] getBillingHistory() {
//        return billingService.getBillingHistory();
//    }

}
