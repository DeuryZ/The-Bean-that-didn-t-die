package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.RangeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RangeProductRepository extends JpaRepository<RangeProduct, String> {
}
