package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.OfficeDTO;
import com.example.TBTDD.persistence.entity.Office;

import java.util.List;

public interface OfficeService {

    List<OfficeDTO> findAllOffices();
    OfficeDTO getOfficeById(String officeId);

    List<OfficeDTO>getCodeAndCityByOffice();

    List<Object>getCityAndNumberBySpain(String country);
}
