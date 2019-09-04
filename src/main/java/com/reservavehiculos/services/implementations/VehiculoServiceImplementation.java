package com.reservavehiculos.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservavehiculos.dao.api.VehiculoDaoAPI;
import com.reservavehiculos.models.Vehiculo;
import com.reservavehiculos.services.api.EntityServiceAPI;

@Service
public class VehiculoServiceImplementation implements EntityServiceAPI<Vehiculo, String> {

	private VehiculoDaoAPI vehiculoDaoAPI;

	@Autowired
	public VehiculoServiceImplementation(VehiculoDaoAPI vehiculoDaoAPI) {
		super();
		this.vehiculoDaoAPI = vehiculoDaoAPI;
	}

	@Override
	public void save(Vehiculo object) {
		vehiculoDaoAPI.save(object);
	}

	@Override
	public List<Vehiculo> getAll() {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculoDaoAPI.findAll().forEach((Vehiculo t) -> {
			vehiculos.add(t);
		});
		return vehiculos;
	}

	@Override
	public void delete(String idObject) {
		vehiculoDaoAPI.deleteById(idObject);
	}

	@Override
	public Vehiculo getById(String idObject) {
		return vehiculoDaoAPI.findById(idObject).get();
	}

	@Override
	public Boolean isExistObject(String idObject) {
		return vehiculoDaoAPI.existsById(idObject);
	}

}
