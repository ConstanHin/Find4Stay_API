package api.service;

import java.util.List;

import api.dto.Reserva;

public interface IReservaService {

	//Métodos del CRUD
	
		//Lista de reservas
		public List <Reserva> listarReservas();
		
		
		//Guardar
		public Reserva guardarReservas(Reserva reservas);
		
		
		//Leer
		public Reserva reservasID(Integer id);
		
		
		//Actualizar
		public Reserva actualizarReservas(Reserva reservas);
		
		
		//Elimina la reserva
		public void eliminarReservas(Integer id);
}
