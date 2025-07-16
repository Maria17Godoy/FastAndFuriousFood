/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.godoy.FastAndFuriousFood.domain.repository;

import java.util.List;
import local.godoy.FastAndFuriousFood.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ppjatb
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContaining(String nome);
    Produto findByNomeAndCategoria(String nome, String categoria);
}
