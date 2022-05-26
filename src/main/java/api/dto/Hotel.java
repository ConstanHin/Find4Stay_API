package api.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="hoteles")
public class Hotel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre_hotel")
	private char nombre;
	@Column(name = "categoria")
	private char categoria;
	@Column(name = "poblacion")
	private char poblacion;
	@Column(name = "ubicacion_geografica")
	private char ubicacion;
	@Column(name = "precio_noche")
	private double precio;
	
	
//	@OneToMany
//	@JoinColumn(name="id_reserva")
//	private List<Reserva> reserva;
//	
//	@ManyToOne 
//	@JoinColumn(name = "id_empresa")
//	private Empresa empresa;
	
	public Hotel(){
		
	}
	public Hotel(char nombre, char categoria, char poblacion, char ubicacion, double precio){
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getNombre() {
		return nombre;
	}
	public void setNombre(char nombre) {
		this.nombre = nombre;
	}
	public char getCategoria() {
		return categoria;
	}
	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}
	public char getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(char poblacion) {
		this.poblacion = poblacion;
	}
	public char getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(char ubicacion) {
		this.ubicacion = ubicacion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserva")
//	public List<Reserva> getReserva() {
//		return reserva;
//	}
//	public void setReserva(List<Reserva> reserva) {
//		this.reserva = reserva;
//	}
//	public Empresa getId_empresa() {
//		return id_empresa;
//	}
//	public void setId_empresa(Empresa id_empresa) {
//		this.id_empresa = id_empresa;
//	}
//	
	
	
}
