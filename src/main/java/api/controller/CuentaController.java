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

import api.dto.Cuenta;
import api.service.CuentaServiceImpl;

@RestController
@RequestMapping("/api")
public class CuentaController {
	
	@Autowired
	CuentaServiceImpl cuentaServiceImpl;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	
	/**
	 * @param cuentaServiceImpl
	 * @param bCryptPasswordEncoder
	 */
	public CuentaController(CuentaServiceImpl cuentaServiceImpl, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.cuentaServiceImpl = cuentaServiceImpl;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/**
	 * Get All
	 */
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/cuentas")
	public List<Cuenta> listarCuentas(){
		return cuentaServiceImpl.listarCuenta();
	}
	
	/**
	 * Crear nuevo
	 * @param cuenta
	 * @return
	 */
	@PostMapping("/cuentas")
	public Cuenta salvarCuenta(@RequestBody Cuenta cuenta) {
		cuenta.setPassword(bCryptPasswordEncoder.encode(cuenta.getPassword()));
		cuentaServiceImpl.guardarCuenta(cuenta);
		return cuenta;
	}
	
	/**
	 * Get by ID
	 * @param id
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/cuentas/{id}")
	public Cuenta CuentaXID(@PathVariable(name="id") Long id) {
		
		Cuenta cuenta_xid= new Cuenta();
		
		cuenta_xid=cuentaServiceImpl.cuentasXID(id);
		
		return cuenta_xid;
	}
	
	/**
	 * Update by id
	 * @param id
	 * @param cuenta
	 * @return
	 */
	@PutMapping("/cuentas/{id}")
	public Cuenta actualizarCuenta(@PathVariable(name="id")Long id,@RequestBody Cuenta cuenta) {
		
		Cuenta cuenta_seleccionado= new Cuenta();
		Cuenta cuenta_actualizado= new Cuenta();
		
		cuenta_seleccionado= cuentaServiceImpl.cuentasXID(id);
		
		cuenta_seleccionado.setUsername(cuenta.getUsername());
		cuenta_seleccionado.setPassword(cuenta.getPassword());
		cuenta_seleccionado.setEmail(cuenta.getEmail());
		cuenta_seleccionado.setRole(cuenta.getRole());
		
		
		
		cuenta_actualizado = cuentaServiceImpl.actualizarCuenta(cuenta_seleccionado);
		
		//System.out.println("El Cuenta actualizado es: "+ Cuenta_actualizado);
		
		return cuenta_actualizado;
	}
	
	/**
	 * Delete by ID
	 * @param id
	 */
	@DeleteMapping("/cuentas/{id}")
	public void eliminarCuenta(@PathVariable(name="id")Long id) {
		cuentaServiceImpl.eliminarCuenta(id);
	}
	

}


