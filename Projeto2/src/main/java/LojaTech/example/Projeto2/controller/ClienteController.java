package LojaTech.example.Projeto2.controller;

import LojaTech.example.Projeto2.model.Cliente;
import LojaTech.example.Projeto2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public Cliente criar(@RequestBody Cliente c) {
        Cliente clienteSalvo = clienteRepository.save(c);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(c.getEmail());
        message.setSubject("Confirme seu cadastro");
        message.setText("Clique no link para ativar: http://localhost:8080/clientes/ativar/" + c.getId());
        mailSender.send(message);
        return clienteSalvo;
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
