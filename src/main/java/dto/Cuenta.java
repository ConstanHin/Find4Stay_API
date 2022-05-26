package dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Aida Queralt
 *
 */

@Entity
@Table(name = "cuentas")
public class Cuenta {
	
	//Atributos de la tabla cuenta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "usuario")
	private String usuario;
	
	@Column (name = "password")
	private String password;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "tipo_rol")
	private String tipo_rol;
	
	@OneToMany
	@JoinColumn (name = "id_cliente")
	private List<Cliente> clientes;
	
	
	@OneToMany
	@JoinColumn (name = "id_empresa")
	private List<Empresa> empresas;
	
	
	//Contructor por defecto
	public Cuenta() {
		
	}
	
	


	// Construcotr con todos los atributos
	
	public Cuenta(Long id, String usuario, String password, String email, String tipo_rol, List<Cliente> clientes,
			List<Empresa> empresas) {
		
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.tipo_rol = tipo_rol;
		this.clientes = clientes;
		this.empresas = empresas;
	}




	//Getters & Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTipo_rol() {
		return tipo_rol;
	}



	public void setTipo_rol(String tipo_rol) {
		this.tipo_rol = tipo_rol;
	}

	
	

	public List<Cliente> getClientes() {
		return clientes;
	}




	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}




	public List<Empresa> getEmpresas() {
		return empresas;
	}




	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}




	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", usuario=" + usuario + ", password=" + password + ", email=" + email
				+ ", tipo_rol=" + tipo_rol + "]";
	}
	
	
	
	
	
	
	
	

}
