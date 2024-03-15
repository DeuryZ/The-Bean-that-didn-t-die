package com.example.TBTDD.domain.serviceImpl;


import com.example.TBTDD.domain.repository.RangeProductRepository;
import com.example.TBTDD.domain.service.RangeProductService;
import com.example.TBTDD.persistence.DTO.RangeProductDTO;
import com.example.TBTDD.persistence.entity.RangeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RangeProductServiceImpl implements RangeProductService {
    private final RangeProductRepository rangeProductRepository;

    @Autowired
    public RangeProductServiceImpl(RangeProductRepository rangeProductRepository) {
        this.rangeProductRepository = rangeProductRepository;
    }

    @Override
    public List<RangeProductDTO> findAllRangeProducts() {
        List<RangeProductDTO> rangeProductDTOs = new ArrayList<>();
        List<RangeProduct> rangeProducts = rangeProductRepository.findAll();
        rangeProducts.forEach(rangeProduct -> {
            RangeProductDTO rangeProductDTO = RangeProductDTO.toDTO(rangeProduct);
            rangeProductDTOs.add(rangeProductDTO);
        });
        return rangeProductDTOs;
    }

    @Override
    public RangeProductDTO getRangeProductById(String rangeProductId) {
        RangeProduct rangeProduct = rangeProductRepository.findById(rangeProductId).get();
        RangeProductDTO rangeProductDTO = RangeProductDTO.toDTO(rangeProduct);
        return rangeProductDTO;
    }
}
