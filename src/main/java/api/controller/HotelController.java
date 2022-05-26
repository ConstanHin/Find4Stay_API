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
	public Hotel Hotel_ID(@PathVariable(name="id_Hotel") Long id) {
		
		Hotel Hotel_id= new Hotel();
		
		Hotel_id=HotelServiceImpl.HotelXID(id);
		
		return Hotel_id;
	}
	
	@PutMapping("/Hotel/{id}")
	public Hotel actualizarHotel(@PathVariable(name="id")Long id,@RequestBody Hotel Hotel) {
		
		Hotel Hotel_seleccionado= new Hotel();
		Hotel Hotel_actualizado= new Hotel(); 
		
		Hotel_seleccionado= HotelServiceImpl.HotelXID(id);
		
		Hotel_seleccionado.setNombre(Hotel.getNombre());
		Hotel_seleccionado.setCategoria(Hotel.getCategoria());
		Hotel_seleccionado.setPoblacion(Hotel.getPoblacion());
		Hotel_seleccionado.setUbicacion(Hotel.getUbicacion());
		Hotel_seleccionado.setPrecio(Hotel.getPrecio());
		
		return Hotel_actualizado;
	}
	
	@DeleteMapping("/Hotel/{id}")
	public void eleiminarHotel(@PathVariable(name="id")Long id) {
		HotelServiceImpl.eliminarHotel(id);
	}
}