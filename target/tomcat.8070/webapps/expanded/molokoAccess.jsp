<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="src/css/index.css">
<link rel="stylesheet" type="text/css" href="src/css/molokoAccess.css">
<script type="text/javascript" src="src/js/ajaxCalls.js"></script>
<script type="text/javascript" src="src/js/various.js"></script>
<title>Molokotech Acceso privado</title>
</head>

<body>

<!-- Star menu bar -->
<ul>
  <li><a href="index.jsp">Inicio</a></li>
  <li><a href="#" onclick="login()" >Veterinarias/revendedores</a></li>
  <li><a href="#" onclick="contact()" >Contacto</a></li>
  <li><a href="#" onclick="about()" >Sobre Nosotros</a></li>
  <li><a href="#" onclick="about()" >MolokoAccess</a></li>
  <li><a href="#" onclick="reportPet()" >Reportar una mascota</a></li>
  
</ul>
<!-- End menu bar -->

<div id="insertNewClientDiv">
	<div class="row" style="padding: 5%; font-family: 'Pacifico', cursive;">
		<div class="col-6" style="color:Turquoise; text-shadow: 0px 0px 4px rgba(0, 0, 0, 1);">
		<h2 style="font-family: 'Pacifico', cursive; color:'Orchid'; text-align:center;">Agregar nuevo Cliente a la DB</h2>
		<h4 style="color:Turquoise; text-align:center;">"Alta de Cliente"</h4>
			<div class="form-group" style="color:Turquoise;">
				<label for="email">Email</label> <input type="text" id="email"
					placeholder="Email" class="form-control" />
			</div>
			<div class="form-group" style="color:Turquoise;">
				<label for="password">Password</label> <input type="text" id="password"
					placeholder="password" class="form-control" />
			</div>
			<div class="form-group" style="color:Turquoise;">
				<label for="quantity">Espacios en DB</label> <input type="number" id="quantity"
					placeholder="quantity" class="form-control" />
			</div>
			<button id="send" class="btn btn-primary" onclick="insertNewClient()">Insertar nuevo cliente</button>
		</div>
	</div>
</div>

</body>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link charset="utf-8" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
</html>