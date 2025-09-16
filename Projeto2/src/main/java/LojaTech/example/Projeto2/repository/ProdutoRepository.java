package LojaTech.example.Projeto2.repository;

import LojaTech.example.Projeto2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDestaqueTrue();
    List<Produto> findByNomeContainingIgnoreCase(String termo);
}
