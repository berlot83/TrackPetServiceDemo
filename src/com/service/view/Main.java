package com.service.view;

import java.net.URISyntaxException;
import java.util.Random;

import com.mongodb.DBObject;
import com.service.controllers.PetController;
import com.service.controllers.QRCodeGenerator;

public class Main {

	public static void main(String[] args) throws URISyntaxException {
		
		/* Only to Test-ones */
		
		PetController pc = new PetController();
			//pc.insertPet("Dachhound", "Buddy", 2, "Lisandro de la Torre", "Battle y ordoñez", "Capital Federal", "11-53189339", "11-46020378", "Ninguna");
			//DBObject object = pc.getPet("name", "Peppon");
			//pc.createQRFromPet("name","Peppon");
		}

}
