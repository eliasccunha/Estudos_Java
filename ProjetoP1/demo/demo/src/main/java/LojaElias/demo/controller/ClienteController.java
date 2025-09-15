package LojaElias.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import LojaElias.demo.model.Cliente;
import LojaElias.demo.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // POST - cadastrar cliente
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(service.salvar(cliente));
    }

    // PUT - atualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(service.atualizar(id, cliente));
    }

    // DELETE - remover cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // GET - buscar cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET - listar todos
    @GetMapping
    public List<Cliente> listarTodos() {
        return service.listarTodos();
    }

    // POST - login
    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestParam String email, @RequestParam String senha) {
        Optional<Cliente> cliente = service.login(email, senha);
        return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.status(401).build());
    }

    // PATCH - ativar cliente via link de email
    @PatchMapping("/ativar")
    public ResponseEntity<Cliente> ativar(@RequestParam String email) {
        return service.ativarConta(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET - redefinição de senha
    @GetMapping("/redefinir")
    public ResponseEntity<String> redefinir(@RequestParam String email) {
        service.enviarRedefinicaoSenha(email);
        return ResponseEntity.ok("Email de redefinição enviado, verifique sua caixa de entrada.");
    }
}
