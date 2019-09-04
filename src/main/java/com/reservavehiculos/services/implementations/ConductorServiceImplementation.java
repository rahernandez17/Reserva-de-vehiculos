package com.reservavehiculos.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservavehiculos.dao.api.ConductorDaoAPI;
import com.reservavehiculos.models.Conductor;
import com.reservavehiculos.services.api.EntityServiceAPI;

/*Si salen métodos diferentes, crear una interfaz llamada ConductorServiceAPI
 * que extienda de EntityServiceAPI e implementarla acá*/

@Service
public class ConductorServiceImplementation implements EntityServiceAPI<Conductor, Integer> {

	private ConductorDaoAPI conductorDaoAPI;

	@Autowired
	public ConductorServiceImplementation(ConductorDaoAPI conductorDaoAPI) {
		super();
		this.conductorDaoAPI = conductorDaoAPI;
	}

	@Override
	public void save(Conductor object) {
		conductorDaoAPI.save(object);
	}

	@Override
	public List<Conductor> getAll() {
		List<Conductor> conductores = new ArrayList<>();
		conductorDaoAPI.findAll().forEach((Conductor t) -> {
			conductores.add(t);
		});
		return conductores;
	}

	@Override
	public void delete(Integer idObject) {
		conductorDaoAPI.deleteById(idObject);
	}

	@Override
	public Conductor getById(Integer idObject) {
		return conductorDaoAPI.findById(idObject).get();
	}

	@Override
	public Boolean isExistObject(Integer idObject) {
		return conductorDaoAPI.existsById(idObject);
	}

}
