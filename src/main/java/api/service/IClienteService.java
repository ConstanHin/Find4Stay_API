package api.service;

import java.util.List;

import api.dto.Cliente;

public interface IClienteService {
	
	// Listar todo
	public List<Cliente> listarClientes();
	
	// Get by id
	public Cliente getById(Long id);

	// Add
	public Cliente addNewCliente(Cliente cliente);

	// Update
	public Cliente updateCliente(Cliente cliente);

	// Delete
	public void deleteCliente(Long codigo);

}
