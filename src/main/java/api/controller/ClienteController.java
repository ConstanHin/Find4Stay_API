package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.Cliente;
import api.service.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteServiceImpl clienteServiceImpl;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		return clienteServiceImpl.listarClientes();
	}

	// Get cliente by id
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/clientes/{id}")
	public Cliente listarPorDni(@PathVariable(name = "id") Long id) {
		return clienteServiceImpl.getById(id);
	}

	// Add Cliente
	@PostMapping("/clientes")
	public Cliente addNewCliente(@RequestBody Cliente cliente) {
		return clienteServiceImpl.addNewCliente(cliente);
	}

	// Update Cliente
	@PutMapping("/clientes/{id}")
	public Cliente updateCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {

		Cliente cliente_seleccionada = new Cliente();
		Cliente cliente_actualizada = new Cliente();

		cliente_seleccionada = clienteServiceImpl.getById(id);

		cliente_seleccionada.setNombre(cliente.getNombre());
		cliente_seleccionada.setApellido(cliente.getApellido());
		cliente_seleccionada.setDni(cliente.getDni());
		cliente_seleccionada.setCuenta(cliente.getCuenta());

		cliente_actualizada = clienteServiceImpl.updateCliente(cliente_seleccionada);
		return cliente_actualizada;
	}

	// Delete cliente
	@DeleteMapping("/clientes/{id}")
	public void deleteCliente(@PathVariable(name = "id") Long id) {
		clienteServiceImpl.deleteCliente(id);
	}

}
