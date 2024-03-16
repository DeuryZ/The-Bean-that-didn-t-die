package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.ClientRepository;
import com.example.TBTDD.domain.repository.EmployeeRepository;
import com.example.TBTDD.domain.service.ClientService;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import com.example.TBTDD.persistence.entity.Client;
import com.example.TBTDD.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository,EmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<ClientDTO> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        clients.forEach(client -> {
            ClientDTO clientDTO = ClientDTO.toDTO(client);
            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }

    @Override
    public ClientDTO getClientById(String clientId) {
        Client client = clientRepository.findById(clientId).get();
        ClientDTO clientDTO = ClientDTO.toDTO(client);
        return clientDTO;
    }

    @Override
    public List<Object> findClientsByCountry(String country) {
        List<Object> clients = clientRepository.findClientsByCountry(country);
        return clients;
    }

    @Override
    public List<Object> findClientsWithPaymentInAYear(int year) {
        List<Object> clients = clientRepository.findClientWithPaymentInAYear(year);
        return clients;
    }

    @Override
    public List<ClientDTO> findClientsByCityAndSalesRep(String country, String salesRepEmployeeId1, String salesRepEmployeeId2) {
        Employee salesRepEmployee1Obj = employeeRepository.findById(salesRepEmployeeId1).get();
        Employee salesRepEmployee2Obj = employeeRepository.findById(salesRepEmployeeId2).get();
        List<Client> clients = clientRepository.findClientsByCityAndSalesRep(country, salesRepEmployee1Obj, salesRepEmployee2Obj);
        List<ClientDTO> clientDTOs = new ArrayList<>();
        clients.forEach(client -> {
            ClientDTO clientDTO = ClientDTO.toDTO(client);
            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }


}
