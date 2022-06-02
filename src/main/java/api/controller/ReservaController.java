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
	public List<Reserva> listarReservas() {
		return reservasServiceImpl.listarReservas();
	}

	@PostMapping("/reservas")
	public Reserva guardarReservas(@RequestBody Reserva reservas) throws Exception {

		// que no sea null el cliente y el hotel
		if (reservas.getCliente() == null || reservas.getHotel() == null) {
			throw new Exception("La reserva debe tener un cliente y un hotel");
		}

		return reservasServiceImpl.guardarReservas(reservas);

	}

	@GetMapping("/reservas/{id}")
	public Reserva Reservas_ID(@PathVariable(name = "id") Long id) {

		Reserva reservas_id = new Reserva();

		reservas_id = reservasServiceImpl.reservasID(id);

		return reservas_id;
	}

	@PutMapping("/reservas/{id}")
	public Reserva actualizarReservas(@PathVariable(name = "id") Long id, @RequestBody Reserva reserva) {

		Reserva reservas_seleccionado = new Reserva();
		Reserva reservas_actualizado = new Reserva();

		reservas_seleccionado = reservasServiceImpl.reservasID(id);
		reservas_seleccionado.setCodigo(reserva.getCodigo());
		reservas_seleccionado.setFecha_entrada(reserva.getFecha_entrada());
		reservas_seleccionado.setFecha_salida(reserva.getFecha_salida());
		reservas_seleccionado.setImporte_reserva(reserva.getImporte_reserva());
		reservas_seleccionado.setHotel(reserva.getHotel());
		reservas_seleccionado.setCliente(reserva.getCliente());

		reservas_actualizado = reservasServiceImpl.actualizarReservas(reservas_seleccionado);

		return reservas_actualizado;
	}

	@DeleteMapping("/reservas/{id}")
	public void eleiminarReservas(@PathVariable(name = "id") Long id) {
		reservasServiceImpl.eliminarReservas(id);
	}
}
