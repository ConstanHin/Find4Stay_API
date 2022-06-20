package api.service;

import java.util.List;

import api.dto.Reserva;

public interface IReservaService {

	//Métodos del CRUD
	
		//Lista de reservas
		public List <Reserva> listarReservas();
		
		
		//Guardar
		public Reserva guardarReservas(Reserva reservas);
		
		
		//Leer por id
		public Reserva reservasID(Long id);
		
		
		//Actualizar
		public Reserva actualizarReservas(Reserva reservas);
		
		
		//Elimina la reserva
		public void eliminarReservas(Long id);
}
