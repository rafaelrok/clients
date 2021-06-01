package com.rafaelvieira.clients.services;

import java.util.Optional;

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

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Clients> obj = repository.findById(id);
        Clients entity = obj.get();
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO save(ClientDTO dto) {
        Clients entity = new Clients();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Clients entity = repository.getOne(id);
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
