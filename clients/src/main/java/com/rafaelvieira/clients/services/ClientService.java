package com.rafaelvieira.clients.services;

import com.rafaelvieira.clients.dto.ClientDTO;
import com.rafaelvieira.clients.entities.Clients;
import com.rafaelvieira.clients.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPage(PageRequest pageRequest) {
        Page<Clients> poge = repository.findAll(pageRequest);
        return poge.map(x -> new ClientDTO(x));
    }
}
