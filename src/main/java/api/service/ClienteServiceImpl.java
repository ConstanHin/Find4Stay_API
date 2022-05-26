package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.IClienteDAO;
import api.dto.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	IClienteDAO iClienteDAO;

	/**
	 * Listar todos los cliente
	 */
	@Override
	public List<Cliente> listarClientes() {
		return null;
	}

	/**
	 * Listar un cliente por id
	 */
	@Override
	public Cliente getById(Long id) {
		return null;
	}

	/**
	 * Anadir un nuevo cliente
	 */
	@Override
	public Cliente addNewCliente(Cliente cliente) {
		return null;
	}

	/**
	 * Actualizar cliente
	 */
	@Override
	public Cliente updateCliente(Cliente cliente) {
		return null;
	}

	/**
	 * Eliminar cliente
	 */
	@Override
	public void deleteCliente(Long id) {
		iClienteDAO.deleteById(id);
	}

}
