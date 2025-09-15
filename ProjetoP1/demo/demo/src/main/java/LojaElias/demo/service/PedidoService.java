package LojaElias.demo.service;

import LojaElias.demo.model.ItemPedido;
import LojaElias.demo.model.Pedido;
import LojaElias.demo.repository.PedidoRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final JavaMailSender mailSender;

    public PedidoService(PedidoRepository repository, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    // POST - cadastrar pedido
    public Pedido salvar(Pedido pedido) {
        double total = pedido.getItens().stream()
                .mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
                .sum();

        pedido.setValorTotal(total);

        // garantir relacionamento bidirecional
        for (ItemPedido item : pedido.getItens()) {
            item.setPedido(pedido);
        }

        Pedido salvo = repository.save(pedido);

        enviarEmailConfirmacao(salvo);

        return salvo;
    }

    // PUT - atualizar pedido
    public Pedido atualizar(Long id, Pedido pedido) {
        pedido.setId(id);
        return repository.save(pedido);
    }

    // DELETE
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // GET por id
    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // GET todos
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    // Envio de email de confirmação
    private void enviarEmailConfirmacao(Pedido pedido) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(pedido.getCliente().getEmail());
        message.setSubject("Confirmação de Pedido #" + pedido.getId());
        message.setText("Olá " + pedido.getCliente().getNome() +
                ",\n\nSeu pedido foi realizado com sucesso!" +
                "\nValor total: R$ " + pedido.getValorTotal() +
                "\n\nObrigado por comprar na nossa loja.");
        mailSender.send(message);
    }
}
