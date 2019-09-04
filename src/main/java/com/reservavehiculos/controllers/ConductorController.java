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
import com.reservavehiculos.services.api.EntityServiceAPI;

@Controller
@RequestMapping(value = "/conductor")
public class ConductorController {

	@Autowired
	private EntityServiceAPI<Conductor, Integer> conductorServiceAPI;

	@RequestMapping(value = "")
	public String show_conductores() {
		return "conductor/show_conductores";
	}

	/* WEB SERVICE */

	@PostMapping(value = "/save")
	public ResponseEntity<APIResponse> save(@RequestParam Map<String, Object> params) {
		Conductor conductor = new Conductor();
		if (params.get("id_conductor") != null && !StringUtils.isEmpty(params.get("id_conductor").toString())) {
			conductor.setIdConductor(Integer.parseInt(params.get("id_conductor").toString()));
		}
		conductor.setNombre(params.get("nombre").toString());
		conductor.setCalificacion(Integer.parseInt(params.get("calificacion").toString()));
		conductor.setEdad(Integer.parseInt(params.get("edad").toString()));
		conductorServiceAPI.save(conductor);
		return new ResponseEntity<>(new APIResponse("Se guardó el cliente", "success", HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<List<Conductor>> getAll() {
		return new ResponseEntity<>(conductorServiceAPI.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/showById")
	public ResponseEntity<Conductor> getByPlaca(@RequestParam Map<String, Object> params) {
		return new ResponseEntity<>(
				conductorServiceAPI.getById(Integer.parseInt(params.get("id_conductor").toString())), HttpStatus.OK);
	}

	@GetMapping(value = "/delete")
	public ResponseEntity<APIResponse> delete(@RequestParam Map<String, Object> params) {
		conductorServiceAPI.delete(Integer.parseInt(params.get("id_conductor").toString()));
		return new ResponseEntity<>(new APIResponse("Se eliminó el cliente", "success", HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(value = "/exist")
	public ResponseEntity<Boolean> exist(@RequestParam Map<String, Object> params) {
		if (params.get("id_conductor") != null) {
			return new ResponseEntity<>(
					conductorServiceAPI.isExistObject(Integer.parseInt(params.get("id_conductor").toString())),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}

}
