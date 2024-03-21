package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.ClientServiceImpl;
import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client Resources")
public class ClientController {
    private final ClientServiceImpl clientService;
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public ClientController(ClientServiceImpl clientService,EmployeeServiceImpl employeeService) {
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @Operation(summary = "Find all clients for the application")
    @GetMapping("/all")
    public List<ClientDTO> findAllClients() {
        return clientService.findAllClients();
    }

    @Operation (summary = "Find  client by id for the application")
    @GetMapping("/findClientById/{clientId}")
    public ClientDTO getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @Operation (summary = "Find client by country for the application")
    @GetMapping("/findClientsByCountry/{country}")
    public List<Object> findClientsByCountry(@PathVariable String country) {
        return clientService.findClientsByCountry(country);
    }

    @Operation (summary = "Find client with a payment in a year for the application")
    @GetMapping("/findClientsWithPaymentInAYear/{year}")
    public List<Object> findClientsWithPaymentInAYear(@PathVariable int year) {
        return clientService.findClientsWithPaymentInAYear(year);
    }

    @Operation (summary = "Find client by country for the application")
    @GetMapping("/findClientsByCityAndSalesRep/{city}/{salesRepEmployeeId1}/{salesRepEmployeeId2}")
    public List<ClientDTO> findClientsByCityAndSalesRep(@PathVariable String city, @PathVariable String salesRepEmployeeId1, @PathVariable String salesRepEmployeeId2) {
        return clientService.findClientsByCityAndSalesRep(city, salesRepEmployeeId1, salesRepEmployeeId2);
    }
    @Operation (summary = "Find all client's with salesRep for the application")
    @GetMapping("/findAllClientsWithSalesRep")
    public List<Object> findAllClientsWithSalesRep() {
        return clientService.findAllClientsWithSalesRep();
    }

    @Operation (summary = "Find all client's with salesRep if is Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepIfPayment")
    public List<Object> findAllClientsWithSalesRepIfPayment() {
        return clientService.findAllClientsWithSalesRepIfPayment();
    }

    @Operation (summary = "Find all client's with salesRep without Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepWithoutPayment")
    public List<Object> findAllClientsWithSalesRepWithoutPayment() {
        return clientService.findAllClientsWithSalesRepWithoutPayment();
    }
    @Operation (summary = "Find all client's with salesRep and office if is Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepAndOfficeIfPayment")
    public List<Object> findAllClientsWithSalesRepAndOfficeIfPayment() {
        return clientService.findAllClientsWithSalesRepAndOfficeIfPayment();
    }

    @Operation (summary = "Find all client's with salesRep and office without Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepAndOfficeWithoutPayment")
    public List<Object> findAllClientsWithSalesRepAndOfficeWithoutPayment() {
        return clientService.findAllClientsWithSalesRepAndOfficeWithoutPayment();
    }
    @Operation (summary = "Find all client's with salesRep and office for the application")
    @GetMapping("/findAllClientsWithSalesRepAndOffice")
    public List<Object> findAllClientsWithSalesRepAndOffice() {
        return clientService.findAllClientsWithSalesRepAndOffice();
    }
    @Operation (summary = "Find all client's with pending orders later than expected  for the application")
    @GetMapping("/findClientsWithPendingOrdersLaterThanExpected")
    public List<ClientDTO> findClientsWithPendingOrdersLaterThanExpected() {
        return clientService.findClientsWithPendingOrdersLaterThanExpected();
    }
    @Operation (summary = "Find all client's without payment for the application")
    @GetMapping("/findClientsWithoutPayment")
    public List<ClientDTO> findClientsWithoutPayment() {
        return clientService.findClientsWithoutPayment();
    }

    @Operation (summary = "Find all client's without order for the application")
    @GetMapping("/findClientsWithoutOrder")
    public List<ClientDTO> findClientsWithoutOrder() {
        return clientService.findClientsWithoutOrder();
    }

    @Operation (summary = "Find all client's without order or payment for the application")
    @GetMapping("/findClientsWithoutOrderOrWithoutPayment")
    public List<ClientDTO> findClientsWithoutOrderAndWithoutPayment() {
        return clientService.findClientsWithoutOrderOrWithoutPayment();
    }

    @Operation (summary = "Get an count by country")
    @GetMapping("/count-by-country")
    public List<Object[]> countClientsByCountry() {
        return clientService.countClientsByCountry();
    }
    @Operation (summary = "Get an count with all clients")
    @GetMapping("/count")
    public long countClients() {
        return clientService.countClients();
    }

    @Operation (summary = "Get an count with all clients in madrid ")
    @GetMapping("/count-in-madrid")
    public long countClientsInMadrid() {
        return clientService.countClientsInMadrid();
    }
    @Operation (summary = "Get an count with all clients with starting with m ")
    @GetMapping("/count-cities-starting-with-m")
    public List<Object[]> countClientsByCityStartingWithM() {
        return clientService.countClientsByCityStartingWithM();
    }

    @Operation (summary = "Get an count with all clients without sales Representative ")
    @GetMapping("/without-sales-representative")
    public long countClientsWithoutSalesRepresentative() {
        return clientService.countClientsWithoutSalesRepresentative();
    }

//    @GetMapping("/with-orders-no-payments")
//    public List<ClientDTO> findClientsWithOrdersButNoPayments() {
//        return clientService.findClientsWithOrdersButNoPayments();
//    }

}
