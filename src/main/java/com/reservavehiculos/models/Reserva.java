package com.reservavehiculos.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "reservas", schema = "public")
public class Reserva {

	@Id
	@Column(name = "id_reserva")
	@Basic(optional = false)
	private int idReserva;

	@JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor")
	@ManyToOne(optional = false)
	@JsonManagedReference
	private Conductor idConductor;

	@JoinColumn(name = "placa_vehiculo", referencedColumnName = "placa_vehiculo")
	@ManyToOne(optional = false)
	@JsonManagedReference
	private Vehiculo placaVehiculo;

	@Basic(optional = false)
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Reserva() {
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Conductor getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Conductor idConductor) {
		this.idConductor = idConductor;
	}

	public Vehiculo getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(Vehiculo placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setFecha(String fecha) {
		try {
			this.fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idConductor=" + idConductor.getIdConductor() + ", placaVehiculo="
				+ placaVehiculo.getPlacaVehiculo() + ", fecha=" + fecha + "]";
	}

}
