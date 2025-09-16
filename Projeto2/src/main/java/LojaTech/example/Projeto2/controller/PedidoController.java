package LojaTech.example.Projeto2.controller;

import LojaTech.example.Projeto2.model.Pedido;
import LojaTech.example.Projeto2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public Pedido criar(@RequestBody Pedido p) {
        Pedido pedidoSalvo = pedidoRepository.save(p);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(p.getCliente().getEmail());
        message.setSubject("Pedido confirmado");
        message.setText("Seu pedido #" + pedidoSalvo.getId() + " foi recebido com sucesso!");
        mailSender.send(message);
        return pedidoSalvo;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido p) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setItens(p.getItens());
            return ResponseEntity.ok(pedidoRepository.save(pedido));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedido(@PathVariable Long id) {
        return pedidoRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{id}")
    public List<Pedido> listarPorCliente(@PathVariable Long id) {
        return pedidoRepository.findByClienteId(id);
    }

    @GetMapping("/listar")
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
}
