package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.dao.IEmpresaDAO;
import api.dto.Empresa;

@Service
public class EmpresaServiceImpl implements IEmpresaService{

	@Autowired
	IEmpresaDAO iempresaDAO;

	@Override
	public List<Empresa> listarEmpresa() {
		
		return iempresaDAO.findAll();
	}

	@Override
	public Empresa guardarReservas(Empresa empresa) {
		
		return iempresaDAO.save(empresa);
	}

	@Override
	public Empresa empresaID(Long id) {
		
		return iempresaDAO.findById(id).get();
	}

	@Override
	public Empresa actualizarEmpresa(Empresa empresa) {
		
		return iempresaDAO.save(empresa);
	}

	@Override
	public void eliminarEmpresa(Long id) {
		iempresaDAO.deleteById(id);
		
	}
	
	
}
