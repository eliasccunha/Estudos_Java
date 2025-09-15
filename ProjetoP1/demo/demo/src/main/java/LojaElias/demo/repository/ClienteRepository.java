package LojaElias.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import LojaElias.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
