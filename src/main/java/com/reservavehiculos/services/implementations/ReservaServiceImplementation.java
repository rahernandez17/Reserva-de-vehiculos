package com.reservavehiculos.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservavehiculos.dao.api.ReservaDaoAPI;
import com.reservavehiculos.models.Reserva;
import com.reservavehiculos.services.api.EntityServiceAPI;

@Service
public class ReservaServiceImplementation implements EntityServiceAPI<Reserva, Integer> {

	private ReservaDaoAPI reservaDaoAPI;

	@Autowired
	public ReservaServiceImplementation(ReservaDaoAPI reservaDaoAPI) {
		super();
		this.reservaDaoAPI = reservaDaoAPI;
	}

	@Override
	public void save(Reserva object) {
		reservaDaoAPI.save(object);
	}

	@Override
	public List<Reserva> getAll() {
		List<Reserva> reservas = new ArrayList<>();
		reservaDaoAPI.findAll().forEach((Reserva t) -> reservas.add(t));
		return reservas;
	}

	@Override
	public void delete(Integer idObject) {
		reservaDaoAPI.deleteById(idObject);
	}

	@Override
	public Reserva getById(Integer idObject) {
		return reservaDaoAPI.findById(idObject).get();
	}

	@Override
	public Boolean isExistObject(Integer idObject) {
		return reservaDaoAPI.existsById(idObject);
	}

}
