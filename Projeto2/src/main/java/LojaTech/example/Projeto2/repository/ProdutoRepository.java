package LojaTech.example.Projeto2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import LojaTech.example.Projeto2.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDestaqueTrue();
    List<Produto> findByNomeContainingIgnoreCase(String termo);
}
