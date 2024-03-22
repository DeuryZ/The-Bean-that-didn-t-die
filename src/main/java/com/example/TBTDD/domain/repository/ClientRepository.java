package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Client;
import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    //1 from second list
    @Query("SELECT DISTINCT c.clientName, CONCAT(e.employeeName,' ', e.employeeLastName1, ' ', e.employeeLastName2) FROM Client c JOIN c.salesRepEmployeeId e")
    List<Object> findAllClientsWithSalesRep();

    //2 from second list
    @Query("SELECT DISTINCT c.clientName, CONCAT(e.employeeName,' ', e.employeeLastName1, ' ', e.employeeLastName2) FROM Client c JOIN c.salesRepEmployeeId e JOIN c.payments p")
    List<Object> findAllClientsWithSalesRepIfPayment();

    //3 from second list
    @Query("SELECT DISTINCT c.clientName, CONCAT(e.employeeName,' ', e.employeeLastName1, ' ', e.employeeLastName2) FROM Client c JOIN c.salesRepEmployeeId e WHERE c NOT IN (SELECT DISTINCT p.client FROM Payment p)")
    List<Object> findAllClientsWithSalesRepWithoutPayment();

    //4 from second list
    @Query("SELECT DISTINCT c.clientName, CONCAT(e.employeeName,' ', e.employeeLastName1, ' ', e.employeeLastName2), o.city FROM Client c JOIN c.salesRepEmployeeId e JOIN c.payments p JOIN e.office o")
    List<Object> findAllClientsWithSalesRepAndOfficeIfPayment();

    //5 from second list
    @Query("SELECT DISTINCT c.clientName, CONCAT(e.employeeName,' ', e.employeeLastName1, ' ', e.employeeLastName2), o.city FROM Client c JOIN c.salesRepEmployeeId e JOIN e.office o WHERE c NOT IN (SELECT DISTINCT p.client FROM Payment p)")
    List<Object> findAllClientsWithSalesRepAndOfficeWithoutPayment();

    //7 from second list
    @Query("SELECT DISTINCT c.clientName, CONCAT(e.employeeName,' ', e.employeeLastName1, ' ', e.employeeLastName2), o.city FROM Client c JOIN c.salesRepEmployeeId e JOIN e.office o")
    List<Object> findAllClientsWithSalesRepAndOffice();

    //10 from second list
    @Query("SELECT c FROM Client c JOIN c.orders o WHERE o.state = 'Entregado' AND o.expectedDate < o.deliveredDate")
    List<Client> findClientsWithPendingOrdersLaterThanExpected();

    //12 from second list
    @Query("SELECT c FROM Client c WHERE c NOT IN (SELECT DISTINCT p.client FROM Payment p)")
    List<Client> findClientsWithoutPayment();

    //13 from second list
    @Query("SELECT c FROM Client c WHERE c NOT IN (SELECT DISTINCT o.client FROM Order o)")
    List<Client> findClientsWithoutOrder();

    //14 from second list
    @Query("SELECT c FROM Client c WHERE c NOT IN (SELECT DISTINCT o.client FROM Order o) OR c NOT IN (SELECT DISTINCT p.client FROM Payment p)")
    List<Client> findClientsWithoutOrderOrWithoutPayment();

    //2 from Third List
    @Query("SELECT c.country, COUNT(c) FROM Client c GROUP BY c.country")
    List<Object[]> countClientsByCountry();


    // 6 from Third List
    @Query("SELECT COUNT(c) FROM Client c")
    long countClients();

    // 7 from Third list

    @Query("SELECT COUNT(c) FROM Client c WHERE c.city = 'Madrid'")
    long countClientsInMadrid();

    // 8 from Third list
    @Query("SELECT c.city, COUNT(c) FROM Client c WHERE c.city LIKE 'M%' GROUP BY c.city")
    List<Object[]> countClientsByCityStartingWithM();

    // 10 From Third List
    @Query("SELECT COUNT(c) FROM Client c WHERE c.salesRepEmployeeId IS NULL")
    long countClientsWithoutSalesRepresentative();

    // 22 From second List
//    @Query("SELECT DISTINCT c FROM Client c JOIN c.orders o WHERE NOT EXISTS (SELECT p FROM Payment p WHERE p.order = o)")
//    List<Client> findClientsWithOrdersButNoPayments();


}
