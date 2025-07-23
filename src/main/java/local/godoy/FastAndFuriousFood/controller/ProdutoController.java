/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.godoy.FastAndFuriousFood.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import local.godoy.FastAndFuriousFood.domain.model.Pedido;
import local.godoy.FastAndFuriousFood.domain.model.Produto;
import local.godoy.FastAndFuriousFood.domain.repository.ProdutoRepository;
import local.godoy.FastAndFuriousFood.domain.service.PedidoService;
import local.godoy.FastAndFuriousFood.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;
                
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll(); 
    }

    @GetMapping("/{produtoID}")
    public ResponseEntity<Produto> buscar(@PathVariable Long produtoID) {
        return produtoRepository.findById(produtoID)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@Valid @RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @PutMapping("/{produtoID}")
    public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long produtoID, @Valid @RequestBody Produto produto) {
        if (!produtoRepository.existsById(produtoID)) {
            return ResponseEntity.notFound().build();
        }

        produto.setId(produtoID);
        Produto atualizado = produtoService.salvar(produto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{produtoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long produtoID) {
        if (!produtoRepository.existsById(produtoID)) {
            return ResponseEntity.notFound().build();
        }

        produtoService.excluir(produtoID);
        return ResponseEntity.noContent().build();
    }
    
}

