package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarProdutos() {
        if (produtoRepository.count() == 0) {
            produtoRepository.save(new Produto("Notebook", 3500.00));
            produtoRepository.save(new Produto("Mouse Sem Fio", 85.50));
        }
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto novoProduto) {
        return produtoRepository.save(novoProduto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return produtoRepository.save(produto);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void apagarProduto(@PathVariable Integer id) {
        produtoRepository.deleteById(id);
    }
}