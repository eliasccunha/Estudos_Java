package LojaElias.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDestaqueTrue();
    List<Produto> findBynomeContainIgnoreCase(String termo);
}
