package LojaElias.demo.controller;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) { return produtoService.salvar(produto); }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { produtoService.deletar(id); }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) { return produtoService.buscarPorId(id); }

    @GetMapping
    public List<Produto> listarTodos() { return produtoService.listarTodos(); }

    @GetMapping("/vitrine")
    public List<Produto> vitrine() { return produtoService.listarDestaques(); }

    @GetMapping("/busca")
    public List<Produto> buscar(@RequestParam String termo) { return produtoService.buscarPorTermo(termo); }
}

