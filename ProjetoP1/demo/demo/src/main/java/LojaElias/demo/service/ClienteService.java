package LojaElias.demo.service;

import LojaElias.demo.model.Cliente;
import LojaElias.demo.repository.ClienteRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final JavaMailSender mailSender;

    public ClienteService(ClienteRepository repository, JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    // POST - cadastrar cliente e enviar email de confirmação
    public Cliente salvar(Cliente cliente) {
        Cliente salvo = repository.save(cliente);

        // gera token fake de ativação
        String token = UUID.randomUUID().toString();
        String linkAtivacao = "http://localhost:8080/clientes/ativar?email=" + salvo.getEmail();

        enviarEmail(salvo.getEmail(), "Confirmação de Cadastro",
                "Bem-vindo, " + salvo.getNome() +
                        "! Clique no link para ativar sua conta: " + linkAtivacao);

        return salvo;
    }

    // PUT - atualizar cliente
    public Cliente atualizar(Long id, Cliente cliente) {
        cliente.setId(id);
        return repository.save(cliente);
    }

    // DELETE - remover cliente
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // GET - buscar cliente por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // GET - listar todos os clientes
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    // POST - login
    public Optional<Cliente> login(String email, String senha) {
        return repository.findByEmail(email)
                .filter(c -> c.getSenha().equals(senha) && Boolean.TRUE.equals(c.getAtivo()));
    }

    // PATCH - ativar cliente
    public Optional<Cliente> ativarConta(String email) {
        return repository.findByEmail(email).map(cliente -> {
            cliente.setAtivo(true);
            return repository.save(cliente);
        });
    }

    // GET - redefinir senha (manda email)
    public void enviarRedefinicaoSenha(String email) {
        repository.findByEmail(email).ifPresent(cliente -> {
            String link = "http://localhost:8080/clientes/redefinir?email=" + cliente.getEmail();
            enviarEmail(cliente.getEmail(), "Redefinição de Senha",
                    "Clique no link para redefinir sua senha: " + link);
        });
    }

    // Função utilitária para envio de email
    private void enviarEmail(String para, String assunto, String texto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(para);
        message.setSubject(assunto);
        message.setText(texto);
        mailSender.send(message);
    }
}
