package api.service;

import java.util.List;

import api.dto.Empresa;

public interface IEmpresaService {

	// Métodos del CRUD

	// Lista de reservas
	public List<Empresa> listarEmpresa();

	// Guardar
	public Empresa guardarReservas(Empresa empresa);

	// Leer
	public Empresa empresaID(Long id);

	// Actualizar
	public Empresa actualizarEmpresa(Empresa empresa);

	// Elimina la reserva
	public void eliminarEmpresa(Long id);
}
