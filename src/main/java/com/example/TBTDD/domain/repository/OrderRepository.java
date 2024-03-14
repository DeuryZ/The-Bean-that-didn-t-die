package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
