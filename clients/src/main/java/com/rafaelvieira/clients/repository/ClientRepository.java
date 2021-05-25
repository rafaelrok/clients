package com.rafaelvieira.clients.repository;

import com.rafaelvieira.clients.entities.Clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Clients, Long>{
    
}
