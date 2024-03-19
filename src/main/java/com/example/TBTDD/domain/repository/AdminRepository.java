package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findByEmail(String email);
}
