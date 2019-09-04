package com.reservavehiculos.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.reservavehiculos.models.Vehiculo;

public interface VehiculoDaoAPI extends CrudRepository<Vehiculo, String> {

}
