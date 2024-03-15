package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.ProductRepository;
import com.example.TBTDD.domain.service.ProductService;
import com.example.TBTDD.persistence.DTO.ProductDTO;
import com.example.TBTDD.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(String productId) {
        Product product = productRepository.findById(productId).get();
        ProductDTO productDTO = ProductDTO.toDTO(product);
        return productDTO;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.toDTO(product);
            productDTOs.add(productDTO);
        });
        return productDTOs;
    }


}
