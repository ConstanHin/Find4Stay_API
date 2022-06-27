package api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.dto.Hotel;

public interface IHotelDAO extends JpaRepository<Hotel, Long> {
	
	@Query(value = "SELECT * FROM hoteles WHERE (id_empresa = ?1)", nativeQuery = true)
	List<Hotel> findHotelByEmpresaID(Integer empresaId);
	
	@Query(value = "SELECT * FROM hoteles WHERE (poblacion = ?1)", nativeQuery = true)
	List<Hotel> findHotelByPoblacion(long poblacion);

}
