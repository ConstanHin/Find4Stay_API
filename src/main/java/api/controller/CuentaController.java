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

import api.dto.Cuenta;
import api.service.CuentaServiceImpl;



@RestController
@RequestMapping("/api")
public class CuentaController {
	
	@Autowired
	CuentaServiceImpl cuentaServiceImpl;
	
	/**
	 * Get All
	 */
	@GetMapping("/cuentas")
	public List<Cuenta> listarCcursos(){
		return cuentaServiceImpl.listarCuenta();
	}
	
	/**
	 * Crear nuevo
	 * @param cuenta
	 * @return
	 */
	@PostMapping("/cuentas")
	public Cuenta salvarCuenta(@RequestBody Cuenta cuenta) {
		
		return cuentaServiceImpl.guardarCuenta(cuenta);
	}
	
	/**
	 * Get by ID
	 * @param id
	 * @return
	 */
	@GetMapping("/cuentas/{id}")
	public Cuenta CuentaXID(@PathVariable(name="id") Long id) {
		
		Cuenta cuenta_xid= new Cuenta();
		
		cuenta_xid=cuentaServiceImpl.cuentasXID(id);
		
		//System.out.println("Cuenta XID: "+ Cuenta_xid);
		
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
		
		cuenta_seleccionado.setUsuario(cuenta.getUsuario());
		cuenta_seleccionado.setPassword(cuenta.getPassword());
		cuenta_seleccionado.setEmail(cuenta.getEmail());
		cuenta_seleccionado.setRol(cuenta.getRol());
		
		
		
		cuenta_actualizado = cuentaServiceImpl.actualizarCuenta(cuenta_seleccionado);
		
		//System.out.println("El Cuenta actualizado es: "+ Cuenta_actualizado);
		
		return cuenta_actualizado;
	}
	
	/**
	 * Delete by ID
	 * @param id
	 */
	@DeleteMapping("/cuentas/{id}")
	public void eleiminarCuenta(@PathVariable(name="id")Long id) {
		cuentaServiceImpl.eliminarCuenta(id);
	}
	

}


