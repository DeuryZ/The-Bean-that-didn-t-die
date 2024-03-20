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

    //19 and 20 from second list
    @Query("SELECT p FROM Product p WHERE p NOT IN (SELECT oD.id.product FROM OrderDetail oD)")
    List<Product> getProductsWithoutOrder();

    // Third list 5 query
    @Query("SELECT CONCAT('Most expensive product: ', p.name) AS type, MAX(p.salePrice) AS price " +
            "FROM Product p " +
            "UNION " +
            "SELECT CONCAT('Cheapest product: ', p.name) AS type, MIN(p.salePrice) AS price " +
            "FROM Product p")
    List<Product> productoExpensiveAndCheap();


    // Third list 15 query
//    @Query("SELECT SUM(od.quantity * od.unitPrice) AS baseImponible, " +
//            "       SUM(od.quantity * od.unitPrice) * 0.21 AS iva, " +
//            "       SUM(od.quantity * od.unitPrice) + (SUM(od.quantity * od.unitPrice) * 0.21) AS totalFacturado " +
//            "FROM OrderDetail od")
//    Object[] getBillingHistory();

}
