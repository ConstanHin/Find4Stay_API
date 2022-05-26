package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.IReservaDAO;
import api.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	IReservaDAO ireservasDAO;

	@Override
	public List<Reserva> listarReservas() {
		
		return ireservasDAO.findAll();
	}

	@Override
	public Reserva guardarReservas(Reserva reservas) {
		
		return ireservasDAO.save(reservas);
	}

	@Override
	public Reserva reservasID(Integer id) {
		
		return ireservasDAO.findById(id).get();
	}

	@Override
	public Reserva actualizarReservas(Reserva reservas) {
		
		return ireservasDAO.save(reservas);
	}

	@Override
	public void eliminarReservas(Integer id) {
		ireservasDAO.deleteById(id);
		
	}
}
