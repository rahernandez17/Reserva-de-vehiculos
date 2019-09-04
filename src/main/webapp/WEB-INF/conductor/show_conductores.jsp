<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Reservas App - Conductores</title>
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
		<table id="conductores" class="table table-striped">
			<caption>Conductores</caption>
			<thead>
				<tr>
					<th>Id Conductor</th>
					<th>Nombre</th>
					<th>Calificación</th>
					<th>Edad</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
		<div>
			<button type="button" class="btn btn-success"
				onclick="addConductorOpenModal()">Añadir conductor</button>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="conductorModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Agrega un nuevo
						conductor</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="form-conductor">
					<div class="modal-body">
						<div id="message"></div>

						<div id="message"></div>
						<div class="form-group">
							<label for="inputIdConductor">Id conductor</label> <input
								type="number" class="form-control" id="inputIdConductor"
								placeholder="Id Conductor" required>
						</div>
						<div class="form-group">
							<label for="inputNombre">Nombre</label> <input type="text"
								class="form-control" id="inputNombre" placeholder="Nombre"
								required>
						</div>
						<div class="form-group">
							<label for="inputCalificacion">Calificación</label> <input
								type="number" class="form-control" id="inputCalificacion"
								placeholder="Calificación" required>
						</div>
						<div class="form-group">
							<label for="inputEdad">Edad</label> <input type="number"
								class="form-control" id="inputEdad" placeholder="Edad" required>
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
	<script src="js/conductor/conductores_script.js"></script>
</body>
</html>