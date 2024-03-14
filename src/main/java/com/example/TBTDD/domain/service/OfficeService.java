package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.OfficeDTO;

import java.util.List;

public interface OfficeService {

    List<OfficeDTO> findAllOffices();
    OfficeDTO getOfficeById(String officeId);
}
