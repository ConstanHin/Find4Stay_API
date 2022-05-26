package api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import api.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Long>{

}
