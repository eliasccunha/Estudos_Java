package Roupastech.example.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Roupastech.example.loja.Repository.ClienteRepository;
import Roupastech.example.loja.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente criar(@RequestBody Cliente c) {
        // apenas salva no banco, sem envio de email
        return clienteRepository.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente c) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(c.getNome());
            cliente.setEmail(c.getEmail());
            cliente.setSenha(c.getSenha());
            return ResponseEntity.ok(clienteRepository.save(cliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        return clienteRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody Cliente c) {
        return clienteRepository.findByEmailAndSenha(c.getEmail(), c.getSenha())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    @PatchMapping("/ativar/{id}")
    public ResponseEntity<String> ativar(@PathVariable Long id) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setAtivo(true);
            clienteRepository.save(cliente);
            return ResponseEntity.ok("Cliente ativado");
        }).orElse(ResponseEntity.notFound().build());
    }
}
////// esse aqui 