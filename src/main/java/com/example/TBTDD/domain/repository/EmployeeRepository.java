package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
