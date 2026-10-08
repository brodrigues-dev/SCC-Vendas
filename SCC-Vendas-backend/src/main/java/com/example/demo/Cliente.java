package com.example.demo;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;

    // Construtor
    public Cliente(int idCliente, String nome, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
    }

    // Os "Getters" são obrigatórios para o Spring Boot conseguir ler os dados e transformar em JSON
    public int getIdCliente() { return idCliente; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
}