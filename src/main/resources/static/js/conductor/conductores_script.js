$(document).ready(function() {
	getAll();
});

function getAll() {
	$('#conductores tbody').empty();
	$.ajax({
		url : 'http://localhost:1017/reservas-app/conductor/showAll',
		method : "GET"
	}).done(function(data) {
		for (var i = 0; i < data.length; i++) {
			$('#conductores > tbody').append(showConductoresHTML(data[i]));
		}
	});
}

function showConductoresHTML(conductor) {
	return '<tr>'
			+ '<td class="idConductor">'
			+ conductor.idConductor
			+ '</td>'
			+ '<td class="nombre">'
			+ conductor.nombre
			+ '</td>'
			+ '<td class="calificacion">'
			+ conductor.calificacion
			+ '</td>'
			+ '<td class="edad">'
			+ conductor.edad
			+ '</td>'
			+ '<td><a class="btn btn-warning editar">Editar</a></td>'
			+ '<td><a class="btn btn-danger eliminar">Eliminar</a></td>'
			+ '</tr>';
}

$('#form-conductor').submit(function(event) {
	if (confirm("Seguro que desea realizar esta operacion?")) {
		sendData();
		event.preventDefault();
	}
});

function addConductorOpenModal() {
	$('#message').empty();
	$('#inputIdConductor').removeAttr('disabled');
	$('#conductorModal').modal('show');
}

function closeModal() {
	$('#conductorModal').modal('hide');
	$('#form-conductor')[0].reset();
}

function sendData() {
	var params = '?id_conductor=' + $('#inputIdConductor').val() + '&nombre='
			+ $('#inputNombre').val() + '&calificacion='
			+ $('#inputCalificacion').val() + '&edad=' + $('#inputEdad').val();
	$.ajax({
		url : 'http://localhost:1017/reservas-app/conductor/save' + params,
		method : 'POST'
	}).done(function(data) {
		if (data.httpStatus == 'OK') {
			$('#message').empty();
			$('#message').addClass('alert alert-' + data.severity);
			$('#message').append('<p>' + data.message + '</p>');
			closeModal();
			getAll();
		}
	});
}

$('#conductores tbody').on('click', 'tr > td > a.editar', function() {
	$('#message').empty();
	$('#inputIdConductor').attr('disabled', 'true');
	$(this).closest('tr').find('td').each(function() {
		var td = $(this);
		switch (td.attr('class')) {
		case 'idConductor':
			$('#inputIdConductor').val(td.text());
			break;
		case 'nombre':
			$('#inputNombre').val(td.text());
			break;
		case 'calificacion':
			$('#inputCalificacion').val(td.text());
			break;
		case 'edad':
			$('#inputEdad').val(td.text());
			break;
		}
	});
	$('#conductorModal').modal('show');
});

$('#conductores tbody').on('click', 'tr > td > a.eliminar', function() {
	if (confirm("Seguro que desea eliminar el registro?")) {
		$(this).closest('tr').find('td').each(function() {
			var td = $(this);
			if (td.attr('class') == 'idConductor') {
				$.ajax({
					url : 'http://localhost:1017/reservas-app/conductor/delete?id_conductor='+td.text(),
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
