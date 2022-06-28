package api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Long>{
	
	@Query(value = "SELECT * FROM reservas WHERE (id_cliente = ?1)", nativeQuery = true)
	List<Reserva> findReservasByClienteId(Integer clienteId);

}
