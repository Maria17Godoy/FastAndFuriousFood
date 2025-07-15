/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.godoy.FastAndFuriousFood.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import local.godoy.FastAndFuriousFood.domain.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */
@RestController
public class ProdutoController {
    
    @PersistenceContext
    private EntityManager manager;
                
    @GetMapping("/produtos")
    public List<Produto> listas() {
        
        return manager.createQuery("from Produto", Produto.class).getResultList();
    }
}
