package LojaElias.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LojaElias.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
