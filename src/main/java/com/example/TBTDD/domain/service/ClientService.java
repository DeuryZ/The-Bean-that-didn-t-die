package com.example.TBTDD.domain.service;

import com.example.TBTDD.domain.repository.ClientRepository;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import com.example.TBTDD.persistence.entity.Employee;

import java.util.List;

public interface ClientService {
    List<ClientDTO> findAllClients();
    ClientDTO getClientById(String clientId);
    List<ClientDTO> findClientsByCountry(String country);
    List<ClientDTO> findClientsWithPaymentInAYear(int year);
    List<ClientDTO> findClientsByCountryAndSalesRep(String country, Employee salesRepEmployeeId1, Employee salesRepEmployeeId2);

}
