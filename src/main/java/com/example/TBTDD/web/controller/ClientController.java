package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.ClientServiceImpl;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    private final ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientDTO> findAllClients() {
        return clientService.findAllClients();
    }


}
