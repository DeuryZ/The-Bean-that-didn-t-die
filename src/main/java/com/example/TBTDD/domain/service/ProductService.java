package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(String productId);

    List<ProductDTO> findAllProducts();
}
