package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, String> {

    @Query("SELECT o FROM Office o")
    List<Office> getCodeAndCityByOffice();

    @Query("SELECT o.phone, o.city FROM Office o WHERE o.country = :country")
    List<Object> getCityAndNumberBySpain (@Param("country") String country);



}
