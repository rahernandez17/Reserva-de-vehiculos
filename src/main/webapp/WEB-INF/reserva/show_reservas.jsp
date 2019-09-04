<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Reservas App - Reservas</title>
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Opciones <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/reservas-app/conductor">Conductores</a></li>
						<li><a href="/reservas-app/vehiculo">Vehiculos</a></li>
						<li><a href="/reservas-app/reserva">Reservas</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	<div class="container">
		<table id="reservas" class="table table-striped">
			<caption>Reservas</caption>
			<thead>
				<tr>
					<th>Id Reserva</th>
					<th>Id Conductor</th>
					<th>Nombre Conductor</th>
					<th>Placa Vehiculo</th>
					<th>Fecha</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
		<div>
			<button type="button" class="btn btn-success"
				onclick="addReservaOpenModal()">Añadir reserva</button>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="reservaModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Agrega una nueva reserva</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="form-reserva">
					<div class="modal-body">
						<div id="message"></div>
						<div class="form-group">
							<label for="inputIdReserva">Id Reserva</label> <input
								type="number" class="form-control" id="inputIdReserva"
								placeholder="Id Reserva">
						</div>
						<div class="form-group">
							<label for="inputIdConductor">Conductor</label> <select
								class="form-control" id="inputIdConductor">
								<option disabled selected>Seleccione una opción</option>
							</select>
						</div>
						<div class="form-group">
							<label for="inputPlacaVehiculo">Vehiculo</label> <select
								class="form-control" id="inputPlacaVehiculo">
								<option disabled selected>Seleccione una opción</option>
							</select>
						</div>
						<div class="form-group">
							<label for="inputFecha">Fecha</label> <input type="date"
								class="form-control" id="inputFecha" placeholder="Fecha">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="closeModal()">Close</button>
						<button type="submit" class="btn btn-success">Save
							changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="js/reserva/reservas_script.js"></script>
</body>
</html>