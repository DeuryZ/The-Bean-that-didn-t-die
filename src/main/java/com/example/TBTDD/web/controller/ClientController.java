package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.exception.InvalidClientIdException;
import com.example.TBTDD.domain.exception.handleInvalidTokenException;
import com.example.TBTDD.domain.serviceImpl.ClientServiceImpl;
import com.example.TBTDD.domain.serviceImpl.EmployeeServiceImpl;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<ClientDTO> findAllClients() {
        return clientService.findAllClients();
    }

    @Operation(summary = "Find client by id for the application")
    @GetMapping("/findClientById/{clientId}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> getClientById(@PathVariable String clientId) {
        try {
            // Validar que el clientId no esté vacío
            if (clientId == null || clientId.isEmpty()) {
                throw new InvalidClientIdException("Invalid ID");
            }

            // Llamar al servicio para obtener el cliente
            ClientDTO clientDTO = clientService.getClientById(clientId);

            // Retornar la respuesta exitosa
            return ResponseEntity.ok(clientDTO);
        } catch (InvalidClientIdException e) {
            // Capturar la excepción de ID de cliente inválido y devolver un mensaje personalizado
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            // Capturar otras excepciones y devolver un mensaje genérico de error del servidor
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
        }
    }



    @Operation (summary = "Find client by country for the application")
    @GetMapping("/findClientsByCountry/{country}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findClientsByCountry(@PathVariable String country) {
        return clientService.findClientsByCountry(country);
    }

    @Operation (summary = "Find client with a payment in a year for the application")
    @GetMapping("/findClientsWithPaymentInAYear/{year}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findClientsWithPaymentInAYear(@PathVariable int year) {
        return clientService.findClientsWithPaymentInAYear(year);
    }

    @Operation (summary = "Find client by country for the application")
    @GetMapping("/findClientsByCityAndSalesRep/{city}/{salesRepEmployeeId1}/{salesRepEmployeeId2}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<ClientDTO> findClientsByCityAndSalesRep(@PathVariable String city, @PathVariable String salesRepEmployeeId1, @PathVariable String salesRepEmployeeId2) {
        return clientService.findClientsByCityAndSalesRep(city, salesRepEmployeeId1, salesRepEmployeeId2);
    }
    @Operation (summary = "Find all client's with salesRep for the application")
    @GetMapping("/findAllClientsWithSalesRep")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findAllClientsWithSalesRep() {
        return clientService.findAllClientsWithSalesRep();
    }

    @Operation (summary = "Find all client's with salesRep if is Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepIfPayment")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findAllClientsWithSalesRepIfPayment() {
        return clientService.findAllClientsWithSalesRepIfPayment();
    }

    @Operation (summary = "Find all client's with salesRep without Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepWithoutPayment")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findAllClientsWithSalesRepWithoutPayment() {
        return clientService.findAllClientsWithSalesRepWithoutPayment();
    }
    @Operation (summary = "Find all client's with salesRep and office if is Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepAndOfficeIfPayment")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findAllClientsWithSalesRepAndOfficeIfPayment() {
        return clientService.findAllClientsWithSalesRepAndOfficeIfPayment();
    }

    @Operation (summary = "Find all client's with salesRep and office without Payment for the application")
    @GetMapping("/findAllClientsWithSalesRepAndOfficeWithoutPayment")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findAllClientsWithSalesRepAndOfficeWithoutPayment() {
        return clientService.findAllClientsWithSalesRepAndOfficeWithoutPayment();
    }
    @Operation (summary = "Find all client's with salesRep and office for the application")
    @GetMapping("/findAllClientsWithSalesRepAndOffice")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object> findAllClientsWithSalesRepAndOffice() {
        return clientService.findAllClientsWithSalesRepAndOffice();
    }
    @Operation (summary = "Find all client's with pending orders later than expected  for the application")
    @GetMapping("/findClientsWithPendingOrdersLaterThanExpected")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<ClientDTO> findClientsWithPendingOrdersLaterThanExpected() {
        return clientService.findClientsWithPendingOrdersLaterThanExpected();
    }
    @Operation (summary = "Find all client's without payment for the application")
    @GetMapping("/findClientsWithoutPayment")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<ClientDTO> findClientsWithoutPayment() {
        return clientService.findClientsWithoutPayment();
    }

    @Operation (summary = "Find all client's without order for the application")
    @GetMapping("/findClientsWithoutOrder")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<ClientDTO> findClientsWithoutOrder() {
        return clientService.findClientsWithoutOrder();
    }

    @Operation (summary = "Find all client's without order or payment for the application")
    @GetMapping("/findClientsWithoutOrderOrWithoutPayment")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<ClientDTO> findClientsWithoutOrderAndWithoutPayment() {
        return clientService.findClientsWithoutOrderOrWithoutPayment();
    }

    @Operation (summary = "Get an count by country")
    @GetMapping("/count-by-country")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object[]> countClientsByCountry() {
        return clientService.countClientsByCountry();
    }
    @Operation (summary = "Get an count with all clients")
    @GetMapping("/count")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public long countClients() {
        return clientService.countClients();
    }

    @Operation (summary = "Get an count with all clients in madrid ")
    @GetMapping("/count-in-madrid")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public long countClientsInMadrid() {
        return clientService.countClientsInMadrid();
    }
    @Operation (summary = "Get an count with all clients with starting with m ")
    @GetMapping("/count-cities-starting-with-m")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Object[]> countClientsByCityStartingWithM() {
        return clientService.countClientsByCityStartingWithM();
    }

    @Operation (summary = "Get an count with all clients without sales Representative ")
    @GetMapping("/without-sales-representative")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public long countClientsWithoutSalesRepresentative() {
        return clientService.countClientsWithoutSalesRepresentative();
    }

//    @GetMapping("/with-orders-no-payments")
//    public List<ClientDTO> findClientsWithOrdersButNoPayments() {
//        return clientService.findClientsWithOrdersButNoPayments();
//    }

}
