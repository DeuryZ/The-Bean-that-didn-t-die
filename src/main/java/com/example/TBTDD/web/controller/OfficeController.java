package com.example.TBTDD.web.controller;


import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.domain.serviceImpl.OfficeServiceImpl;
import com.example.TBTDD.persistence.DTO.OfficeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {
    private final OfficeServiceImpl officeService;

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public OfficeController(OfficeServiceImpl officeService, EmployeeServiceImpl employeeService) {
        this.officeService = officeService;
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public List<OfficeDTO> findAllOffices(){
        return officeService.findAllOffices();
    }


    @GetMapping("/getOfficeById/{officeId}")
    public OfficeDTO getOfficeById(@PathVariable String officeId){
        return officeService.getOfficeById(officeId);
    }

    @GetMapping("/getCodeAndCityByOffice")
    public List<Object> getCodeAndCityByOffice(){
        return officeService.getCodeAndCityFromOffices();
    }

    @GetMapping("/getCityAndNumberByCountry/{country}")
    public List<Object> getCityAndNumberBySpain(@PathVariable String country){
        return officeService.getCityAndNumberByCountry(country);
    }

    @GetMapping("/getAddressByCity/{city}")
    public List<Object> getAddressByCity(@PathVariable String city){
        return officeService.getAddressByCity(city);
    }

//    @GetMapping("/findOfficesWithoutEmployeesRepresentingFrutalesClients")
//    public List<OfficeDTO> findOfficesWithoutEmployeesRepresentingFrutalesClients(){
//        return officeService.findOfficesWithoutEmployeesRepresentingFrutalesClients();
//    }
}
