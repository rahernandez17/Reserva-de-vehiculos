<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Reservas App - Vehiculos</title>
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
		<table id="vehiculos" class="table table-striped">
			<caption>Vehiculos</caption>
			<thead>
				<tr>
					<th>Placa</th>
					<th>Marca</th>
					<th>Modelo</th>
					<th>Color</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
		<div>
			<button type="button" class="btn btn-success"
				onclick="addVehiculoOpenModal()">Añadir vehiculo</button>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="vehiculoModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="form-vehiculo">
					<div class="modal-body">
						<div id="message"></div>
						<div class="form-group">
							<label for="inputPlacaVehiculo">Placa</label> <input type="text"
								class="form-control" id="inputPlacaVehiculo"
								placeholder="Placa vehiculo"
								pattern="^[A-Z]{3}-[1-9]{3}|^[A-Z]{1}[1-9]{1}[A-Z]{1}-[1-9]{3}|^[1-9]{4}-[A-Z,1-9]{2}|^[A-Z]{2}-[1-9]{4}$"
								required>
						</div>
						<div class="form-group">
							<label for="inputMarca">Marca</label> <input type="text"
								class="form-control" id="inputMarca" placeholder="Marca"
								required>
						</div>
						<div class="form-group">
							<label for="inputModelo">Modelo</label> <input type="text"
								class="form-control" id="inputModelo" placeholder="Modelo"
								required>
						</div>
						<div class="form-group">
							<label for="inputColor">Color</label> <select
								class="form-control" id="inputColor" required>
								<option disabled selected>Seleccione una opción</option>
								<option value="Azul">Azul</option>
								<option value="Marrón">Marrón</option>
								<option value="Rojo">Rojo</option>
								<option value="Verde">Verde</option>
								<option value="Amarillo">Amarillo</option>
								<option value="Gris">Gris</option>
								<option value="Blanco">Blanco</option>
								<option value="Negro">Negro</option>
							</select>
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
	<script src="js/vehiculo/vehiculos_script.js"></script>
</body>
</html>