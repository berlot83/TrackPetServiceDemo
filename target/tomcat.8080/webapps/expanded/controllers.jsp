<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="src/css/controllers" >
<script type="text/javascript" src="src/js/ajaxCalls.js"></script>
<script type="text/javascript" src="src/js/various.js"></script>

<link rel="stylesheet" type="text/css" href="src/css/index.css">

<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
<script type="text/javascript">
window.onbeforeunload = function(e) {
    return 'Please press the Logout button to logout.';
};
</script>

<title>Track Pet services Controller Page</title>
</head>
<body onload="advice()" style="background-image: url('src/img/pawbackground.png'); background-repeat:'no-repeat'; background-attachment: fixed;" >
	
	<!-- Star menu bar -->
	<ul>
	  <li><a href="index.jsp">Inicio</a></li>
	  <li><a href="controllers.jsp">Veterinarias/revendedores</a></li>
	  <li><a href="#" onclick="contact()" >Contacto</a></li>
	  <li><a href="#" onclick="about()" >Sobre Nosotros</a></li>
	  <li><a href="#" onclick="about()" >MolokoAccess</a></li>
	    <li><a href="#" onclick="reportPet()" >Reportar una mascota</a></li>
	</ul>
	<!-- End menu bar -->
	
	<div id="divContent" style="padding-left:50px; padding-right:50px;">
	<div class="row" style="padding: 5%; font-family: 'Pacifico', cursive;">
		<div class="col-6" style="color:Turquoise; text-shadow: 0px 0px 8px rgba(0, 0, 0, 1);">
		<h2 style="font-family: 'Pacifico', cursive; color:'Orchid'; text-align:center;">Servicio de información de mascotas</h2>
		<h4 style="color:Turquoise; text-align:center;">"Alta de Mascota"</h4>
			<div class="form-group" style="color:Turquoise;">
				<label for="raze">Raza</label> <input type="text" id="raze"
					placeholder="raze" class="form-control" />
			</div>
			<div class="form-group" style="color:Turquoise;">
				<label for="name">Nombre</label> <input type="text" id="name"
					placeholder="name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="age">Edad</label> <input type="number" id="age"
					placeholder="age" class="form-control" />
			</div>
			<div class="form-group">
				<label for="street1">Dirección principal (Altura incluida)</label> <input
					type="text" id="street1" placeholder="street1" class="form-control" />
			</div>
			<div class="form-group">
				<label for="street2">Corta con Calle</label> <input type="text"
					id="street2" placeholder="street2" class="form-control" />
			</div>
			<div class="form-group">
				<label for="city">Ciudad</label> <input type="text" id="city"
					placeholder="city" class="form-control" />
			</div>
			<div class="form-group">
				<label for="phone1">Teléfono</label> <input type="text" id="phone1"
					placeholder="phone1" class="form-control" />
			</div>
			<div class="form-group">
				<label for="phone2">Teléfono</label> <input type="text" id="phone2"
					placeholder="phone2" class="form-control" />
			</div>
			<div class="form-group"> 
				<label for="illness">Sufre alguna efermedad</label> <input
					type="text" id="illness" placeholder="illness" class="form-control" />
			</div>
			<button id="send" class="btn btn-primary" onclick="insertPet()" >Enviar y crear Código QR</button>
		</div>
		<div class="col-6">
		<br>
		<h4 style="color:Plum; text-shadow: 0px 0px 4px rgba(0, 0, 0, 1);">Etiqueta QR:</h4>
		<hr>
		<div id="qrResult" style="text-align:center;">
		<!-- Ajax call response from endpoint with qrCodeImages -->
		<div id="downloadButtonDiv" ></div>
		</div>
		<hr>
			<img alt="" src="src/img/pet1.jpg" class="img-fluid w-100, rounded">
			<div>
				<strong>Powered by</strong>
			</div>
			<img alt="Molokotech" src="src/img/molokoalternativo.png"
				class="img-fluid" onclick="redirectTo()" >
				
		</div>
	</div>
	</div>
</body>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
		<link charset="utf-8" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>

</html>