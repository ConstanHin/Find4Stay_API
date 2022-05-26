package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.ICuentaDAO;
import api.dto.Cuenta;


@Service
public class CuentaServiceImpl implements ICuentaService{
	
	@Autowired
	ICuentaDAO iCuentaDAO;

	@Override
	public List<Cuenta> listarCuenta() {
		return iCuentaDAO.findAll();
	}

	@Override
	public Cuenta guardarCuenta(Cuenta cuentas) {
		return iCuentaDAO.save(cuentas);
	}

	@Override
	public Cuenta cuentasXID(Long id) {
		return iCuentaDAO.findById(id).get();
	}

	@Override
	public Cuenta actualizarCuenta(Cuenta cuentas) {
		return iCuentaDAO.save(cuentas);
	}

	@Override
	public void eliminarCuenta(Long id) {
		iCuentaDAO.deleteById(id);
	}


}
