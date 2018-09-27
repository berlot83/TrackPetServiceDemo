/**
 * Author AAB
 * 2018
 */

/* File source Ajax calls */
function insertPet(){
	console.log("Hola mundo");
	var raze = document.getElementById("raze");
	var name = document.getElementById("name");
	var age = document.getElementById("age");
	var street1 = document.getElementById("street1");
	var street2 = document.getElementById("street2");
	var city = document.getElementById("city");
	var phone1 = document.getElementById("phone1");
	var phone2 = document.getElementById("phone2");
	var illness = document.getElementById("illness");
	
	var xhr = new XMLHttpRequest();
	var url = "/TrackPetService/rest/pet/insert";

	//Send the proper header information along with the request
	xhr.onreadystatechange = function() {//Call a function when the state changes.
	    if(xhr.readyState == 4 && xhr.status == 200) {
	  
	    	/* On Controllers page to show QR tag generated */
	    	var createImage = document.createElement("img");
	    	var divResult = document.getElementById("qrResult");	    	
	    	var attribute = document.createAttribute("src");
	    	attribute.value = "data:image/png;base64, "+xhr.responseText;
	    	createImage.setAttributeNode(attribute);
	    	divResult.appendChild(createImage);
	    	
	    	var link = document.createElement("a");
	    	var hrefAttribute = document.createAttribute("href");
	    	hrefAttribute.value = "google.com.ar";
	    	link.setAttributeNode(hrefAttribute);
	    	link.setAttribute('download', 'Filename.jpg');
	    	link.setAttribute('target', '_blank');
	    	
	    	var button = document.createElement("button");

	    	var classAttribute = document.createAttribute("class");
	    	classAttribute.value = "btn btn-primary";
	    	button.setAttributeNode(classAttribute);
	    	
	    	button.innerHTML = "Descarga";
	    	var downloadButtonDiv = document.getElementById("downloadButtonDiv");
	    	downloadButtonDiv.appendChild(button);
	    	
	    	button.appendChild(link);
	    	
	    }
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("raze="+raze.value+"&name="+name.value+"&age="+age.value+"&street1="+street1.value+"&street2="+street2.value+"&city="+city.value+"&phone1="+phone1.value+"&phone2="+phone2.value+"&illness="+illness.value);
}

function advice(){
$.alert({
	type: 'blue',
    title: 'Etiqueta QR',
    content: 'Recuerde que cuando toque crear y enviar debe descargar la imagen QR para luego utilizarla, si no se realiza esa accion y se recarga la pagina hay que cargar los datos de nuevo.',
});
}
