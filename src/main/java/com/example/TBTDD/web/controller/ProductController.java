package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.ProductServiceImpl;
import com.example.TBTDD.persistence.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping("/all")
    public List<ProductDTO> getAllProducts() {
        return productService.findAllProducts();
    }

    @RequestMapping("/findProductById/{productId}")
    public ProductDTO getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @RequestMapping("/findProductByGamaAndStock/{rangeProductId}/{quantityInStock}")
    public List<ProductDTO> getProductByGamaAndStock(@PathVariable String rangeProductId, @PathVariable short quantityInStock) {
        return productService.getProductByGamaAndStock(rangeProductId, quantityInStock);
    }

}
