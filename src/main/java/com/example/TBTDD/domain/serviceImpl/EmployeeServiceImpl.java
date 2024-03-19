package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.EmployeeRepository;
import com.example.TBTDD.domain.service.EmployeeService;
import com.example.TBTDD.persistence.DTO.EmployeeDTO;
import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(
                employee -> employeeDTOS.add(EmployeeDTO.toDTO(employee))
        );

        return employeeDTOS;
    }

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            return EmployeeDTO.toDTO(employee.get());
        }
        return null;
    }

    @Override
    public List<Object> getEmployeeInfoByReportsTo(String reportsTo) {
        Optional<Employee> employee = employeeRepository.findById(reportsTo);
        List<Object> employeeInfoByReportsTo = employeeRepository.getEmployeeInfoByReportsTo(employee.get());
        return employeeInfoByReportsTo;
    }

    @Override
    public List<EmployeeDTO> findBossCompany() {
        List<Employee> employees = employeeRepository.findBossCompany();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(
                employee -> employeeDTOS.add(EmployeeDTO.toDTO(employee))
        );
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> findDifferentByJobTitle(String jobTitle) {
        List<Employee> employees = employeeRepository.findDifferentByJobTitle(jobTitle);
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(
                employee -> employeeDTOS.add(EmployeeDTO.toDTO(employee))
        );
        return employeeDTOS;
    }

    @Override
    public List<Object> findAllEmployeesWithBoss() {
        List<Object> employees = employeeRepository.findAllEmployeesWithBoss();
        return employees;
    }

    @Override
    public List<Object> findAllEmployeesWithBossAndBoss() {
        List<Object> employees = employeeRepository.findAllEmployeesWithBossAndBoss();
        return employees;
    }

    @Override
    public List<EmployeeDTO> findAllEmployeesWithoutOffice() {
        List<Employee> employees = employeeRepository.findAllEmployeesWithoutOffice();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(
                employee -> employeeDTOS.add(EmployeeDTO.toDTO(employee))
        );
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> findAllEmployeesWithoutClients() {
        List<Employee> employees = employeeRepository.findAllEmployeesWithoutClients();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(
                employee -> employeeDTOS.add(EmployeeDTO.toDTO(employee))
        );
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> findAllEmployeesWithoutClientsOrOffice() {
        List<Employee> employees = employeeRepository.findAllEmployeesWithoutClientsOrOffice();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(
                employee -> employeeDTOS.add(EmployeeDTO.toDTO(employee))
        );
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> countTotalEmployees() {
        List<Employee> employees=  employeeRepository.countTotalEmployees();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employees.forEach(
                employee -> employeeDTOS.add(EmployeeDTO.toDTO((employee)))
        );
        return employeeDTOS;
    }


}





























