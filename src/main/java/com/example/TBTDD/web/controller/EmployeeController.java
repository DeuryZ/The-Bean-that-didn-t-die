package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.persistence.DTO.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/getEmployeeById/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/getEmployeeInfoByReportsTo/{reportsTo}")
    public List<Object> findEmployeesByReportsTo(@PathVariable String reportsTo) {
        return employeeService.getEmployeeInfoByReportsTo(reportsTo);
    }

    @GetMapping("/findBossCompany")
    public List<EmployeeDTO> findBossCompany() {
        return employeeService.findBossCompany();
    }

    @GetMapping("/findDifferentByJobTitle/{jobTitle}")
    public List<EmployeeDTO> findEmployeesByJobTitle(@PathVariable String jobTitle) {
        return employeeService.findDifferentByJobTitle(jobTitle);
    }

    @GetMapping("/findAllEmployeesWithBoss")
    public List<Object> findAllEmployeesWithBoss() {
        return employeeService.findAllEmployeesWithBoss();
    }

    @GetMapping("/findAllEmployeesWithBossAndBoss")
    public List<Object> findAllEmployeesWithBossAndBoss() {
        return employeeService.findAllEmployeesWithBossAndBoss();
    }

    @GetMapping("/findAllEmployeesWithoutOffice")
    public List<EmployeeDTO> findAllEmployeesWithoutOffice() {
        return employeeService.findAllEmployeesWithoutOffice();
    }

    @GetMapping("/findAllEmployeesWithoutClients")
    public List<EmployeeDTO> findAllEmployeesWithoutClients() {
        return employeeService.findAllEmployeesWithoutClients();
    }

    @GetMapping("/findAllEmployeesWithoutClientsOrOffice")
    public List<EmployeeDTO> findAllEmployeesWithoutClientsOrOffice() {
        return employeeService.findAllEmployeesWithoutClientsOrOffice();
    }
    @GetMapping("/total")
    public List<EmployeeDTO> getTotalEmployees() {
        return employeeService.countTotalEmployees();
    }

}
