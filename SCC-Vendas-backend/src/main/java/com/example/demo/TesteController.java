package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class TesteController {

    @GetMapping("/")
    public String testeDeFuncionamento() {
        return "API do SCC-Vendas a funcionar em pleno! Bem-vindo ao Back-end, Bruno.";
    }

    // NOVA ROTA: Agora devolve a lista de clientes do protótipo
    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        // Clientes extraídos do design do painel de controlo
        Cliente c1 = new Cliente(1, "João Paulo", "111.111.111-11");
        Cliente c2 = new Cliente(2, "Maria Barros", "222.222.222-22");
        Cliente c3 = new Cliente(3, "Carlos Henrique", "333.333.333-33");
        Cliente c4 = new Cliente(4, "Clínica Santa Maria", "00.000.000/0001-00"); // Usando formato CNPJ para a clínica

        // Juntamos todos numa lista e devolvemos
        return Arrays.asList(c1, c2, c3, c4);
    }
    }
