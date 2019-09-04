package com.reservavehiculos.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.reservavehiculos.models.Conductor;

public interface ConductorDaoAPI extends CrudRepository<Conductor, Integer> {

}