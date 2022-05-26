package api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.dto.Cliente;

public interface IClienteDAO extends JpaRepository<Cliente, Long> {

}
