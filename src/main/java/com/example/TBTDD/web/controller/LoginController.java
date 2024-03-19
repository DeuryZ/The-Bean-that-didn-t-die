package com.example.TBTDD.web.controller;

import com.example.TBTDD.domain.repository.AdminRepository;
import com.example.TBTDD.domain.security.JWTAuthtenticationConfig;
import com.example.TBTDD.persistence.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private AdminRepository adminRepository;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/login")
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