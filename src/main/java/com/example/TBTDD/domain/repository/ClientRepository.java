package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Client;
import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    @Query("SELECT c FROM Client c WHERE c.country = :country")
    List<Client> findClientsByCountry(@Param("country") String country);

    @Query("SELECT DISTINCT c FROM Client c JOIN c.payments p WHERE YEAR(p.date) = :year")
    List<Client> findClientWithPaymentInAYear(@Param("year") int year);

    @Query("SELECT c FROM Client c WHERE c.city = :city AND (c.salesRepEmployeeId = :salesRepEmployeeId1 OR c.salesRepEmployeeId = :salesRepEmployeeId2)")
    List<Client> findClientsByCityAndSalesRep(@Param("city") String city, @Param("salesRepEmployeeId1") Employee salesRepEmployeeId1, @Param("salesRepEmployeeId2") Employee salesRepEmployeeId2);



}
