package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.IHotelDAO;
import api.dto.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	IHotelDAO iHotelDAO;
	
	@Override
	public List<Hotel> listarHotel() {
		return iHotelDAO.findAll();
	}

	@Override
	public Hotel guardarHotel(Hotel hoteles) {
		return iHotelDAO.save(hoteles);
	}

	@Override
	public Hotel HotelXID(Long id) {
		return iHotelDAO.findById(id).get();
	}

	@Override
	public Hotel actualizarHotel(Hotel hoteles) {
		return iHotelDAO.save(hoteles);
	}

	@Override
	public void eliminarHotel(Long id) {
		iHotelDAO.deleteById(id);
	}
	
	public List<Hotel> getHotelesByEmpresaId(Integer empresaId) {
		return iHotelDAO.findHotelByEmpresaID(empresaId);
	}
<<<<<<< Updated upstream
	
	public List<Hotel> findHotelesByCiudad(String ciudad) {
		return iHotelDAO.findHotelesByCiudad(ciudad);
=======
	public List<Hotel> getHotelesByPoblacion(Integer poblacion) {
		return iHotelDAO.findHotelByPoblacion(poblacion);
>>>>>>> Stashed changes
	}

}
