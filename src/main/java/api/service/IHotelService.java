package api.service;

import java.util.List;

import api.dto.Hotel;

public interface IHotelService {
		
	//Metodos del CRUD
		public List<Hotel> listarHotel();
		
		public Hotel guardarHotel(Hotel hoteles);
		
		public Hotel HotelXID(Long id);
		
		public Hotel actualizarHotel(Hotel hoteles);
	
		public void eliminarHotel(Long id);
}
