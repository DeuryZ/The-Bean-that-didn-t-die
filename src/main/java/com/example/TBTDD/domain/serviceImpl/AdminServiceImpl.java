package com.example.TBTDD.domain.serviceImpl;

import com.example.TBTDD.domain.repository.AdminRepository;
import com.example.TBTDD.domain.service.AdminService;
import com.example.TBTDD.persistence.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findAdminById(String id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdminById(String id) {
        adminRepository.deleteById(id);
    }
}
