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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column (name = "codigo_empresa")
	private String codigo_empresa;
	
	@Column (name = "nombre", nullable = false)
	private String nombre;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_empresa")
	private List<Hotel> hotel;
	
	@ManyToOne
	@JoinColumn(name = "id_cuenta", unique=true, nullable=false)
	private Cuenta cuenta;
	
	
	
	//Constructor Default
	public Empresa() {
		
	}
	
	//Constructor
	public Empresa(Long id, String codigo_empresa, String nombre, Cuenta cuenta, List<Hotel> hotel) {
		this.id = id;
		this.codigo_empresa = codigo_empresa;
		this.nombre = nombre;
		this.cuenta = cuenta;
		this.hotel = hotel;
	}

	
	//Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo_empresa() {
		return codigo_empresa;
	}

	public void setCodigo_empresa(String codigo_empresa) {
		this.codigo_empresa = codigo_empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
	public List<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		this.hotel = hotel;
	}

	
	//To String
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", codigo_empresa=" + codigo_empresa + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	
}
