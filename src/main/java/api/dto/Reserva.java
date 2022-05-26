package api.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {

	//Atributos de la tabla intermedia Reservas
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "fecha_entrada")
	private Date fecha_entrada;
	@Column(name = "fecha_salida")
	private Date fecha_salida;
	@Column(name = "importe_reserva")
	private Integer importe_reserva;
	
	@ManyToOne
	@JoinColumn(name= "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name= "id_hotel")
	private Hotel hotel;
	
	//Constructor Default
	public Reserva() {
		
	}

	
	//Constructor
	public Reserva(Long id, String codigo, Date fecha_entrada, Date fecha_salida, Integer importe_reserva) {
		this.id = id;
		this.codigo = codigo;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.importe_reserva = importe_reserva;
	}

	
	//Getters & Setters
	
	public Long getId_reservas() {
		return id;
	}


	public void setId_reservas(Long id_reservas) {
		this.id = id_reservas;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Date getFecha_entrada() {
		return fecha_entrada;
	}


	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}


	public Date getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	public Integer getImporte_reserva() {
		return importe_reserva;
	}


	public void setImporte_reserva(Integer importe_reserva) {
		this.importe_reserva = importe_reserva;
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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}


	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}


	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	@Override
	public String toString() {
		return "Reservas [id=" + id + ", codigo=" + codigo + ", fecha_entrada=" + fecha_entrada
				+ ", fecha_salida=" + fecha_salida + ", importe_reserva=" + importe_reserva + "]";
	}
	
}
