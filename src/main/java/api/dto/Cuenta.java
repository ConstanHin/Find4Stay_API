package api.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Aida Queralt
 *
 */

@Entity
@Table(name = "cuentas")
public class Cuenta {

	// Atributos de la tabla cuenta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "usuario", unique = true, nullable = false)
	private String usuario;

	@Column(name = "password", nullable = false)
	private String password;

//	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "role", nullable = false)
	private String role;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_cuenta")
	private List<Cliente> cliente;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_cuenta")
	private List<Empresa> empresa;

	// Contructor por defecto
	public Cuenta() {

	}

	// Construcotr con todos los atributos

	/**
	 * @param id
	 * @param usuario
	 * @param password
	 * @param email
	 * @param role
	 * @param cliente
	 * @param empresas
	 */
	public Cuenta(Long id, String usuario, String password, String email, String role, List<Cliente> clientes,
			List<Empresa> empresa) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.role = role;
		this.cliente = clientes;
		this.empresa = empresa;
	}

	// Getters & Setters
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

	/**
	 * @return the role
	 */
	public String getRol() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRol(String role) {
		this.role = role;
	}

	/**
	 * @return the cliente
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public List<Cliente> getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	public List<Empresa> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(List<Empresa> empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", usuario=" + usuario + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}

}
