package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, String> {

    //1.
    @Query("SELECT o.officeCode, o.city FROM Office o")
    List<Object> getCodeAndCityFromOffices();

    //2.
    @Query("SELECT o.city, o.phone FROM Office o WHERE o.country = :country")
    List<Object> getCityAndNumberByCountry (@Param("country") String country);

    //6 from second list
    @Query("SELECT o.addressLine1, o.addressLine2 FROM Office o JOIN o.employees e JOIN e.clients c WHERE c.city = :city")
    List<Object> getAddressByCity(@Param("city") String city);



    // 21 From multitable List
//    @Query("SELECT DISTINCT od.order.client.office.officeCode " +
//            "FROM OrderDetail od " +
//            "JOIN od.order.client.office o " +
//            "JOIN od.order.client c " +
//            "JOIN od.order p " +
//            "JOIN od.product pr " +
//            "WHERE pr.rangeProduct.gama = 'Frutales' " +
//            "AND c.salesRepEmployeeId IS NOT NULL " +
//            "AND o.officeCode IS NOT NULL " +
//            "AND c.clientId IS NOT NULL " +
//            "AND p.orderId IS NOT NULL " +
//            "AND od.id.orderId IS NOT NULL " +
//            "AND pr.productCode IS NOT NULL")
//    List<Object> findOfficesWithoutSalesRepresentativesForFrutales();



}
