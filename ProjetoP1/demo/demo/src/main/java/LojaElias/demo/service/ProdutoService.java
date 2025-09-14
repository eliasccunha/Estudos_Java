package LojaElias.demo.service;

import LojaElias.demo.model.Produto;
import LojaElias.demo.repository.ProdutoRepository;

public class ProdutoService {
    public Produto salvar(Produto p){
        return ProdutoRepository.save(p);
    }

    public produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public void deletar (Long id){
        produtoRepository.deleteById(id);
    }

    public List<Produto> listarTodos(){
        return ProdutoRepository.findAll();
    }

    public List<Produto> listarDestaques(){
        return produtoRepository.findByDestaqueTrue();
    }

    public List<Produto> buscarPorTemo(String termo){
        return produtoRepository.findByNomeContainingIgnoreCase(termo);

}
