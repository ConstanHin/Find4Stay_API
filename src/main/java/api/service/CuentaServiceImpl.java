package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import api.dao.ICuentaDAO;
import api.dto.Cuenta;


@Service
public class CuentaServiceImpl implements ICuentaService, UserDetailsService{
	
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


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Cuenta cuenta = iCuentaDAO.findByUsername(username);
		if (cuenta == null) {
			throw new UsernameNotFoundException(username);
		}
//		System.out.println(cuenta.getUsername() + cuenta.getPassword() + cuenta.getAuthorities());
		return new User(cuenta.getUsername(), cuenta.getPassword(), cuenta.getAuthorities());
	}

	@Override
	public Cuenta getCuentaByUsername(String username) {
		return iCuentaDAO.findByUsername(username);
	}


}
