package Roupastech.example.loja.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Roupastech.example.loja.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDestaqueTrue();
    List<Produto> findByNomeContainingIgnoreCase(String termo);
    
    
}

