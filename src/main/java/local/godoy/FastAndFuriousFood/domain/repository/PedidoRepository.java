/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package local.godoy.FastAndFuriousFood.domain.repository;

import java.util.List;
import local.godoy.FastAndFuriousFood.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    List<Pedido> findByStatus(String status);
}
