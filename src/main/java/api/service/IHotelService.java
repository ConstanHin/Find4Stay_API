package api.service;

import java.util.List;

import api.dto.Hotel;

public interface IHotelService {

		public List<Hotel> listarHotel();
		
		public Hotel guardarHotel(Hotel hoteles);
		
		public Hotel HotelXID(Integer id);
		
		public Hotel actualizarHotel(Hotel hoteles);
	
		public void eliminarHotel(Integer id);
}
