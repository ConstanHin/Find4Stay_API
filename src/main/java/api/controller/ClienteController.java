package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.dto.Cliente;
import api.dto.Cuenta;
import api.models.CuentaCliente;
import api.service.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteServiceImpl clienteServiceImpl;
	
	@Autowired
	CuentaController cuentaController;
	

	
	public ClienteController() {
	}
	
	// Get all
	@GetMapping("/clientes")
	public List<Cliente> listarClientes() {
		return clienteServiceImpl.listarClientes();
	}

	// Get cliente by id
	@GetMapping("/clientes/{id}")
	public Cliente listarPorDni(@PathVariable(name = "id") Long id) {
		return clienteServiceImpl.getById(id);
	}

	// Para crear un cliente se necesita crear primero una cuenta
	// Se le pasa el objeto cuenta por body
	// Add Cliente
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@PostMapping("/clientes")
	public Cliente addNewCliente(@RequestBody CuentaCliente cuentaCliente) {
		
		System.out.println("----------!!!!!!!!!!!!!!!!!!!!--------");
		System.out.println(cuentaCliente.toString());
		System.out.println("----------!!!!!!!!!!!!!!!!!!!!--------");
		
		Cuenta cuenta = new Cuenta();
		cuenta.setUsername(cuentaCliente.getUsername());
		cuenta.setPassword(cuentaCliente.getPassword());
		cuenta.setEmail(cuentaCliente.getEmail());
		cuenta.setRole("ROLE_CLIENTE");
		
		// Crear primero la cuenta a la que está relacionada
		cuentaController.salvarCuenta(cuenta);
		
		// Crear cliente
		Cliente cliente = new Cliente();
		cliente.setNombre(cuentaCliente.getUsername());
		cliente.setApellido(cuentaCliente.getApellido());
		cliente.setDni(cuentaCliente.getDni());
		cliente.setCuenta(cuenta);
		
		return clienteServiceImpl.addNewCliente(cliente);
	}
	
	// Para crear un cliente se necesita crear primero una cuenta
	// Se le pasa el objeto cuenta por body
	// Add Cliente
	@PostMapping("/clientes/guest")
	public Cliente addNewClienteGuest(@RequestBody CuentaCliente cuentaCliente) {
		
		System.out.println("----------!!!!!!!!!!!!!!!!!!!!--------");
		System.out.println(cuentaCliente.toString());
		System.out.println("este??");
		System.out.println("----------!!!!!!!!!!!!!!!!!!!!--------");
		
		Cuenta cuenta = new Cuenta();
		cuenta.setUsername(cuentaCliente.getUsername());
		cuenta.setPassword(cuentaCliente.getPassword());
		cuenta.setEmail(cuentaCliente.getEmail());
		cuenta.setRole("ROLE_CLIENTE");
		
		// Crear primero la cuenta a la que está relacionada
		cuentaController.salvarCuenta(cuenta);
		
		// Crear cliente
		Cliente cliente = new Cliente();
		cliente.setNombre(cuentaCliente.getUsername());
		cliente.setCuenta(cuenta);
		
		return clienteServiceImpl.addNewCliente(cliente);
	}

	// Update Cliente
	@PutMapping("/clientes/{id}")
	public Cliente updateCliente(@PathVariable(name = "id") Long id, @RequestBody Cliente cliente) {

		Cliente cliente_seleccionada = new Cliente();
		Cliente cliente_actualizada = new Cliente();
		
		System.out.println("CLiente: ---------");
		System.out.println(cliente.toString());

		cliente_seleccionada = clienteServiceImpl.getById(id);

		if(cliente.getNombre() != null) {
			cliente_seleccionada.setNombre(cliente.getNombre());			
		}
		if(cliente.getApellido() != null) {
			cliente_seleccionada.setApellido(cliente.getApellido());			
		}
		if(cliente.getDni() != null) {
			cliente_seleccionada.setDni(cliente.getDni());			
		}
		if(cliente.getCuenta() != null) {
			cliente_seleccionada.setCuenta(cliente.getCuenta());			
		}

		cliente_actualizada = clienteServiceImpl.updateCliente(cliente_seleccionada);
		return cliente_actualizada;
	}

	// Delete cliente
	@DeleteMapping("/clientes/{id}")
	public void deleteCliente(@PathVariable(name = "id") Long id) {
		clienteServiceImpl.deleteCliente(id);
	}

}
