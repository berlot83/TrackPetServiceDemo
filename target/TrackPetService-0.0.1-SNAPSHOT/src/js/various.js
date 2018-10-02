
function about(){
		$.confirm({
			type: 'red',
		    title: 'Servicios informativos de mascotas!',
		    content: '<p style="text-align:justify;">Es un producto de alta tecnologia diseñado y desarrollado por Molokotech Solutions, su funcion es crear un codigo QR que asu vez lleva cargado varios datos esenciales sobre la mascota en cuestion, facilitando asi su recuperacion en el caso que la misma se haya perdido.</p><br>Desarrollo y mantenimiento por:<br><a href="http://molokotech.com" style="text-align:center;">Molokotech.com</a> ',
	});
}

function contact(){
	$.confirm({
		type: 'green',
		title: 'Contacto',
		columnClass: 'col-md-6 col-md-offset-3',
		content: 'Para ventas a veterinarias y/o revendedores <a href="mailto:molokotech.com">info@molokotech.com</a><br>Para venta en canal minorista comunicarse con <a href="mailto:molokotech.com">info@molokotech.com</a><br>Para consultas generales sobre el mismo y/o alcances de responsabilidad <a href="mailto:molokotech.com">info@molokotech.com</a>',
		
		buttons: {
	        danger: {
	        	text: 'Continuar',
	            confirmButton: 'btn-red', // multiple classes.
	            confirmButtonClass: 'btn-red',
	            action: function(){}
	        }
	    }
	})
}

function redirectTo(){
	window.location.href="http://molokotech.com";
}

function test(){
	
	var xhr = new XMLHttpRequest();
	var url = "/TrackPetService/rest/pet/tost"; //For Webapp-runner must go this root /rest/pet/insert

	//Send the proper header information along with the request
	xhr.onreadystatechange = function() {//Call a function when the state changes.
	    
		if(xhr.readyState == 4 && xhr.status == 200) {
	    
			if(xhr.responseText){
				xhr.setRequestHeader("token", "acepted");
				console.log(xhr.responseText);
			}else{
				console.log(xhr.responseText);
			}
			
	    }
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("user="+user+"&password="+password);
//		Ajax Call
}
    




function loginToControllers(){
		
	$.confirm({
	    title: 'Login servicio de Etiquetas QR',
	    content: '' +
	    '<form action="" class="formName">' +
	    '<div class="form-group">' +
	    '<label>Usuario</label>' +
	    '<input type="text" id="user" placeholder="Usuario" class="name form-control" required />' +
	    '</div>' +
	    '<div class="form-group">' +
	    '<label>Password</label>' +
	    '<input type="password" id="password" placeholder="Pass" class="name form-control" required />' +
	    '</div>' +
	    '</form>',
	    buttons: {
	        formSubmit: {
	            text: 'Login',
	            btnClass: 'btn-blue',
	            action: function () {
	            	
	            	//		Ajax call
	    			var user = document.getElementById("user").value;
	    			var password = document.getElementById("password").value;
	    			
	    			var xhr = new XMLHttpRequest();
	    			var url = "/TrackPetService/rest/pet/admin"; //For Webapp-runner must go this root /rest/pet/insert
	    		
	    			//Send the proper header information along with the request
	    			xhr.onreadystatechange = function() {//Call a function when the state changes.
	    			    if(xhr.readyState == 4 && xhr.status == 200) {
	    			    
	    			    	
	    			    	if(xhr.responseText == "true"){
			                    console.log(user);
			                    console.log(password);
			                    window.location.replace("/TrackPetService/controllers.jsp");
			                }else{
			                	$.alert("El usuario o password parecen no ser correctos, Si usted es un usuario nuevo comuniquese a <a href='mailto:info@molokotech.com'>info@molokotech.com</a> ");
			                }	
	    			    }
	    			}
	    			xhr.open("POST", url, true);
	    			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	    			xhr.send("user="+user+"&password="+password);
	    	//		Ajax Call
	    			
		            }
	            
	        },
	        cancel: function () {
	            //close
	        },
	    },
	    onContentReady: function () {
	        // bind to events
	        var jc = this;
	        this.$content.find('form').on('submit', function (e) {
	            // if the user submits the form by pressing enter in the field.
	            e.preventDefault();
	            jc.$$formSubmit.trigger('click'); // reference the button and click it
	        });
	    }
	});
}