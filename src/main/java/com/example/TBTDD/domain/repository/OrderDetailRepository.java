package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.embeddable.OrderDetailId;
import com.example.TBTDD.persistence.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
