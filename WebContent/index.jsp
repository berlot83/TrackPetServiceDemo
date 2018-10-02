<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="src/css/index.css">
<script type="text/javascript" src="src/js/ajaxCalls.js"></script>
<script type="text/javascript" src="src/js/various.js"></script>
<title>Track Pet Service</title>
</head>

<body>

<!-- Star menu bar -->
<ul>
  <li><a href="index.jsp">Inicio</a></li>
  <li><a href="/controllers.jsp" onclick="#" >QR-Clientes</a></li>
  <li><a href="#" onclick="contact()" >Contacto</a></li>
  <li><a href="#" onclick="about()" >Sobre Nosotros</a></li>
  <li><a href="molokoAccess.jsp" >MolokoAccess</a></li>
<!--     <li><a href="#" onclick="reportPet()" >Reportar una mascota</a></li> -->
</ul>
<!-- End menu bar -->
<div id="firstBody" class="row" >
<!--  Start Carousel -->
<div id="carouselExampleControls" class="carousel slide, col-6" data-ride="carousel" style="text-shadow: 0px 0px 20px black;" >
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="img-fluid w-100" src="src/img/lostDog1.jpg" alt="First slide" >
        <div class="carousel-caption d-none d-md-block">
		    <h3>Porque am�s a tu mascota...</h3>
		    <p>Quer�s lo mejor para ella</p>
		  </div>
    </div>
    <div class="carousel-item">
      <img class="img-fluid w-100" src="src/img/lostDog2.jpg" alt="Second slide">
      	<div class="carousel-caption d-none d-md-block">
    		<h3>Har�as cualquier cosa por tu amigo...</h3>
    		<p>Porque te quiere y no lo vas a abandonar</p>
  		</div>
    </div>
    <div class="carousel-item">
      <img class="img-fluid w-100" src="src/img/lostDog3.jpg" alt="Third slide">
      	<div class="carousel-caption d-none d-md-block">
    		<h3>Solo resta que alguien se fije en �l...</h3>
    		<p>LLevar� con ella todos los datos que quieras</p>
  		</div>
    </div>
    <div class="carousel-item">
      <img class="img-fluid w-100" src="src/img/lostDog4.jpg" alt="Four slide">
         <div class="carousel-caption d-none d-md-block">
    		<h3>El nunca te abandonar�a...</h3>
    		<p>Te buscar�a hasta el final, vos pod�s hacer lo mismo</p>
  </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Atr�s</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Siguiente</span>
  </a>
</div>
<!--  End Carousel -->
<div id="infoDiv" class="col-6" >
<h3>Servicios brindados</h3>
<p>Proveemos un servicio avanzado de informaci�n en base de datos en la nube de mascotas, la veterinaria o revendedor de este sistema crea un c�digo QR que a su vez impacta en una base de datos donde quedan almacenados los datos del animal, si alguna vez el mismo se perdiera y lleva el c�digo QR en alguna parte como una chapa identificatoria o pegado en el collar, ser�a muy f�cil acceder a la informaci�n desde cualquier dispositivo m�vil. No es necesario realizar ninguna operaci�n invasiva ni similar, s�lo imprimir el c�digo en las chapas o en algun sticker para que puedan ser cargados por los animales a todos lados.</p>
</div>

</div>
</body>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link charset="utf-8" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
</html>