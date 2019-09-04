package com.reservavehiculos.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservavehiculos.commons.APIResponse;
import com.reservavehiculos.models.Conductor;
import com.reservavehiculos.models.Reserva;
import com.reservavehiculos.models.Vehiculo;
import com.reservavehiculos.services.api.EntityServiceAPI;

@Controller
@RequestMapping(value = "/reserva")
public class ReservaController {

	@Autowired
	private EntityServiceAPI<Reserva, Integer> reservaServiceApi;

	@RequestMapping(value = "")
	public String show_reservas() {
		return "reserva/show_reservas";
	}

	/* WEB SERVICE */

	@PostMapping(value = "/save")
	public ResponseEntity<APIResponse> save(@RequestParam Map<String, Object> params) {
		Reserva reserva = new Reserva();
		if (params.get("id_reserva").toString() != null && !StringUtils.isEmpty(params.get("id_reserva").toString())) {
			reserva.setIdReserva(Integer.parseInt(params.get("id_reserva").toString()));
		}
		reserva.setIdConductor(new Conductor(Integer.parseInt(params.get("id_conductor").toString())));
		reserva.setPlacaVehiculo(new Vehiculo(params.get("placa_vehiculo").toString()));
		reserva.setFecha(params.get("fecha").toString().replace("\"", ""));
		reservaServiceApi.save(reserva);
		return new ResponseEntity<>(new APIResponse("Se guardó el vehiculo", "success", HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<List<Reserva>> getAll() {
		return new ResponseEntity<>(reservaServiceApi.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/showById")
	public ResponseEntity<Reserva> getById(@RequestParam Map<String, Object> params) {
		return new ResponseEntity<>(reservaServiceApi.getById(Integer.parseInt(params.get("id_reserva").toString())),
				HttpStatus.OK);
	}

	@GetMapping(value = "/delete")
	public ResponseEntity<APIResponse> delete(@RequestParam Map<String, Object> params) {
		reservaServiceApi.delete(Integer.parseInt(params.get("id_reserva").toString()));
		return new ResponseEntity<>(new APIResponse("Se elminó el vehiculo", "success", HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(value = "/exist")
	public ResponseEntity<Boolean> exist(@RequestParam Map<String, Object> params) {
		if (params.get("id_reserva") != null) {
			return new ResponseEntity<>(
					reservaServiceApi.isExistObject(Integer.parseInt(params.get("id_reserva").toString())),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}

}
