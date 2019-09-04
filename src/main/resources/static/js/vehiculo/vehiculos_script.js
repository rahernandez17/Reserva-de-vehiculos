$(document).ready(function() {
	getAll();
});

function getAll() {
	$('#vehiculos tbody').empty();
	$.ajax({
		url : 'http://localhost:1017/reservas-app/vehiculo/showAll',
		method : 'GET'
	}).done(function(data) {
		console.log(data);
		for (var i = 0; i < data.length; i++) {
			$('#vehiculos > tbody').append(showVehiculosHTML(data[i]));
		}
	});
}

function showVehiculosHTML(vehiculo) {
	return '<tr>' + '<td class="placaVehiculo">' + vehiculo.placaVehiculo
			+ '</td>' + '<td class="marca">' + vehiculo.marca + '</td>'
			+ '<td class="modelo">' + vehiculo.modelo + '</td>'
			+ '<td class="color">' + vehiculo.color + '</td>'
			+ '<td><a class="btn btn-warning editar">Editar</a></td>'
			+ '<td><a class="btn btn-danger eliminar">Eliminar</a></td>'
			+ '</tr>';
}

$('#form-vehiculo').submit(function(event) {
	if (confirm("Seguro que desea realizar esta operacion?")) {
		sendData();
		event.preventDefault();
	}
});

function addVehiculoOpenModal() {
	$('#message').empty();
	$('#message').hide();
	$('#inputPlacaVehiculo').removeAttr('disabled');
	$('#vehiculoModal').modal('show');
}

function closeModal() {
	$('#vehiculoModal').modal('hide');
	$('#form-vehiculo')[0].reset();
}

function sendData() {
	var params = '?placa_vehiculo=' + $('#inputPlacaVehiculo').val() + '&marca='
			+ $('#inputMarca').val() + '&modelo='
			+ $('#inputModelo').val() + '&color=' + $('#inputColor').val();
	$.ajax({
		url : 'http://localhost:1017/reservas-app/vehiculo/save' + params,
		method : 'POST'
	}).done(function(data) {
		if (data.httpStatus == 'OK') {
			$('#message').addClass('alert alert-' + data.severity);
			$('#message').append('<p>' + data.message + '</p>');
			$('#message').show();
			closeModal();
			getAll();
		}
	});
}

$('#vehiculos tbody').on('click', 'tr > td > a.editar', function() {
	$('#message').empty();
	$('#message').hide();
	$('#inputPlacaVehiculo').attr('disabled', 'true');
	$(this).closest('tr').find('td').each(function() {
		var td = $(this);
		switch (td.attr('class')) {
		case 'placaVehiculo':
			$('#inputPlacaVehiculo').val(td.text());
			break;
		case 'marca':
			$('#inputMarca').val(td.text());
			break;
		case 'modelo':
			$('#inputModelo').val(td.text());
			break;
		case 'color':
			$('#inputColor').val(td.text());
			break;
		}
	});
	$('#vehiculoModal').modal('show');
});

$('#vehiculos tbody').on('click', 'tr > td > a.eliminar', function() {
	if (confirm("Seguro que desea eliminar el registro?")) {
		$(this).closest('tr').find('td').each(function() {
			var td = $(this);
			if (td.attr('class') == 'placaVehiculo') {
				$.ajax({
					url : 'http://localhost:1017/reservas-app/vehiculo/delete?placa_vehiculo='+td.text(),
					method : "GET"
				}).done(function(data) {
					if (data.httpStatus == 'OK') {
						getAll();
					}
				});
			}
		});
	}
});

