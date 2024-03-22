package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> findAllClients();
    ClientDTO getClientById(String clientId);
    List<Object> findClientsByCountry(String country);
    List<Object> findClientsWithPaymentInAYear(int year);
    List<ClientDTO> findClientsByCityAndSalesRep(String country, String salesRepEmployeeId1, String salesRepEmployeeId2);
    List<Object> findAllClientsWithSalesRep();
    List<Object> findAllClientsWithSalesRepIfPayment();
    List<Object> findAllClientsWithSalesRepWithoutPayment();
    List<Object> findAllClientsWithSalesRepAndOfficeIfPayment();
    List<Object> findAllClientsWithSalesRepAndOfficeWithoutPayment();
    List<Object> findAllClientsWithSalesRepAndOffice();
    List<ClientDTO> findClientsWithPendingOrdersLaterThanExpected();
    List<ClientDTO> findClientsWithoutPayment();
    List<ClientDTO> findClientsWithoutOrder();
    List<ClientDTO> findClientsWithoutOrderOrWithoutPayment();

    List<Object[]> countClientsByCountry();

    long countClients();
    long countClientsInMadrid();
    List<Object[]> countClientsByCityStartingWithM();
    long countClientsWithoutSalesRepresentative();
//    List<ClientDTO> findClientsWithOrdersButNoPayments();
}
