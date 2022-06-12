
package api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.Cuenta;
import api.dto.Hotel;
import api.service.CuentaServiceImpl;
import api.service.HotelServiceImpl;
import api.service.IHotelService;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImp;

	@Autowired
	CuentaServiceImpl cuentaServiceImpl;

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/hoteles")
	public List<Hotel> listarHotel() {
		return hotelServiceImp.listarHotel();
	}

	@PostMapping("/hoteles")
	public Hotel guardarHotel(@RequestBody Hotel Hotel) {
		return hotelServiceImp.guardarHotel(Hotel);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/hoteles/{id}")
	public Hotel Hotel_ID(@PathVariable(name = "id") Long id) {

		Hotel hotel_id = new Hotel();

		hotel_id = hotelServiceImp.HotelXID(id);
		return hotel_id;
	}

	@PutMapping("/hoteles/{id}")
	public Hotel actualizarHotel(@PathVariable(name = "id") Long id, @RequestBody Hotel hotel) {

		Hotel hotel_seleccionado = new Hotel();
		Hotel hotel_actualizado = new Hotel();

		hotel_seleccionado = hotelServiceImp.HotelXID(id);

		hotel_seleccionado.setNombre(hotel.getNombre());
		hotel_seleccionado.setCategoria(hotel.getCategoria());
		hotel_seleccionado.setPoblacion(hotel.getPoblacion());
		hotel_seleccionado.setUbicacion(hotel.getUbicacion());
		hotel_seleccionado.setPrecio(hotel.getPrecio());
		hotel_seleccionado.setEmpresa(hotel.getEmpresa());

		hotel_actualizado = hotelServiceImp.actualizarHotel(hotel_seleccionado);

		return hotel_actualizado;
	}

	@DeleteMapping("/hoteles/{id}")
	public void eleiminarHotel(@PathVariable(name = "id") Long id) {
		hotelServiceImp.eliminarHotel(id);
	}

	/**
	 * Devulve los hoteles pertenecientes solo a la empresa autenticada
	 * 
	 */
	@PreAuthorize("hasAnyAuthority('ROLE_EMPRESA')")
	@GetMapping("/hoteles/empresa")
	public List<Hotel> getHotelesOfEmpresaAuthenticated() {

		// Obtenemos authenticated
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// Obtenemos la cuenta a partir del nombre de la cuenta authenticated
		Cuenta cuenta = cuentaServiceImpl.getCuentaByUsername(authentication.getName());

		// Obtener id empresa
		Long idEmpresa = cuenta.getEmpresa().getId();

		// Llamar al hotel service para devolvernos
		// los hoteles relacionados con la empresa
		List<Hotel> hoteles = hotelServiceImp.getHotelesByEmpresaId(idEmpresa.intValue());
		System.out.println("Hoteles: " + hoteles);

		return hoteles;
	}

}