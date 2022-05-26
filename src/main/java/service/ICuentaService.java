package service;

import java.util.List;

import dto.Cuenta;

public interface ICuentaService {

public List<Cuenta> listarCuenta(); //Listar All 
	
	public Cuenta guardarCuenta(Cuenta cuentas);	//Guarda un Cuenta CREATE
	
	public Cuenta cuentasXID(Long id); //Leer datos de un Cuenta READ
	
	public Cuenta actualizarCuenta(Cuenta cuentas); //Actualiza datos del cuentas UPDATE
	
	public void eliminarCuenta(Long id);// Elimina el cuentas DELETE

}
