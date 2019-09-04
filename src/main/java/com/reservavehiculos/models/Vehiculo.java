package com.reservavehiculos.models;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "vehiculos", schema = "public")
public class Vehiculo {

	@Id
	@Column(name = "placa_vehiculo")
	@Basic(optional = false)
	private String placaVehiculo;

	@Column
	@Basic(optional = false)
	private String marca;

	@Column
	@Basic(optional = false)
	private String modelo;

	@Column
	@Basic(optional = false)
	private String color;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "placaVehiculo")
	@JsonBackReference
	private List<Reserva> reservasList;

	public Vehiculo() {
	}

	public Vehiculo(String placaVehiculo) {
		super();
		this.placaVehiculo = placaVehiculo;
	}

	public Vehiculo(String placaVehiculo, String marca, String modelo, String color) {
		super();
		this.placaVehiculo = placaVehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Reserva> getReservasList() {
		return reservasList;
	}

	public void setReservasList(List<Reserva> reservasList) {
		this.reservasList = reservasList;
	}

	@Override
	public String toString() {
		return "Vehiculo [placaVehiculo=" + placaVehiculo + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + "]";
	}

}
