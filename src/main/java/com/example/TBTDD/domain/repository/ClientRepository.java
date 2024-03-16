package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Client;
import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface ClientRepository extends JpaRepository<Client, String> {
    //6.
    @Query("SELECT c.clientName FROM Client c WHERE c.country = :country")
    List<Object> findClientsByCountry(@Param("country") String country);

    //8.
    @Query("SELECT DISTINCT c.clientId FROM Client c JOIN c.payments p WHERE YEAR(p.date) = :year")
        List<Object> findClientWithPaymentInAYear(@Param("year") int year);

    //16.
    @Query("SELECT c FROM Client c WHERE c.city = :city AND (c.salesRepEmployeeId = :salesRepEmployeeId1 OR c.salesRepEmployeeId = :salesRepEmployeeId2)")
    List<Client> findClientsByCityAndSalesRep(@Param("city") String city, @Param("salesRepEmployeeId1") Employee salesRepEmployeeId1, @Param("salesRepEmployeeId2") Employee salesRepEmployeeId2);



}
