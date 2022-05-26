package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.Hotel;
import api.service.HotelServiceImpl;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelServiceImpl HotelServiceImpl;
	
	@GetMapping("/Hotel")
	public List<Hotel> listarHotel(){
		return HotelServiceImpl.listarHotel();
	}
	
	@PostMapping("/Hotel")
	public Hotel guardarHotel(@RequestBody Hotel Hotel){
		return HotelServiceImpl.guardarHotel(Hotel);
	}
	
	@GetMapping("/Hotel/{id}")
	public Hotel hotel_ID(@PathVariable(name="id_Hotel") Long id) {
		
		Hotel hotel_id= new Hotel();
		
		hotel_id=HotelServiceImpl.HotelXID(id);
		
		return hotel_id;
	}
	
	@PutMapping("/Hotel/{id}")
	public Hotel actualizarHotel(@PathVariable(name="id")Long id,@RequestBody Hotel hotel) {
		
		Hotel hotel_seleccionado= new Hotel();
		Hotel hotel_actualizado= new Hotel(); 
		
		hotel_seleccionado= HotelServiceImpl.HotelXID(id);
		
		hotel_seleccionado.setNombre(hotel.getNombre());
		hotel_seleccionado.setCategoria(hotel.getCategoria());
		hotel_seleccionado.setPoblacion(hotel.getPoblacion());
		hotel_seleccionado.setUbicacion(hotel.getUbicacion());
		hotel_seleccionado.setPrecio(hotel.getPrecio());
		hotel_seleccionado.setEmpresa(hotel.getEmpresa());
		
		return hotel_actualizado;
	}
	
	@DeleteMapping("/Hotel/{id}")
	public void eleiminarHotel(@PathVariable(name="id")Long id) {
		HotelServiceImpl.eliminarHotel(id);
	}
}