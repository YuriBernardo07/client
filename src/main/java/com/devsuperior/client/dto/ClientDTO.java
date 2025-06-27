package com.devsuperior.client.dto;

import com.devsuperior.client.entities.Client;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Optional;

public class ClientDTO {

    private Long id;
    @Size(min = 3 , max = 80 , message = "o campo deve ter entre 3 e 80 caracteres")
    @NotBlank(message = "campo requerido")
    private String name;
    private String cpf;
    @Positive(message = "O valor da renda não pode ser negativo")
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(){

    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }
    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
