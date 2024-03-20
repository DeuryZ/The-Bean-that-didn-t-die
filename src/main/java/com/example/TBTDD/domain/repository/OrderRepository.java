package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    //7.
    @Query("SELECT DISTINCT o.state FROM Order o")
    List<Object> getStates();

    //9.
    @Query("SELECT o.orderCode, c.clientId, o.expectedDate, o.deliveredDate FROM Order o JOIN o.client c WHERE o.deliveredDate > o.expectedDate")
    List<Object> getOrdersDeliveredAfterExpected();

    //10.
    @Query("SELECT o.orderCode, c.clientId, o.expectedDate, o.deliveredDate FROM Order o JOIN o.client c WHERE o.expectedDate > o.deliveredDate AND DATEDIFF(o.expectedDate, o.deliveredDate) >= :days")
    List<Object> getOrdersInDelivery(@Param("days") int days);

    //11.
    @Query("SELECT o FROM Order o WHERE o.state = :state AND YEAR(o.deliveredDate) = :year")
    List<Order> getOrdersByStateAndYear(@Param("state") String state, @Param("year") int year);

    //12.
    @Query("SELECT o FROM Order o WHERE o.state = :state AND MONTH(o.deliveredDate) = :month")
    List<Order> getOrdersByStateAndMonth(@Param("state") String state, @Param("month") int month);


    // third list 4 query
    @Query(value = "SELECT estado, COUNT(*) AS total_pedidos " + //
            "FROM pedido " + //
            "GROUP BY estado " + //
            "ORDER BY total_pedidos DESC", nativeQuery = true)
    List<Object[]> amountOrderState();

    // 11 third list
    @Query("SELECT o.client.clientName, o.client.contactName, o.client.contactLastName, " +
            "MIN(o.dateOrder) AS firstOrderDate, MAX(o.dateOrder) AS lastOrderDate " +
            "FROM Order o " +
            "GROUP BY o.client.clientName, o.client.contactName, o.client.contactLastName")
    List<Object[]> findFirstAndLastOrderDatesByClient();

    //13 third list
    @Query("SELECT od.id, SUM(od.quantity) " +
            "FROM OrderDetail od " +
            "GROUP BY od.id")
    List<Object[]> sumTotalQuantityByOrder();

}
