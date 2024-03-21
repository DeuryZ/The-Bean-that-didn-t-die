package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.AdminServiceImpl;
import com.example.TBTDD.persistence.entity.Admin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Tag(name = "Admin Resources")
public class AdminController {
    private final AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }
    @Operation (summary = "Find all admins for the application")
    @GetMapping("/all")
    public List<Admin> findAllAdmins() {
        return adminService.findAllAdmins();
    }

    @Operation (summary = "Get an admin for id")
    @GetMapping("/{id}")
    public Admin findAdminById(@PathVariable String id) {
        return adminService.findAdminById(id);
    }
    @Operation (summary = "Save all admin for the application")
    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @Operation (summary = "Delete an admin by ID")
    @DeleteMapping("/delete/{id}")
    public void deleteAdminById(@PathVariable String id) {
        adminService.deleteAdminById(id);
    }

}
