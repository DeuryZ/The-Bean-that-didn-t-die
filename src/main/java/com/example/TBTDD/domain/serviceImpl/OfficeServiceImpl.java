package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.EmployeeRepository;
import com.example.TBTDD.domain.repository.OfficeRepository;
import com.example.TBTDD.domain.service.OfficeService;
import com.example.TBTDD.persistence.DTO.ClientDTO;
import com.example.TBTDD.persistence.DTO.OfficeDTO;
import com.example.TBTDD.persistence.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }


    @Override
    public List<OfficeDTO> findAllOffices() {
        List<Office> offices = officeRepository.findAll();
        List<OfficeDTO> officeDTOs = new ArrayList<>();
        offices.forEach(office -> officeDTOs.add(OfficeDTO.toDTO(office)));
        return officeDTOs;
    }

    @Override
    public OfficeDTO getOfficeById(String officeId) {
        Optional<Office> office = officeRepository.findById(officeId);
        if (office.isPresent()) {
            return OfficeDTO.toDTO(office.get());
        }
        return null;
    }

    @Override
    public List<Object> getCodeAndCityFromOffices() {
        return officeRepository.getCodeAndCityFromOffices();
    }

    @Override
    public List<Object> getCityAndNumberByCountry(String country) {
        return officeRepository.getCityAndNumberByCountry(country);
    }
}
