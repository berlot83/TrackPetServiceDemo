<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type="text/javascript" src="src/js/ajaxCalls.js"></script>
<link href="https://fonts.googleapis.com/css?family=Mali:500" rel="stylesheet">

<script type="text/javascript" src="src/js/various.js"></script>
<link rel="stylesheet" type="text/css" href="src/css/index.css">
<link rel="stylesheet" type="text/css" href="src/css/controllers.css">
<link rel="stylesheet" type="text/css" href="src/css/maps.css">

<script type="text/javascript">
window.onbeforeunload = function(e) {
    return 'Please press the Logout button to logout.';
};
</script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
<title>Track Pet services Controller Page</title>
</head>
<body onload="advice(), initMap()" >
<!-- background-image: url('src/img/pawbackground.png'); background-repeat: 'no-repeat'; background-attachment: fixed; -->
	<!-- Star menu bar -->
	<ul>
		<li><a href="index.jsp">Inicio</a></li>
		<li><a href="#" onclick="contact()">Contacto</a></li>
		<li><a href="#" onclick="about()">Sobre Nosotros</a></li>
		<li><a href="/TrackPetService/molokoAccess.jsp" >MolokoAccess</a></li>
<!-- 		<li><a href="#" onclick="reportPet()">Reportar una mascota</a></li> -->
	</ul>
	<!-- End menu bar -->

	<div id="divContent" style="padding-left: 50px; padding-right: 50px;">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<h2 style="text-align: center">Servicio de información de mascotas</h2>
					<h4 style="text-align: center;">"Alta de Mascota"</h4>
				<h3>Datos de la mascota</h3>
				<hr>
				<div class="form-group">
					<label for="raze">Raza</label>

					<!-- Start selector raze -->
					<select class="form-control" id="raze">
						<option value="Otra" selected>Otra</option>
						<option value="Mestizo">Mestizo</option>
						<option value="Alaskan Malamute">Alaskan Malamute</option>
						<option value="American Staffordshire">American
							Staffordshire</option>
						<option value="Basset Hound">Basset Hound</option>
						<option value="Beagle">Beagle</option>
						<option value="Bichón Maltés">Bichón Maltés</option>
						<option value="Mobtail">Bobtail</option>
						<option value="Boxer">Boxer</option>
						<option value="Branco Alemán">Branco Alemán</option>
						<option value="Bulldog Francés">Bulldog Francés</option>
						<option value="Bulldog Inglés">Bulldog Inglés</option>
						<option value="Bullmastiff">Bullmastiff</option>
						<option value="Cane Corso">Cane Corso</option>
						<option value="Caniche">Caniche</option>
						<option value="Carlino">Carlino</option>
						<option value="Chihuahua">Chihuahua</option>
						<option value="Chow Chow">Chow Chow</option>
						<option value="Cocker Spaniel">Cocker Spaniel</option>
						<option value="Collie">Collie</option>
						<option value="Dálmata">Dálmata</option>
						<option value="Dobermann">Dobermann</option>
						<option value="Espagneul Breton">Espagneul Bretón</option>
						<option value="Galgo Español">Galgo Español</option>
						<option value="Golden Retriever">Golden Retriever</option>
						<option value="Husky Siberiano">Husky Siberiano</option>
						<option value="Labrador Retriever">Labrador Retriever</option>
						<option value="Leonberguer">Leonberguer</option>
						<option value="Mastín Español">Mastín Español</option>
						<option value="Pastor Alemán">Pastor Alemán</option>
						<option value="Pastor de Brie">Pastor de Brie</option>
						<option value="Perro de Agua Español">Perro de Agua
							Español</option>
						<option value="San Bernardo">San Bernardo</option>
						<option value="Scottish Terrier">Scottish Terrier</option>
						<option value="Schnauzer Miniatura">Schnauzer Miniatura</option>
						<option value="Setter Inglés">Setter Inglés</option>
						<option value="Teckel">Teckel</option>
						<option value="Terrier de Bedlington">Terrier de
							Bedlington</option>
						<option value="West Highland Terrier">West Highland
							Terrier</option>
						<option value="Yorkshire Terrier">Yorkshire Terrier</option>
					</select>
				</div>
				<!-- End selector raze -->

				<div class="form-group">
					<label for="name">Nombre</label> <input type="text" id="name"
						placeholder="Nombre de la mascota" class="form-control" />
				</div>
				<div class="form-group">
					<label for="age">Edad</label><div id="resultAge"></div> 
				
				<!-- Start select age -->
					<select class="form-control" id="age" onchange="age()">
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
						<option value="2015">2015</option>
						<option value="2014">2014</option>
						<option value="2013">2013</option>
						<option value="2012">2012</option>
						<option value="2011">2011</option>
						<option value="2010">2010</option>
						<option value="2009">2009</option>
						<option value="2008">2008</option>
						<option value="2007">2007</option>
						<option value="2006">2006</option>
						<option value="2005">2005</option>
						<option value="2004">2004</option>
						<option value="2003">2003</option>
						<option value="2002">2002</option>
						<option value="2001">2001</option>
						<option value="2000">2000</option>
						<option value="1999">1999</option>
						<option value="1998">1998</option>
						<option value="1997">1997</option>
						<option value="1996">1996</option>
						<option value="1995">1995</option>
					</select>
					<!-- End select age -->
				<script type="text/javascript">
				function age(){
					var yearBirthay = document.getElementById("age");
					var actualYear = (new Date()).getFullYear();
					var age = actualYear - yearBirthay.value; 
					
					console.log(age);
					
					var resultAge = document.getElementById("resultAge");
					
					resultAge.innerHTML = "<h5><a href='#'><span class='badge badge-danger'>Edad actual de la mascota:  "+age+" años</span></a></h5>";
				}
				
				</script>
				
				</div>
				
								<div class="form-group">
					<label for="illness">Sufre alguna efermedad</label>
				<!-- Start select age -->
					<select class="form-control" id="illness">
						<option value="Ninguna">Ninguna</option>
						<option value="Gastritis">Gastritis</option>
					</select>
				</div>
				<div class="form-group">
					<label for="clinicHistory">Historia Clínica</label>
					<textarea id="clinicHistory" placeholder="Historia Clínica" rows="9" class="form-control"></textarea>
				</div>
				<div class="form-group">
					<label for="medicated">Está medicado</label>		
						<!-- Start select Medicated -->
					<select class="form-control" id="medicated">
						<option value= true>Sí</option>
						<option value= false>No</option>
					</select>
				</div>
				<div class="form-group">
					<label for="status">Estado</label>
						<!-- Start select status -->
					<select class="form-control" id="status">
						<option value= true>Normal</option>
						<option value= false>Perdido</option>
					</select>
				</div>
				<div class="form-group">
					<label for="subscription">Subscripción</label>
						<!-- Start select subscription -->
					<select class="form-control" id="subscription">
						<option value= true>Sí</option>
						<option value= false>No</option>
					</select>
				</div>

				<h3>Datos del Tutor</h3>
				<hr>
				<div class="form-group">
					<label for="ownerName">Nombre</label> <input type="text"
						id="ownerName" placeholder="Nombre del cuidador" class="form-control" />
				</div>
				
				<div class="form-group">
					<label for="ownerLastname">Apellido</label> <input type="text"
						id="ownerLastname" placeholder="Apellido del cuidador" class="form-control" />
				</div>
				
				<div class="form-group">
					<label for="ownerDni">D.N.I</label> <input type="number"
						id="ownerDni" placeholder="DNI del cuidador" class="form-control" />
				</div>
				
				<div class="form-group">
					<label for="phone1">Teléfono</label> <input type="number"
						id="phone1" placeholder="Teléfono primario" class="form-control" />
				</div>
				<div class="form-group">
					<label for="phone2">Teléfono</label> <input type="number"
						id="phone2" placeholder="Teléfono secundario" class="form-control" />
				</div>
				
				<div class="form-group">
					<label for="street1">Dirección principal (Dirección altura, localidad, provincia)</label>
					<input type="text" id="street1" placeholder="Av. Libertador 650, Buenos Aires, Argentina"
						class="form-control" />
				</div>
				
				<!-- Map Start -->
				<div id="map"></div>
				<!-- Map End -->
				<br>
				<div class="form-group">
<!-- 				<button id="send" class="btn btn-danger" onclick="insertPet()" >Almacenar datos -->
<!-- 					y crear Código QR</button> -->
				
				<button id="send" class="btn btn-danger" onclick="loginAndInsert()" >Almacenar datos y crear Código QR</button>
				</div>
					<h4>Etiqueta QR:</h4>
				<hr>
				<div id="qrResult" style="text-align: center;">
				<br>
					<!-- Ajax call response from endpoint with qrCodeImages -->
					<div id="downloadButtonDiv"></div>
				<br>
				</div>
				<hr>
				<img alt="" src="src/img/pet1.jpg" class="img-fluid w-100, rounded">
				<div>
					<strong>Powered by</strong>
				</div>
				<img alt="Molokotech" src="src/img/molokoalternativo.png"
					class="img-fluid" onclick="redirectTo()">
			</div>
			<div class="col-2"></div>
		</div>
	</div>
	
	<!-- Start Google Maps Javascript -->
</body>
<script type="text/javascript" src="src/js/googleApis.js"></script>


<!-- Javascript maps libraries -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDB_hzs9qAghUI1cOMXPae5Km72VFkYXKQ&libraries=places&callback=initMap"
        async defer></script>
<!-- Javascript maps libraries -->

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

<link charset="utf-8" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js"></script>
	
</html>