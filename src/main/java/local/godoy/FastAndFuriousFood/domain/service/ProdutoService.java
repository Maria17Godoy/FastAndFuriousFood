/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.godoy.FastAndFuriousFood.domain.service;

import local.godoy.FastAndFuriousFood.domain.exception.DomainException;
import local.godoy.FastAndFuriousFood.domain.model.Produto;
import local.godoy.FastAndFuriousFood.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto salvar(Produto produto){
        Produto produtoExistente = produtoRepository.findByNomeAndCategoria(produto.getNome(),produto.getCategoria());
        
        if (produtoExistente != null && !produtoExistente.equals(produto)){
            throw new DomainException("Ja existe um produto cadastrado com esse nome na mesma categoria!");
        }
        
        return produtoRepository.save(produto);
        
    }
    
    public void excluir(Long produtoId){
        produtoRepository.deleteById(produtoId);
    }
}
