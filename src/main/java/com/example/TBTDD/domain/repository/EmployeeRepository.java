package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("SELECT e FROM Employee e WHERE e.reportsTo IS NULL")
    List<Employee> findBossCompany();

    @Query("SELECT e FROM Employee e WHERE e.jobTitle <> :jobTitle")
    List<Employee> findDifferentByJobTitle(@Param("jobTitle") String jobTitle);
}
