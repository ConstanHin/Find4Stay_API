package api.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import api.dto.Cliente;
import api.dto.Cuenta;
import api.dto.Empresa;
import api.dto.Reserva;

public class CuentaEmpresa {
	
	private Long id;
	private String username;
	private String password;
	private String email;
	private String role;
	private String nombre;
	private String codigo_empresa;
	
	public CuentaEmpresa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the codigo_empresa
	 */
	public String getCodigo_empresa() {
		return codigo_empresa;
	}

	/**
	 * @param codigo_empresa the codigo_empresa to set
	 */
	public void setCodigo_empresa(String codigo_empresa) {
		this.codigo_empresa = codigo_empresa;
	}

	@Override
	public String toString() {
		return "CuentaEmpresa [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", nombre=" + nombre + ", codigo_empresa=" + codigo_empresa + "]";
	}
	
	

}
