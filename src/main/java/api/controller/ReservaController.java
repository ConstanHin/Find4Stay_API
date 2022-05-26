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

import api.dto.Reserva;
import api.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservasServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReservas(){
		return reservasServiceImpl.listarReservas();
	}
	
	@PostMapping("/reservas")
	public Reserva guardarReservas(@RequestBody Reserva reservas){
		return reservasServiceImpl.guardarReservas(reservas);
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva Reservas_ID(@PathVariable(name="id_reservas") Long id) {
		
		Reserva Reservas_id= new Reserva();
		
		Reservas_id=reservasServiceImpl.reservasID(id);
		
		return Reservas_id;
	}
	
	@PutMapping("/reservas/{id}")
	public Reserva actualizarReservas(@PathVariable(name="id")Long id,@RequestBody Reserva reservas) {
		
		Reserva Reservas_seleccionado= new Reserva();
		Reserva Reservas_actualizado= new Reserva(); 
		
		Reservas_seleccionado= reservasServiceImpl.reservasID(id);
		
		Reservas_seleccionado.setCodigo(reservas.getCodigo());
		Reservas_seleccionado.setFecha_entrada(reservas.getFecha_entrada());
		Reservas_seleccionado.setFecha_salida(reservas.getFecha_salida());
		Reservas_seleccionado.setImporte_reserva(reservas.getImporte_reserva());
		
		return Reservas_actualizado;
	}
	
	@DeleteMapping("/reservas/{id}")
	public void eleiminarReservas(@PathVariable(name="id")Long id) {
		reservasServiceImpl.eliminarReservas(id);
	}
}
