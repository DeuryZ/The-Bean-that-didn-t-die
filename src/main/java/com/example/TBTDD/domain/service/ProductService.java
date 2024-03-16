package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.ProductDTO;
import com.example.TBTDD.persistence.entity.RangeProduct;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(String productId);
    List<ProductDTO> findAllProducts();
    List<ProductDTO> getProductByGamaAndStock(String rangeProductId, short quantityInStock);
}
