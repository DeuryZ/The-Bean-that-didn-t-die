package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.DTO.OfficeDTO;
import com.example.TBTDD.persistence.entity.Office;

import java.util.List;

public interface OfficeService {

    List<OfficeDTO> findAllOffices();
    OfficeDTO getOfficeById(String officeId);
    List<Object>getCodeAndCityFromOffices();
    List<Object>getCityAndNumberByCountry(String country);
    List<Object>getAddressByCity(String city);
}
