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
import com.reservavehiculos.models.Vehiculo;
import com.reservavehiculos.services.api.EntityServiceAPI;

@Controller
@RequestMapping(value = "/vehiculo")
public class VehiculoController {

	@Autowired
	private EntityServiceAPI<Vehiculo, String> vehiculoServiceAPI;

	@RequestMapping(value = "")
	public String show_vehiculos() {
		return "vehiculo/show_vehiculos";
	}

	/* WEB SERVICE */

	@PostMapping(value = "/save")
	public ResponseEntity<APIResponse> save(@RequestParam Map<String, Object> params) {
		Vehiculo vehiculo = new Vehiculo();
		if (params.get("placa_vehiculo") != null && !StringUtils.isEmpty(params.get("placa_vehiculo").toString())) {
			vehiculo.setPlacaVehiculo(params.get("placa_vehiculo").toString());
		}
		vehiculo.setMarca(params.get("marca").toString());
		vehiculo.setModelo(params.get("modelo").toString());
		vehiculo.setColor(params.get("color").toString());
		vehiculoServiceAPI.save(vehiculo);
		return new ResponseEntity<>(new APIResponse("Se guardó el vehiculo", "success", HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(value = "/showAll")
	public ResponseEntity<List<Vehiculo>> getAll() {
		return new ResponseEntity<>(vehiculoServiceAPI.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/showByPlaca")
	public ResponseEntity<Vehiculo> getByPlaca(@RequestParam Map<String, Object> params) {
		return new ResponseEntity<>(vehiculoServiceAPI.getById(params.get("placa_vehiculo").toString()), HttpStatus.OK);
	}

	@GetMapping(value = "/delete")
	public ResponseEntity<APIResponse> delete(@RequestParam Map<String, Object> params) {
		vehiculoServiceAPI.delete(params.get("placa_vehiculo").toString());
		return new ResponseEntity<>(new APIResponse("Se elminó el vehiculo", "success", HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(value = "/exist")
	public ResponseEntity<Boolean> exist(@RequestParam Map<String, Object> params) {
		if (params.get("placa_vehiculo") != null) {
			return new ResponseEntity<>(vehiculoServiceAPI.isExistObject(params.get("placa_vehiculo").toString()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}

}
