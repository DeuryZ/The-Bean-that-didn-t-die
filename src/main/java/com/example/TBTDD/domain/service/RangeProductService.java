package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.RangeProductDTO;

import java.util.List;

public interface RangeProductService {
    List<RangeProductDTO> findAllRangeProducts();
    RangeProductDTO getRangeProductById(String rangeProductId);
    List<RangeProductDTO> findRangeProductByClientId(int clientId);
}
