package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.RangeProductServiceImpl;
import com.example.TBTDD.persistence.DTO.RangeProductDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rangeProduct")
public class RangeProductController {
    private final RangeProductServiceImpl rangeProductService;

    public RangeProductController(RangeProductServiceImpl rangeProductService) {
        this.rangeProductService = rangeProductService;
    }

    @RequestMapping("/all")
    public List<RangeProductDTO> findAllRangeProducts() {
        return rangeProductService.findAllRangeProducts();
    }

    @RequestMapping("/getRangeProductById/{rangeProductId}")
    public RangeProductDTO getRangeProductById(String rangeProductId) {
        return rangeProductService.getRangeProductById(rangeProductId);
    }


}
