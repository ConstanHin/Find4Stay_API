package api.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column (name = "dni")
	private String dni;
	
	@OneToMany
	@JoinColumn(name="id_cliente")
	private List<Reserva> reserva;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id_cuenta", referencedColumnName = "id", unique=true, nullable = false)
	private Cuenta cuenta;
	

	/*
	 * Constructors
	 */
	
	public Cliente() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param cuenta
	 * @param reserva
	 */
	public Cliente(Long id, String nombre, String apellido, String dni, Cuenta cuenta, List<Reserva> reserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuenta = cuenta;
		this.reserva = reserva;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the cuenta
	 */
	@JsonIgnore
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "cuentas")
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	
	
	
	
}
