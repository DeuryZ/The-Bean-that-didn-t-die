package com.example.TBTDD.domain.repository;

import com.example.TBTDD.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {

}
