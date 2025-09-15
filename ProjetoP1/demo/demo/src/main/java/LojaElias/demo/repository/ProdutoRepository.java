package LojaElias.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import LojaElias.demo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDestaqueTrue();
    List<Produto> findByNomeContainingIgnoreCase(String termo);
}
