package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TesteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/")
    public String testeDeFuncionamento() {
        return "API do SCC-Vendas a funcionar em pleno! Base de dados ligada.";
    }

    // 1. LER TODOS (GET)
    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        if (clienteRepository.count() == 0) {
            clienteRepository.save(new Cliente("João Paulo", "111.111.111-11"));
            clienteRepository.save(new Cliente("Maria Barros", "222.222.222-22"));
            clienteRepository.save(new Cliente("Carlos Henrique", "333.333.333-33"));
            clienteRepository.save(new Cliente("Clínica Santa Maria", "00.000.000/0001-00"));
        }
        return clienteRepository.findAll();
    }

    // 2. CRIAR NOVO (POST)
    @PostMapping("/clientes")
    public Cliente adicionarCliente(@RequestBody Cliente novoCliente) {
        return clienteRepository.save(novoCliente);
    }

    // 3. ATUALIZAR EXISTENTE (PUT)
    @PutMapping("/clientes/{id}")
    public Cliente atualizarCliente(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
            return clienteRepository.save(cliente);
        }).orElse(null); // Se não encontrar o ID, não faz nada
    }

    // 4. APAGAR (DELETE)
    @DeleteMapping("/clientes/{id}")
    public void apagarCliente(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }
}