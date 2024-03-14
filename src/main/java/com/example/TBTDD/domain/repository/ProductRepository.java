package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
