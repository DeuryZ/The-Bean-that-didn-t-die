package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.ProductRepository;
import com.example.TBTDD.domain.repository.RangeProductRepository;
import com.example.TBTDD.domain.service.ProductService;
import com.example.TBTDD.persistence.DTO.ProductDTO;
import com.example.TBTDD.persistence.entity.Product;
import com.example.TBTDD.persistence.entity.RangeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final RangeProductRepository rangeProductRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, RangeProductRepository rangeProductRepository) {
        this.productRepository = productRepository;
        this.rangeProductRepository = rangeProductRepository;
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

    @Override
    public List<ProductDTO> getProductByGamaAndStock(String rangeProductId, short quantityInStock) {

        Optional<RangeProduct> rangeProduct = rangeProductRepository.findById(rangeProductId);
        if (!rangeProduct.isPresent()) {
            return null;
        }
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productRepository.getProductByGamaAndStock(rangeProduct.get(), quantityInStock);
        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.toDTO(product);
            productDTOs.add(productDTO);
        });
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getProductsWithoutOrder() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        List<Product> products = productRepository.getProductsWithoutOrder();
        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.toDTO(product);
            productDTOs.add(productDTO);
        });
        return productDTOs;
    }
    @Override
    public List<ProductDTO> productoExpensiveAndCheap() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = productRepository.productoExpensiveAndCheap();
        products.forEach(product -> {
            ProductDTO productDTO = ProductDTO.toDTO(product);
            productDTOS.add(productDTO);
        });
        return productDTOS;
    }
//    @Override
//    public Object[] getBillingHistory() {
//        return orderRepository.getBillingHistory();
//    }

    }
