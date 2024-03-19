package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    //13.
    @Query("SELECT p FROM Payment p WHERE YEAR(p.date) = :year AND p.paymentMethod = :paymentType ORDER BY p.total DESC")
    List<Payment> getPaymentsByTypeAndYearOrganized(@Param("year") int year, @Param("paymentType") String paymentType);

    //14.
    @Query("SELECT DISTINCT p.paymentMethod FROM Payment p")
    List<Object> getPaymentMethods();

    // 3. for third column
    @Query("SELECT AVG(p.total) " +
            "FROM Payment p " +
            "WHERE YEAR(p.date) = 2009")
    Double findAveragePaymentAmountIn2009();


}
