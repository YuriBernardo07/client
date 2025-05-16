package com.devsuperior.client.controller;

import com.devsuperior.client.dto.ClientDTO;
import com.devsuperior.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

        @GetMapping(value = "/{id}")
        public ClientDTO findById(@PathVariable Long id){

            return clientService.findById(id);
        }

        @GetMapping
        public List<ClientDTO> findAll(){
            return clientService.findAll();
        }
}
