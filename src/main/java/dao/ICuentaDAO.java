package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Cuenta;

public interface ICuentaDAO extends JpaRepository<Cuenta, Long> {

}
