package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();
    EmployeeDTO getEmployeeById(String employeeId);
    List<Object> getEmployeeInfoByReportsTo(String reportsTo);
    List<EmployeeDTO> findBossCompany();
    List<EmployeeDTO> findDifferentByJobTitle(String jobTitle);
}
