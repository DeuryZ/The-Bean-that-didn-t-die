package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.ClientRepository;
import com.example.TBTDD.domain.service.ClientService;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import com.example.TBTDD.persistence.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOs = new ArrayList<>();
        clients.forEach(client -> {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientId(client.getClientId());
            clientDTO.setClientName(client.getClientName());
            clientDTO.setContactName(client.getContactName());
            clientDTO.setContactLastName(client.getContactLastName());
            clientDTO.setPhone(client.getPhone());
            clientDTO.setFax(client.getFax());
            clientDTO.setAddressLine(client.getAddressLine1());
            clientDTO.setAddressLine2(client.getAddressLine2());
            clientDTO.setCity(client.getCity());
            clientDTO.setRegion(client.getRegion());
            clientDTO.setCountry(client.getCountry());
            clientDTO.setZipCode(client.getZipCode());
            clientDTO.setCreditLimit(client.getCreditLimit());
            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }

    @Override
    public ClientDTO getClientById(String clientId) {
        Client client = clientRepository.findById(clientId).get();
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(client.getClientId());
        clientDTO.setClientName(client.getClientName());
        clientDTO.setContactName(client.getContactName());
        clientDTO.setContactLastName(client.getContactLastName());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setFax(client.getFax());
        clientDTO.setAddressLine(client.getAddressLine1());
        clientDTO.setAddressLine2(client.getAddressLine2());
        clientDTO.setCity(client.getCity());
        clientDTO.setRegion(client.getRegion());
        clientDTO.setCountry(client.getCountry());
        clientDTO.setZipCode(client.getZipCode());
        clientDTO.setCreditLimit(client.getCreditLimit());
        return clientDTO;
    }
}
