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

import org.bson.Document;

import com.google.zxing.WriterException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.service.dao.ConnectionMongoDB;
import com.service.dao.Crud;
import com.service.model.Pet;

@Path("/pet")
public class PetController implements Crud {
	/* Initializer with global variable */
	MongoDatabase connectNow;
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
			MongoCollection table = connectNow.getCollection("pets");
			Document document = new Document();
			document.append("raze", raze);
			document.append("name", name);
			document.append("age", age);
			document.append("street1", street1);
			document.append("street2", street2);
			document.append("city", city);
			document.append("phone1", phone1);
			document.append("phone2", phone2);
			document.append("illness", illness);
			document.append("createdDate", new Date());
			table.insertOne(document);
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
	public Document getPet(String name, String value) {
		Document result = null;
		try{
			MongoCollection<Document> table = connectNow.getCollection("pets");
			FindIterable<Document> findIterable = table.find();
			Document document = new Document();
			document.append(name, value);
			MongoCursor<Document> cursor = findIterable.iterator();
			
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
