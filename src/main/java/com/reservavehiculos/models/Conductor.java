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
@Table(name = "conductores", schema = "public")
public class Conductor {

	@Id
	@Column(name = "id_conductor")
	@Basic(optional = false)
	private int idConductor;

	@Column
	@Basic(optional = false)
	private String nombre;

	@Column
	@Basic(optional = false)
	private int calificacion;

	@Column
	@Basic(optional = false)
	private int edad;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idConductor")
	@JsonBackReference
	private List<Reserva> reservasList;

	public Conductor() {
	}

	public Conductor(int idConductor) {
		super();
		this.idConductor = idConductor;
	}

	public Conductor(int idConductor, String nombre, int calificacion, int edad) {
		super();
		this.idConductor = idConductor;
		this.nombre = nombre;
		this.calificacion = calificacion;
		this.edad = edad;
	}

	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Reserva> getReservasList() {
		return reservasList;
	}

	public void setReservasList(List<Reserva> reservasList) {
		this.reservasList = reservasList;
	}

	@Override
	public String toString() {
		return "Conductor [idConductor=" + idConductor + ", nombre=" + nombre + ", calificacion=" + calificacion
				+ ", edad=" + edad + "]";
	}

}
