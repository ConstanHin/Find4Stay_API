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
	
	@GetMapping("/cuenta")
	public List<Cuenta> listarCcursos(){
		return cuentaServiceImpl.listarCuenta();
	}
	
	
	@PostMapping("/cuenta")
	public Cuenta salvarCuenta(@RequestBody Cuenta cuentas) {
		
		return cuentaServiceImpl.guardarCuenta(cuentas);
	}
	
	
	@GetMapping("/cuenta/{id}")
	public Cuenta CuentaXID(@PathVariable(name="id") Long id) {
		
		Cuenta cuenta_xid= new Cuenta();
		
		cuenta_xid=cuentaServiceImpl.cuentasXID(id);
		
		//System.out.println("Cuenta XID: "+ Cuenta_xid);
		
		return cuenta_xid;
	}
	
	@PutMapping("/cuenta/{id}")
	public Cuenta actualizarCuenta(@PathVariable(name="id")Long id,@RequestBody Cuenta cuenta) {
		
		Cuenta cuenta_seleccionado= new Cuenta();
		Cuenta cuenta_actualizado= new Cuenta();
		
		cuenta_seleccionado= cuentaServiceImpl.cuentasXID(id);
		
		cuenta_seleccionado.setUsuario(cuenta.getUsuario());
		cuenta_seleccionado.setPassword(cuenta.getPassword());
		cuenta_seleccionado.setEmail(cuenta.getEmail());
		cuenta_seleccionado.setTipo_rol(cuenta.getTipo_rol());
		
		
		
		cuenta_actualizado = cuentaServiceImpl.actualizarCuenta(cuenta_seleccionado);
		
		//System.out.println("El Cuenta actualizado es: "+ Cuenta_actualizado);
		
		return cuenta_actualizado;
	}
	
	@DeleteMapping("/cuenta/{id}")
	public void eleiminarCuenta(@PathVariable(name="id")Long id) {
		cuentaServiceImpl.eliminarCuenta(id);
	}
	

}


