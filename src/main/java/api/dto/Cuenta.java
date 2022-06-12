package api.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import api.enumerables.RolesEnum;

/**
 * @author Aida Queralt <3, Constantin Vlad, Gerard Vinuela, Gerard Sanchez
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "cuentas")
public class Cuenta implements UserDetails {

	// Atributos de la tabla cuenta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

//	@Email
	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "role")
	private String role;

//	@OneToMany(cascade = CascadeType.REMOVE)
	@OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private Cliente cliente;

//	@OneToMany(cascade = CascadeType.REMOVE)
	@OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Empresa empresa;

	// Contructor por defecto
	public Cuenta() {

	}

	// Construcotr con todos los atributos

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param role
	 * @param cliente
	 * @param empresas
	 */
	public Cuenta(Long id, String username, String password, String email, String role, 
//			Empresa empresa,
			Cliente cliente
			) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.cliente = cliente;
//		this.empresa = empresa;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority(role));

		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 * @throws Exception 
	 */
	public void setRole(String role) {
		
			RolesEnum rolesEnum = RolesEnum.getRoleEnum(role);
			this.role = RolesEnum.getRole(rolesEnum);
	}
	
	/**
	 * @return the cliente
	 */
//	@JsonIgnore
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

//	@JsonIgnore
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + ", cliente=" + cliente + ", empresa=" + empresa + "]";
	}	

}
