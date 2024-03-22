package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.serviceImpl.AdminServiceImpl;
import com.example.TBTDD.persistence.entity.Admin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Operation (summary = "Get all admins for the application")
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public List<Admin> findAllAdmins() {
        return adminService.findAllAdmins();
    }

    @Operation (summary = "Get an admin for id")
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public Admin findAdminById(@PathVariable String id) {
        return adminService.findAdminById(id);
    }
    @Operation (summary = "Save all admin for the application")
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @Operation (summary = "Delete an admin by ID")
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public void deleteAdminById(@PathVariable String id) {
        adminService.deleteAdminById(id);
    }

}
