package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Product;
import com.example.TBTDD.persistence.entity.RangeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    //15.
    @Query("SELECT p FROM Product p WHERE p.rangeProduct = :rangeProduct AND p.quantityInStock >= :quantityInStock ORDER BY p.salePrice DESC")
    List<Product> getProductByGamaAndStock(@Param("rangeProduct")RangeProduct rangeProduct, @Param("quantityInStock") short quantityInStock);

    //19 from second list
    @Query("SELECT p FROM Product p WHERE p NOT IN (SELECT o.product FROM Order o)")
    List<Product> getProductsWithoutOrder();
}
