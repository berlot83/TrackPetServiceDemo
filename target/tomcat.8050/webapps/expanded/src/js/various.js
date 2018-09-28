
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

function login(){
	$.confirm({
	    title: 'Login servicio de Etiquetas QR',
	    content: '' +
	    '<form action="" class="formName">' +
	    '<div class="form-group">' +
	    '<label>Email</label>' +
	    '<input type="text" id="name" placeholder="Email" class="name form-control" required />' +
	    '</div>' +
	    '<div class="form-group">' +
	    '<label>Password</label>' +
	    '<input type="text" id="password" placeholder="Pass" class="name form-control" required />' +
	    '</div>' +
	    '</form>',
	    buttons: {
	        formSubmit: {
	            text: 'Login',
	            btnClass: 'btn-blue',
	            action: function () {
	                var name = this.$content.find('.name').val();
	                if(!name){
	                    $.alert('provide a valid name');
	                    return false;
	                }
	                $.alert('Your name is ' + name);
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