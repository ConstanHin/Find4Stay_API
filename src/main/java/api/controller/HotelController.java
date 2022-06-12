
package api.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.Empresa;
import api.dto.Hotel;
import api.service.HotelServiceImpl;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelServiceImpl HotelServiceImpl;
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/hoteles")
	public List<Hotel> listarHotel(){
		return HotelServiceImpl.listarHotel();
	}
	
	@PostMapping("/hoteles")
	public Hotel guardarHotel(@RequestBody Hotel Hotel){
		return HotelServiceImpl.guardarHotel(Hotel);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/hoteles/{id}")
	public Hotel Hotel_ID(@PathVariable(name="id") Long id) {
		
		Hotel hotel_id= new Hotel();
		
		hotel_id=HotelServiceImpl.HotelXID(id);
		return hotel_id;
	}
	
	@PutMapping("/hoteles/{id}")
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
		
		hotel_actualizado = HotelServiceImpl.actualizarHotel(hotel_seleccionado);
		
		return hotel_actualizado;
	}
	
	@DeleteMapping("/hoteles/{id}")
	public void eliminarHotel(@PathVariable(name="id")Long id) {
		HotelServiceImpl.eliminarHotel(id);
	}
	
	
	public void getHotelesPorEmpresa() {
		
		
	}
}