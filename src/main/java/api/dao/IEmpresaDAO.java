package api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import api.dto.Empresa;

public interface IEmpresaDAO extends JpaRepository<Empresa, Long>{

}
