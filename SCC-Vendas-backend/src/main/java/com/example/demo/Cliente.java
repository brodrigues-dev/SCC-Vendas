package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nome;
    private String cpf;

    // Construtor vazio (é obrigatório para o Spring Data JPA funcionar)
    public Cliente() {
    }

    // Construtor sem o ID, porque a base de dados vai gerar o ID automaticamente!
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters
    public Integer getIdCliente() { return idCliente; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }

    // Setters (necessários para quando formos atualizar os dados mais tarde)
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}