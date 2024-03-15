package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.EmployeeRepository;
import com.example.TBTDD.domain.service.EmployeeService;
import com.example.TBTDD.persistence.DTO.EmployeeDTO;
import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO = EmployeeDTO.toDTO(employee);
            employeeDTOs.add(employeeDTO);
        });
        return employeeDTOs;

    }

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDTO employeeDTO = EmployeeDTO.toDTO(employee);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findBossCompany() {
        List<Employee> employees = employeeRepository.findBossCompany();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO = EmployeeDTO.toDTO(employee);
            employeeDTOs.add(employeeDTO);
        });
        return employeeDTOs;
    }

    @Override
    public List<EmployeeDTO> findDifferentByJobTitle(String jobTitle) {
        List<Employee> employees = employeeRepository.findDifferentByJobTitle(jobTitle);
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO = EmployeeDTO.toDTO(employee);
            employeeDTOs.add(employeeDTO);
        });
        return employeeDTOs;
    }


}





























