package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.ClientServiceImpl;
import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientServiceImpl clientService;
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public ClientController(ClientServiceImpl clientService,EmployeeServiceImpl employeeService) {
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<ClientDTO> findAllClients() {
        return clientService.findAllClients();
    }


    @GetMapping("/findClientById/{clientId}")
    public ClientDTO getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @GetMapping("/findClientsByCountry/{country}")
    public List<Object> findClientsByCountry(@PathVariable String country) {
        return clientService.findClientsByCountry(country);
    }

    @GetMapping("/findClientsWithPaymentInAYear/{year}")
    public List<Object> findClientsWithPaymentInAYear(@PathVariable int year) {
        return clientService.findClientsWithPaymentInAYear(year);
    }

    @GetMapping("/findClientsByCityAndSalesRep/{city}/{salesRepEmployeeId1}/{salesRepEmployeeId2}")
    public List<ClientDTO> findClientsByCityAndSalesRep(@PathVariable String city, @PathVariable String salesRepEmployeeId1, @PathVariable String salesRepEmployeeId2) {
        return clientService.findClientsByCityAndSalesRep(city, salesRepEmployeeId1, salesRepEmployeeId2);
    }

    @GetMapping("/findAllClientsWithSalesRep")
    public List<Object> findAllClientsWithSalesRep() {
        return clientService.findAllClientsWithSalesRep();
    }

    @GetMapping("/findAllClientsWithSalesRepIfPayment")
    public List<Object> findAllClientsWithSalesRepIfPayment() {
        return clientService.findAllClientsWithSalesRepIfPayment();
    }

    @GetMapping("/findAllClientsWithSalesRepWithoutPayment")
    public List<Object> findAllClientsWithSalesRepWithoutPayment() {
        return clientService.findAllClientsWithSalesRepWithoutPayment();
    }

    @GetMapping("/findAllClientsWithSalesRepAndOfficeIfPayment")
    public List<Object> findAllClientsWithSalesRepAndOfficeIfPayment() {
        return clientService.findAllClientsWithSalesRepAndOfficeIfPayment();
    }

    @GetMapping("/findAllClientsWithSalesRepAndOfficeWithoutPayment")
    public List<Object> findAllClientsWithSalesRepAndOfficeWithoutPayment() {
        return clientService.findAllClientsWithSalesRepAndOfficeWithoutPayment();
    }

    @GetMapping("/findAllClientsWithSalesRepAndOffice")
    public List<Object> findAllClientsWithSalesRepAndOffice() {
        return clientService.findAllClientsWithSalesRepAndOffice();
    }

    @GetMapping("/findClientsWithPendingOrdersLaterThanExpected")
    public List<ClientDTO> findClientsWithPendingOrdersLaterThanExpected() {
        return clientService.findClientsWithPendingOrdersLaterThanExpected();
    }

    @GetMapping("/findClientsWithoutPayment")
    public List<ClientDTO> findClientsWithoutPayment() {
        return clientService.findClientsWithoutPayment();
    }

    @GetMapping("/findClientsWithoutOrder")
    public List<ClientDTO> findClientsWithoutOrder() {
        return clientService.findClientsWithoutOrder();
    }

    @GetMapping("/findClientsWithoutOrderOrWithoutPayment")
    public List<ClientDTO> findClientsWithoutOrderAndWithoutPayment() {
        return clientService.findClientsWithoutOrderOrWithoutPayment();
    }



}
