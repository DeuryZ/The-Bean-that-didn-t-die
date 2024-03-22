package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.DTO.RangeProductDTO;
import com.example.TBTDD.persistence.entity.RangeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RangeProductRepository extends JpaRepository<RangeProduct, String> {
    //11 from second list
    @Query("SELECT DISTINCT r FROM OrderDetail oD JOIN oD.id.order o JOIN oD.id.product p JOIN p.rangeProduct r JOIN o.client c WHERE c.clientId = :clientId")
    List<RangeProduct> findRangeProductByClientId(@Param("clientId") int clientId);


}
