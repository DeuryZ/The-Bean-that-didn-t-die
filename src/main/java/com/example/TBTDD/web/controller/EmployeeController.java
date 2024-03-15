package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.persistence.DTO.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/all")
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @RequestMapping("/findBossCompany")
    public List<EmployeeDTO> findEmployeesByReportsTo() {
        return employeeService.findBossCompany();
    }

    @RequestMapping("/findDifferentByJobTitle/{jobTitle}")
    public List<EmployeeDTO> findEmployeesByJobTitle(@PathVariable String jobTitle) {
        return employeeService.findDifferentByJobTitle(jobTitle);
    }
}
