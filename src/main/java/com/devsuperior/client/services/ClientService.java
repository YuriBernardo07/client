package com.devsuperior.client.services;

import com.devsuperior.client.dto.ClientDTO;
import com.devsuperior.client.entities.Client;
import com.devsuperior.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById (Long id ){

        Optional<Client> c1 = repository.findById(id);
        Client client = c1.get();
        ClientDTO clientDTO = new ClientDTO(client);

        return clientDTO;
    }
    @Transactional(readOnly = true)
    public List<ClientDTO> findAll(){
        List<Client> result = repository.findAll();
        return result.stream().map(x-> new ClientDTO(x)).toList();
    }
}
