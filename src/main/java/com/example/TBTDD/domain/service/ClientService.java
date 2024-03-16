package com.example.TBTDD.domain.service;

import com.example.TBTDD.domain.repository.ClientRepository;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import com.example.TBTDD.persistence.entity.Employee;

import java.util.List;

public interface ClientService {
    List<ClientDTO> findAllClients();
    ClientDTO getClientById(String clientId);
    List<Object> findClientsByCountry(String country);
    List<Object> findClientsWithPaymentInAYear(int year);
    List<ClientDTO> findClientsByCityAndSalesRep(String country, String salesRepEmployeeId1, String salesRepEmployeeId2);

}
