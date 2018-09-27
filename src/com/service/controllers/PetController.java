package com.service.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.bson.Document;
import com.google.gson.Gson;
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
		/* String response */
		String response = null;
		
		/* Declares Json and create a new Pet to insert data */
		Gson gson = new Gson();
		Pet pet = new Pet(raze, name, age,street1, street2, city, phone1, phone2, illness);
		
		/* Add all data needed formatted to Json String */
		String json = gson.toJson(pet);
		String toBase64QRCode = null;
		
		/* Makes new Connection */
		if(connectNow != null) {
			PetController pc = new PetController();
			try {
				toBase64QRCode = pc.createQRFromPet(json);
				System.out.println(toBase64QRCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			MongoCollection<Document> table = connectNow.getCollection("pets");
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
			document.append("toBase64QRCode", toBase64QRCode );
			document.append("createdDate", new Date());
			table.insertOne(document);
			
			/* Response */
			response = "Console: Dato insertado";
			System.out.println(response);
		}else {
			
			/* Response */
			response = "Console: La insercción no pudo realizarse, probablemente haya un conflicto con la DB";
			toBase64QRCode = response; // If goes wrong take the same value from response so server says cant do it;
			System.out.println(response);
		}
		return toBase64QRCode;
	}
	
	/* Only for search improvement by name or other variable, not to insert and view at first time */
	@GET
	@Path("get")
	@Override
	public Document getPet(String name, String nameValue) {
		Document result = null;
		try{
			MongoCollection<Document> table = connectNow.getCollection("pets");
			FindIterable<Document> findIterable = table.find();
			Document document = new Document();
			document.append(name, nameValue);
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
		return null;
	}

	@Override
	public void deletePet() {
	}
	
	public String createQRFromPet(String data){
		
		byte[] resultToByte = null;
		String toBase64 = null;
		try {
			/* Convert to byte[] ZXing html form */
	    	resultToByte = QRCodeGenerator.generateQRCodeImageToByte(data, 300, 300);
	    	
	    	/* Convert to Base64 the last byte[] variable */
	    	toBase64 = QRCodeGenerator.toBase64(resultToByte);
	    	
	    	/* Print it for test-one */
	    	System.out.println(toBase64);
		} catch (WriterException e) {
	        System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
	    }
		return toBase64;
	}

}
