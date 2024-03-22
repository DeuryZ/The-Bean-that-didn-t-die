package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.exception.GlobalExceptionHandler;
import com.example.TBTDD.domain.repository.AdminRepository;
import com.example.TBTDD.domain.security.JWTAuthtenticationConfig;
import com.example.TBTDD.persistence.entity.Admin;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Login resources")
public class LoginController {

    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Operation(summary = "Login For the application")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/login")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        Admin admin = adminRepository.findByEmail(email);

        if (admin != null && admin.getPassword().equals(password)) {
            String token = jwtAuthtenticationConfig.getJWTToken(email);
            adminRepository.save(admin);
            return token;
        } else {
            throw new RuntimeException("Invalid Information");
        }
    }
}
