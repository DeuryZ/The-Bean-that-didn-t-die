package com.example.TBTDD.web.controller;


import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.domain.serviceImpl.OfficeServiceImpl;
import com.example.TBTDD.persistence.DTO.OfficeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offices")
@Tag(name = "Office resources")
public class OfficeController {
    private final OfficeServiceImpl officeService;

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public OfficeController(OfficeServiceImpl officeService, EmployeeServiceImpl employeeService) {
        this.officeService = officeService;
        this.employeeService = employeeService;
    }
    @Operation(summary = "Get all offices for the application")
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<OfficeDTO> findAllOffices(){
        return officeService.findAllOffices();
    }

    @Operation(summary = "Get all office by id for the application")
    @GetMapping("/getOfficeById/{officeId}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public OfficeDTO getOfficeById(@PathVariable String officeId){
        return officeService.getOfficeById(officeId);
    }

    @Operation(summary = "Get all office by id for the application")
    @GetMapping("/getCodeAndCityByOffice")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> getCodeAndCityByOffice(){
        return officeService.getCodeAndCityFromOffices();
    }

    @Operation(summary = "Get city and number by country for the application")
    @GetMapping("/getCityAndNumberByCountry/{country}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> getCityAndNumberBySpain(@PathVariable String country){
        return officeService.getCityAndNumberByCountry(country);
    }
    @Operation(summary = "Get address by city by for the application")
    @GetMapping("/getAddressByCity/{city}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> getAddressByCity(@PathVariable String city){
        return officeService.getAddressByCity(city);
    }

//    @GetMapping("/findOfficesWithoutEmployeesRepresentingFrutalesClients")
//    public List<Object> findOfficesWithoutEmployeesRepresentingFrutalesClients(){
//        return officeService.findOfficesWithoutEmployeesRepresentingFrutalesClients();
//    }
}
