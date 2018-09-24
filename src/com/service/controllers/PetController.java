package com.service.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.NoSuchElementException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.zxing.WriterException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.service.dao.ConnectionMongoDB;
import com.service.dao.Crud;
import com.service.model.Pet;

@Path("/pet")
public class PetController implements Crud {
	/* Initializer with global variable */
	DB connectNow;
	{
		connectNow = ConnectionMongoDB.connectNow();
	}
	
	@POST
	@Path("/insert")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	@Override
	public String insertPet(@FormParam("raze") String raze, @FormParam("name") String name, @FormParam("age") int age, @FormParam("street1") String street1, @FormParam("street2") String street2, @FormParam("city") String city, @FormParam("phone1") String phone1, @FormParam("phone2") String phone2, @FormParam("illness") String illness) {
		String respuesta = null;
		if(connectNow != null) {
			DBCollection table = connectNow.getCollection("pets");
			BasicDBObject document = new BasicDBObject();
			document.put("raze", raze);
			document.put("name", name);
			document.put("age", age);
			document.put("street1", street1);
			document.put("street2", street2);
			document.put("city", city);
			document.put("phone1", phone1);
			document.put("phone2", phone2);
			document.put("illness", illness);
			document.put("createdDate", new Date());
			table.insert(document);
			System.out.println("Dato insertado");
			PetController pc = new PetController();
			try {
				respuesta = pc.createQRFromPet("name", name);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			respuesta = "La insercción no pudo realizarse, probablemente haya un conflicto con la DB";
		}
		return respuesta;
	}
	
	@GET
	@Path("get")
	@Override
	public DBObject getPet(String name, String value) {
		DBObject result = null;
		try{
			DBCollection table = connectNow.getCollection("pets");
			BasicDBObject document = new BasicDBObject();
			document.put(name, value);
			DBCursor cursor = table.find(document);
			
			while(cursor.hasNext()) {
				result = cursor.next();
				break;
			}			
		}catch(NoSuchElementException ex) {	
			System.out.println("Enter to Exception");
		}
	return result;
	}
	
	@Override
	public Pet updatePet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePet() {
		// TODO Auto-generated method stub
		
	}
	
	
	public String createQRFromPet(String name, String value) throws URISyntaxException {
		//final String QR_CODE_IMAGE_PATH = "C:\\Users\\user\\Documents\\workspace-sts-3.9.0.RELEASE\\TrackPetService\\WebContent\\QRcodes\\MyQRCode_"+value+".png";
		final String QR_CODE_IMAGE_PATH = "https://pets2018.herokuapp.com/QRcodes/MyQRCode_"+value+".png";
		
		String resultBase64 = null;
		try {
	    	resultBase64 = QRCodeGenerator.generateQRCodeImageToBase64(getPet(name, value).toString(), 300, 300, QR_CODE_IMAGE_PATH, value);
		} catch (WriterException e) {
	        System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
	    }
		return resultBase64;
	}

}
