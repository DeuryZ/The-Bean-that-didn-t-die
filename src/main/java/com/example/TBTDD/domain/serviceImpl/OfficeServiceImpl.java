package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.EmployeeRepository;
import com.example.TBTDD.domain.repository.OfficeRepository;
import com.example.TBTDD.domain.service.OfficeService;
import com.example.TBTDD.persistence.DTO.OfficeDTO;
import com.example.TBTDD.persistence.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public List<OfficeDTO> findAllOffices() {
        List<OfficeDTO> officeDTOs = new ArrayList<>();
        List<Office> offices = officeRepository.findAll();
        offices.forEach(office -> {
            OfficeDTO officeDTO = OfficeDTO.toDTO(office);
            officeDTOs.add(officeDTO);
        });
        return officeDTOs;
    }

    @Override
    public OfficeDTO getOfficeById(String officeId) {
        Office office = officeRepository.findById(officeId).get();
        OfficeDTO officeDTO = OfficeDTO.toDTO(office);
        return officeDTO;
    }
}