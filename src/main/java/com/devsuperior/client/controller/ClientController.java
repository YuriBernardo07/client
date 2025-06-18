package com.devsuperior.client.controller;

import com.devsuperior.client.dto.ClientDTO;
import com.devsuperior.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

        @GetMapping(value = "/{id}")
        public ResponseEntity<ClientDTO > findById(@PathVariable Long id){
            ClientDTO dto = clientService.findById(id);

            return ResponseEntity.ok(dto) ;
        }

        @GetMapping
        public ResponseEntity<Page<ClientDTO>>  findAll(Pageable pageable){

            Page<ClientDTO> dto = clientService.findAll(pageable);
            return ResponseEntity.ok(dto);
        }

        @PostMapping
        public ResponseEntity<ClientDTO> insert (@RequestBody ClientDTO dto){
            clientService.insert(dto);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto) ;

        }
        @PutMapping(value = "/{id}")
        public ResponseEntity<ClientDTO> update (@PathVariable Long id , @RequestBody ClientDTO dto){
            return ResponseEntity.ok(clientService.update(id, dto));
        }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id ){
            clientService.delete(id);
            return ResponseEntity.noContent().build();
    }


}
