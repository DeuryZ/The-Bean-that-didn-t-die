package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.EmployeeDTO;
import com.example.TBTDD.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();
    EmployeeDTO getEmployeeById(String employeeId);
    List<Object> getEmployeeInfoByReportsTo(String reportsTo);
    List<EmployeeDTO> findBossCompany();
    List<EmployeeDTO> findDifferentByJobTitle(String jobTitle);
    List<Object> findAllEmployeesWithBoss();
    List<Object> findAllEmployeesWithBossAndBoss();
    List<EmployeeDTO> findAllEmployeesWithoutOffice();
    List<EmployeeDTO> findAllEmployeesWithoutClients();
    List<EmployeeDTO> findAllEmployeesWithoutClientsOrOffice();

    List<EmployeeDTO> countTotalEmployees();
}
