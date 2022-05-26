package api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import api.dto.Cuenta;

public interface ICuentaDAO extends JpaRepository<Cuenta, Long> {

}
