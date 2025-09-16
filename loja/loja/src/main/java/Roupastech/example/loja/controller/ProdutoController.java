package Roupastech.example.loja.controller;
import Roupastech.example.loja.model.Produto;
import Roupastech.example.loja.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Long id) {
        return produtoRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/vitrine")
    public List<Produto> listarDestaques() {
        return produtoRepository.findByDestaqueTrue();
    }

    @GetMapping("/busca")
    public List<Produto> buscar(@RequestParam String termo) {
        return produtoRepository.findByNomeContainingIgnoreCase(termo);
    }

    @PostMapping
    public Produto criar(@RequestBody Produto p) {
        return produtoRepository.save(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto p) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(p.getNome());
            produto.setPreco(p.getPreco());
            produto.setDestaque(p.isDestaque());
            produto.setDescricao(p.getDescricao());
            return ResponseEntity.ok(produtoRepository.save(produto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}