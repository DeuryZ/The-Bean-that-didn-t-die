package com.example.TBTDD.domain.service;

import com.example.TBTDD.domain.repository.ClientRepository;
import com.example.TBTDD.persistence.DTO.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> findAllClients();
    ClientDTO getClientById(String clientId);

}
