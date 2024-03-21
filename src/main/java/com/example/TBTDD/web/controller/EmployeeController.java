package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.persistence.DTO.EmployeeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee resources")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Find all employees for the application")
    @GetMapping("/all")
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @Operation(summary = "get employees by ID for the application")
    @GetMapping("/getEmployeeById/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
    @Operation(summary = "get employees is reporting for the application")
    @GetMapping("/getEmployeeInfoByReportsTo/{reportsTo}")
    public List<Object> findEmployeesByReportsTo(@PathVariable String reportsTo) {
        return employeeService.getEmployeeInfoByReportsTo(reportsTo);
    }

    @Operation(summary = "get Boss for the company for the application")
    @GetMapping("/findBossCompany")
    public List<EmployeeDTO> findBossCompany() {
        return employeeService.findBossCompany();
    }

    @Operation(summary = "get Boss for they JobTitle for the application")
    @GetMapping("/findDifferentByJobTitle/{jobTitle}")
    public List<EmployeeDTO> findEmployeesByJobTitle(@PathVariable String jobTitle) {
        return employeeService.findDifferentByJobTitle(jobTitle);
    }
    @Operation(summary = "get Employees with boss for the application")
    @GetMapping("/findAllEmployeesWithBoss")
    public List<Object> findAllEmployeesWithBoss() {
        return employeeService.findAllEmployeesWithBoss();
    }

    @Operation(summary = "get all Employees with boss and boss for the application")
    @GetMapping("/findAllEmployeesWithBossAndBoss")
    public List<Object> findAllEmployeesWithBossAndBoss() {
        return employeeService.findAllEmployeesWithBossAndBoss();
    }

    @Operation(summary = "get Employees without boss for the application")
    @GetMapping("/findAllEmployeesWithoutOffice")
    public List<EmployeeDTO> findAllEmployeesWithoutOffice() {
        return employeeService.findAllEmployeesWithoutOffice();
    }

    @Operation(summary = "get Employees without client for the application")
    @GetMapping("/findAllEmployeesWithoutClients")
    public List<EmployeeDTO> findAllEmployeesWithoutClients() {
        return employeeService.findAllEmployeesWithoutClients();
    }

    @Operation(summary = "get Employees without client or office for the application")
    @GetMapping("/findAllEmployeesWithoutClientsOrOffice")
    public List<EmployeeDTO> findAllEmployeesWithoutClientsOrOffice() {
        return employeeService.findAllEmployeesWithoutClientsOrOffice();
    }

    @Operation(summary = "get total for Employees for the application")
    @GetMapping("/total")
    public int getTotalEmployees() {
        return employeeService.countTotalEmployees();
    }

    @Operation(summary = "get clients per employee for the application")
    @GetMapping("/clients-per-employee")
    public List<Object[]> countClientsPerEmployee() {
        return employeeService.countClientsPerEmployee();
    }
}
