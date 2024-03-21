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

    @Override
    public List<Object> findAllClientsWithSalesRep() {
        List<Object> clients = clientRepository.findAllClientsWithSalesRep();
        return clients;
    }

    @Override
    public List<Object> findAllClientsWithSalesRepIfPayment() {
        List<Object> clients = clientRepository.findAllClientsWithSalesRepIfPayment();
        return clients;
    }

    @Override
    public List<Object> findAllClientsWithSalesRepWithoutPayment() {
        List<Object> clients = clientRepository.findAllClientsWithSalesRepWithoutPayment();
        return clients;
    }

    @Override
    public List<Object> findAllClientsWithSalesRepAndOfficeIfPayment() {
        List<Object> clients = clientRepository.findAllClientsWithSalesRepAndOfficeIfPayment();
        return clients;
    }

    @Override
    public List<Object> findAllClientsWithSalesRepAndOfficeWithoutPayment() {
        List<Object> clients = clientRepository.findAllClientsWithSalesRepAndOfficeWithoutPayment();
        return clients;
    }

    @Override
    public List<Object> findAllClientsWithSalesRepAndOffice() {
        List<Object> clients = clientRepository.findAllClientsWithSalesRepAndOffice();
        return clients;
    }

    @Override
    public List<ClientDTO> findClientsWithPendingOrdersLaterThanExpected() {
        List<Client> clients = clientRepository.findClientsWithPendingOrdersLaterThanExpected();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        clients.forEach(client -> {
            ClientDTO clientDTO = ClientDTO.toDTO(client);
            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }

    @Override
    public List<ClientDTO> findClientsWithoutPayment() {
        List<Client> clients = clientRepository.findClientsWithoutPayment();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        clients.forEach(client -> {
            ClientDTO clientDTO = ClientDTO.toDTO(client);
            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }

    @Override
    public List<ClientDTO> findClientsWithoutOrder() {
        List<Client> clients = clientRepository.findClientsWithoutOrder();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        clients.forEach(client -> {
            ClientDTO clientDTO = ClientDTO.toDTO(client);
            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }

    @Override
    public List<ClientDTO> findClientsWithoutOrderOrWithoutPayment() {
        List<Client> clients = clientRepository.findClientsWithoutOrderOrWithoutPayment();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        clients.forEach(client -> {
            ClientDTO clientDTO = ClientDTO.toDTO(client);
            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }


    @Override
    public List<Object[]> countClientsByCountry() {
        return clientRepository.countClientsByCountry();
}

    @Override
    public long countClients() {
        return clientRepository.countClients();
    }
    @Override
    public long countClientsInMadrid() {
        return clientRepository.countClientsInMadrid();
    }
    @Override
    public List<Object[]> countClientsByCityStartingWithM() {
        return clientRepository.countClientsByCityStartingWithM();
    }

    @Override
    public long countClientsWithoutSalesRepresentative() {
        return clientRepository.countClientsWithoutSalesRepresentative();
    }
//    @Override
//    public List<ClientDTO> findClientsWithOrdersButNoPayments() {
//        List<Client> clients = clientRepository.findClientsWithOrdersButNoPayments();
//        List<ClientDTO> clientDTOs = new ArrayList<>();
//        clients.forEach(client -> {
//            ClientDTO clientDTO = ClientDTO.toDTO(client);
//            clientDTOs.add(clientDTO);
//        });
//        return clientDTOs;
//
//    }
}
