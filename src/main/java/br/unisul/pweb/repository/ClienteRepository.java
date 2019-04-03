package br.unisul.pweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.pweb.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {

}

