package api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import api.dto.Empresa;
import api.dto.Reserva;

public class HotelModel {

	private String nombre;
	private String categoria;
	private String poblacion;
	private String ubicacion;
	private double precio;
	private double id_empresa;
	private Empresa empresa;

	// Constructor
	public HotelModel() {
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
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the id_empresa
	 */
	public double getId_empresa() {
		return id_empresa;
	}

	/**
	 * @param id_empresa the id_empresa to set
	 */
	public void setId_empresa(double id_empresa) {
		this.id_empresa = id_empresa;
	}

	/**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "HotelModel [nombre=" + nombre + ", categoria=" + categoria + ", poblacion=" + poblacion + ", ubicacion="
				+ ubicacion + ", precio=" + precio + ", id_empresa=" + id_empresa + ", empresa=" + empresa + "]";
	}

}
