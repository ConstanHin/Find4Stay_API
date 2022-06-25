package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import api.dto.Empresa;
import api.dto.Reserva;
import api.models.CuentaCliente;
import api.models.CuentaEmpresa;
import api.service.CuentaServiceImpl;
import api.service.EmpresaServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpresaController {

	@Autowired
	EmpresaServiceImpl empresaServiceImpl;
	
	@Autowired
	CuentaController cuentaController;
	
	@Autowired
	CuentaServiceImpl cuentaServiceImpl;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	
	// Constructor
	public EmpresaController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/empresas")
	public List<Empresa> listarEmpresa(){
//		Recogiendo los principal authenticado
//		SecurityContext context = SecurityContextHolder.getContext();
//		System.out.println(context.getAuthentication().getName());

		return empresaServiceImpl.listarEmpresa();
	}
	
	@PostMapping("/empresas")
	public Empresa guardarEmpresa(@RequestBody CuentaEmpresa cuentaEmpresa){
		
		Cuenta cuenta = new Cuenta();
		cuenta.setUsername(cuentaEmpresa.getUsername());
		cuenta.setPassword(cuentaEmpresa.getPassword());
		cuenta.setEmail(cuentaEmpresa.getEmail());
		cuenta.setRole("ROLE_EMPRESA");
		
		// Crear primero la cuenta a la que está relacionada
		cuentaController.salvarCuenta(cuenta);
		
		// Crear empresa
		Empresa empresa = new Empresa();
		empresa.setNombre(cuentaEmpresa.getNombre());
		empresa.setCodigo_empresa(cuentaEmpresa.getCodigo_empresa());
		empresa.setCuenta(cuenta);
		
		return empresaServiceImpl.guardarEmpresa(empresa);
	}
	
	// Anadir empresa desde registro sin restriccion
	@PostMapping("/empresas/guest")
	public Empresa addNewEmpresaGuest(@RequestBody CuentaEmpresa cuentaEmpresa) {
		
		System.out.println("----------!!!!!!!!!!!!!!!!!!!!--------\n");
		System.out.println("cuentaem: " + cuentaEmpresa.toString());
		System.out.println("cuentaem2: " +cuentaEmpresa.getPassword());
		System.out.println("----------!!!!!!!!!!!!!!!!!!!!--------");
		
		Cuenta cuenta = new Cuenta();
		cuenta.setUsername(cuentaEmpresa.getUsername());
		cuenta.setPassword(cuentaEmpresa.getPassword());
		System.out.println(cuenta.getPassword());
		cuenta.setEmail(cuentaEmpresa.getEmail());
		cuenta.setRole("ROLE_EMPRESA");
		
		// Crear primero la cuenta a la que está relacionada
		cuentaController.salvarCuenta(cuenta);
		
		// Crear empresa
		Empresa empresa= new Empresa();
		empresa.setNombre(cuentaEmpresa.getUsername());
		empresa.setCuenta(cuenta);
		
		return empresaServiceImpl.guardarEmpresa(empresa);
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/empresas/{id}")
	public Empresa Empresa_ID(@PathVariable(name="id") Long id) {
		
		Empresa empresa_id= new Empresa();
		
		empresa_id=empresaServiceImpl.empresaID(id);
		
		return empresa_id;
	}
	
	@PutMapping("/empresas/{id}")
	public Empresa actualizarEmpresa(@PathVariable(name="id")Long id,@RequestBody Empresa empresas) {
		
		Empresa empresa_seleccionado= new Empresa();
		Empresa empresa_actualizado= new Empresa(); 
		
		empresa_seleccionado= empresaServiceImpl.empresaID(id);
		
		empresa_seleccionado.setCodigo_empresa(empresas.getCodigo_empresa());
		empresa_seleccionado.setNombre(empresas.getNombre());
		empresa_seleccionado.setCuenta(empresas.getCuenta());
		
		empresa_actualizado = empresaServiceImpl.actualizarEmpresa(empresa_seleccionado);
		
		return empresa_actualizado;
	}
	
	@DeleteMapping("/empresas/{id}")
	public void eliminarEmpresas(@PathVariable(name="id")Long id) {
		empresaServiceImpl.eliminarEmpresa(id);
	}
	
	/**
	 * Método que devuelve los hoteles de la empresa autentificada
	 */
	
	/**
	 * Devuelve los datos de la empresa authenticada
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('ROLE_EMPRESA')")
	@GetMapping("/empresas/auth")
	public Empresa getReservasOfClienteAuth() {

		// Obtenemos authenticated
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// Obtenemos la cuenta a partir del nombre de la cuenta authenticated
		Cuenta cuenta = cuentaServiceImpl.getCuentaByUsername(authentication.getName());

		// Obtener id empresa
		Empresa empresa = cuenta.getEmpresa();


		return empresa;
	}
	
}
