package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
