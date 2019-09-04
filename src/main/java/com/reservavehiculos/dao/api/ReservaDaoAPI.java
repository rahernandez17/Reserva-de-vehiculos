package com.reservavehiculos.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.reservavehiculos.models.Reserva;

public interface ReservaDaoAPI extends CrudRepository<Reserva, Integer> {

}
