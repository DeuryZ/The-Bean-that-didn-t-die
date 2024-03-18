package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.AdminServiceImpl;
import com.example.TBTDD.persistence.entity.Admin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all")
    public List<Admin> findAllAdmins() {
        return adminService.findAllAdmins();
    }

    @GetMapping("/{id}")
    public Admin findAdminById(@PathVariable String id) {
        return adminService.findAdminById(id);
    }

    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdminById(@PathVariable String id) {
        adminService.deleteAdminById(id);
    }

}
