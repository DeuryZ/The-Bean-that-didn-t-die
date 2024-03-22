package com.example.TBTDD.domain.service;

import com.example.TBTDD.persistence.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAllAdmins();
    Admin findAdminById(String id);
    Admin saveAdmin(Admin admin);
    void deleteAdminById(String id);
}
