package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    //3.
    @Query("SELECT e.employeeName, CONCAT(e.employeeLastName1, ' ', e.employeeLastName2), e.email FROM Employee e WHERE e.reportsTo = :reportsTo")
    List<Object> getEmployeeInfoByReportsTo(@Param("reportsTo") Employee reportsTo);

    //4.
    @Query("SELECT e FROM Employee e WHERE e.reportsTo IS NULL")
    List<Employee> findBossCompany();

    //5.
    @Query("SELECT e FROM Employee e WHERE e.jobTitle <> :jobTitle")
    List<Employee> findDifferentByJobTitle(@Param("jobTitle") String jobTitle);
}
