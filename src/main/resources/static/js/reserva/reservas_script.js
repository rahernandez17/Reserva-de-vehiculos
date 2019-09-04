$(document).ready(function() {
	getAll();	
});

function getAll() {
	$('#reservas tbody').empty();
	$.ajax({
		url : 'http://localhost:1017/reservas-app/reserva/showAll',
		method : "GET"
	}).done(function(data) {
		for (var i = 0; i < data.length; i++) {
			$('#reservas > tbody').append(showReservasHTML(data[i]));
		}
	});
	putSelectConductores();
	putSelectVehiculos();
}

function showReservasHTML(reserva) {
	return '<tr>' +
	'<td class="idReserva">' + reserva.idReserva + '</td>' +
	'<td class="idConductor">' + reserva.idConductor.idConductor + '</td>' +
	'<td>' + reserva.idConductor.nombre + '</td>' +
	'<td class="placaVehiculo">' + reserva.placaVehiculo.placaVehiculo + '</td>' +
	'<td class="fecha">' + reserva.fecha + '</td>' +
    '<td><a class="btn btn-warning editar">Editar</a></td>'+
    '<td><a class="btn btn-danger eliminar">Eliminar</a></td>'+
    '</tr>';
}

$('#form-reserva').submit(function(event) {
	if (confirm("Seguro que desea realizar esta operacion?")) {
		sendData();
		event.preventDefault();
	}
});

function addReservaOpenModal() {
	$('#message').empty();
	$('#message').hide();
	$('#inputIdReserva').removeAttr('disabled');
	$('#reservaModal').modal('show');
}

function closeModal() {
	$('#reservaModal').modal('hide');
	$('#form-reserva')[0].reset();
}

function putSelectConductores() {
	$.ajax({
		url : 'http://localhost:1017/reservas-app/conductor/showAll',
		method : "GET"
	}).done(function(data) {
		for (var i = 0; i < data.length; i++) {
			$('#inputIdConductor').append(optionSelectConductorHTML(data[i]));
		}
	});
}

function putSelectVehiculos() {
	$.ajax({
		url : 'http://localhost:1017/reservas-app/vehiculo/showAll',
		method : "GET"
	}).done(function(data) {
		for (var i = 0; i < data.length; i++) {
			$('#inputPlacaVehiculo').append(optionSelectVehiculoHTML(data[i]));
		}
	});
}

function optionSelectConductorHTML(conductor) {
	return '<option value="'+conductor.idConductor+'">'+conductor.idConductor+' | '+conductor.nombre+'</option>';
}

function optionSelectVehiculoHTML(vehiculo) {
	return '<option value="'+vehiculo.placaVehiculo+'">'+vehiculo.placaVehiculo+'</option>';
}

function sendData() {
	var params = '?id_reserva=' + $('#inputIdReserva').val() + '&id_conductor='
			+ $('#inputIdConductor').val() + '&placa_vehiculo='
			+ $('#inputPlacaVehiculo').val() + '&fecha=' + $('#inputFecha').val();
	$.ajax({
		url : 'http://localhost:1017/reservas-app/reserva/save' + params,
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

$('#reservas tbody').on('click', 'tr > td > a.editar', function() {
	$('#message').empty();
	$('#message').hide();
	$('#inputIdReserva').attr('disabled', 'true');
	$(this).closest('tr').find('td').each(function() {
		var td = $(this);
		switch (td.attr('class')) {
		case 'idReserva':
			$('#inputIdReserva').val(td.text());
			break;
		case 'idConductor':
			$('#inputIdConductor').val(td.text());
			break;
		case 'placaVehiculo':
			$('#inputPlacaVehiculo').val(td.text());
			break;
		case 'fecha':
			$('#inputFecha').val(td.text());
			break;
		default:
			console.log("Campo no soportado");
		}
	});
	$('#reservaModal').modal('show');
});

$('#reservas tbody').on('click', 'tr > td > a.eliminar', function() {
	if (confirm("Seguro que desea eliminar el registro?")) {
		$(this).closest('tr').find('td').each(function() {
			var td = $(this);
			if (td.attr('class') == 'idReserva') {
				$.ajax({
					url : 'http://localhost:1017/reservas-app/reserva/delete?id_reserva='+td.text(),
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