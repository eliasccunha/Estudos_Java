package LojaElias.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import LojaElias.demo.model.Produto;
import LojaElias.demo.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        produto.setId(id);
        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public List<Produto> listarDestaque() {
        return repository.findByDestaqueTrue();
    }

    public List<Produto> buscarPorNome(String termo) {
        return repository.findByNomeContainingIgnoreCase(termo);
    }
}
