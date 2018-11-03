package com.service.controllers;

import java.io.IOException;
import java.net.ConnectException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.zxing.WriterException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.service.dao.ConnectionMongoDB;
import com.service.dao.Crud;
import com.service.model.Owner;
import com.service.model.Pet;
import com.service.utilities.PasswordGenerator;
import com.sun.jersey.json.impl.provider.entity.JSONArrayProvider;

@Path("/pet")
public class PetController implements Crud {

	/* Initializer with global variable */
	MongoDatabase connectNow;
	{
		connectNow = ConnectionMongoDB.connectNow();
	}

	@POST
	@Path("/insert")
	@Produces(MediaType.TEXT_HTML)
	@Consumes("application/x-www-form-urlencoded")
	@Override
	public String insertPet(@FormParam("user") String user, @FormParam("raze") String raze,
			@FormParam("name") String name, @FormParam("age") int age, @FormParam("ownerName") String ownerName,
			@FormParam("ownerLastname") String ownerLastname, @FormParam("ownerDni") String ownerDni,
			@FormParam("street1") String street1, @FormParam("phone1") String phone1,
			@FormParam("phone2") String phone2, @FormParam("email") String email, @FormParam("facebook") String facebook, @FormParam("instagram") String instagram, @FormParam("dateAntiRabicVaccine") String dateAntiRabicVaccine,@FormParam("datePolivalentVaccine") String datePolivalentVaccine, @FormParam("dateSextupleVaccine") String dateSextupleVaccine, @FormParam("dateOctupleVaccine") String dateOctupleVaccine, @FormParam("clinicHistory") String clinicHistory,
			@FormParam("illness") String illness, @FormParam("medicated") boolean medicated,
			@FormParam("status") boolean status, @FormParam("subscription") boolean subscription,
			@FormParam("collection") String collection) {

		/* String response */
		String result = null;
		String responseToBase64 = null;
		String stringToJson = null;
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		Pet pet = null;
		
		/* Makes new Connection */
		if (connectNow != null && !name.equals("") && !ownerName.equals("") && !ownerLastname.equals("")) {
			PetController pc = new PetController();

			/* Setting Pet data for the request mandatory */
			pet = new Pet();
			pet.setName(name);
			pet.setOwnerLastname(ownerLastname);
			pet.setOwnerDni(ownerDni);
			pet.setMessage("Descargar Pet-QR de Google Play");
			//pet.setMessage("Para ver los datos importantes de este Código QR es necesario descargar la App QR-Pet de Molokotech.com, Google Play, pet-qr.com.");
			pet.setCollection(user); /* Set collection, mandatory to select collection DB */
			
			/* Create String from a json adapted only for a few fields of the Pet.class */
			stringToJson = gson.toJson(pet);
			responseToBase64 = pc.createQRFromPet(stringToJson);
					
			/* Declare the instant of creation with a new Date() */
			Date dateCreation = new Date();
			
			/* Convert the Date to a Instant.class to generate a pass or a Token to declare lost a Pet for the owner, 10 number digits */
			String token = PasswordGenerator.genPass(dateCreation);
			
			String noDescription = "No declarado";
			if(phone1 == null || phone1.equals("")) {
				phone1 = noDescription;
			}
			if(phone2 == null || phone2.equals("")) {
				phone2 = noDescription;
			}
			if(dateAntiRabicVaccine == null || dateAntiRabicVaccine.equals("")) {
				dateAntiRabicVaccine = noDescription;
			}
			if(datePolivalentVaccine == null || datePolivalentVaccine.equals("")) {
				datePolivalentVaccine = noDescription;
			}
			if(dateSextupleVaccine == null || dateSextupleVaccine.equals("")) {
				dateSextupleVaccine = noDescription;
			}
			if(dateOctupleVaccine == null || dateOctupleVaccine.equals("")) {
				dateOctupleVaccine = noDescription;
			}
			if(email == null || email.equals("")) {
				email = noDescription;
			}
			if(facebook == null || facebook.equals("")) {
				facebook = noDescription;
			}
			if(instagram == null || instagram.equals("")) {
				instagram = noDescription;
			}
			
			/* Connect to DB, append and execute method to insrte */
			MongoCollection<Document> table = connectNow.getCollection(user);
			Document document = new Document();
			document.append("raze", raze);
			document.append("name", name);
			document.append("age", age);
			document.append("ownerName", ownerName);
			document.append("ownerLastname", ownerLastname);
			document.append("ownerDni", ownerDni);
			document.append("email", email);
			document.append("facebook", facebook);
			document.append("instagram", instagram);
			document.append("street1", street1);
			document.append("phone1", phone1);
			document.append("phone2", phone2);
			document.append("dateAntiRabicVaccine", dateAntiRabicVaccine);
			document.append("datePolivalentVaccine", datePolivalentVaccine);
			document.append("dateSextupleVaccine", dateSextupleVaccine);
			document.append("dateOctupleVaccine", dateOctupleVaccine);
			document.append("clinicHistory", clinicHistory);
			document.append("illness", illness);
			document.append("medicated", medicated);
			document.append("status", status);
			document.append("subscription", subscription);
			document.append("toBase64QRCode", responseToBase64);
			document.append("createdDate", dateCreation);
			document.append("token", token);
			table.insertOne(document);

			/* Response */
			result = "Console: Dato insertado";
			
		} else {

			/* Response */
			responseToBase64 = "No se realizó la operación por problema con la DB o controle haber completado nombre de la mascota, nombre, apellido y dni del tutor";
			System.out.println(result);
		}
		return responseToBase64;
	}
	

	/*
	 * Only for search improvement by name or other variable, not to insert and view
	 * at first time
	 */
	@GET
	@Path("/get")
	@Override
	public Document getPet(String name, String nameValue) {
		Document result = null;
		try {
			MongoCollection<Document> table = connectNow.getCollection("pets");
			FindIterable<Document> findIterable = table.find();
			Document document = new Document();
			document.append(name, nameValue);
			MongoCursor<Document> cursor = findIterable.iterator();

			while (cursor.hasNext()) {
				result = cursor.next();
				cursor.close();
				break;
			}
		} catch (NoSuchElementException ex) {
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

	@POST
	@Path("/admin")
	@Produces(MediaType.TEXT_HTML)
	public String getLoginAdmin(@FormParam("user") String user, @FormParam("password") String password) {

		Document result = null;
		String response = null;
		try {
			MongoCollection<Document> table = connectNow.getCollection("admins");
			FindIterable<Document> findIterable = table.find();
			MongoCursor<Document> cursor = findIterable.iterator();

			while (cursor.hasNext()) {
				result = cursor.next();
				response = result.toJson();

				if (result.containsValue(user) && result.containsValue(password)) {
					response = Boolean.TRUE.toString();
					System.out.println(response);
					cursor.close();
					break;
				} else {
					response = Boolean.FALSE.toString();
					cursor.close();
				}
			}
		} catch (Exception ex) {
			System.out.println("Enter to Exception");
		}
		return response;
	}

	@POST
	@Path("/super")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public String getLoginSuperAdmin(@FormParam("user") String user, @FormParam("password") String password) {

		Document result = null;
		String response = null;
		try {
			MongoCollection<Document> table = connectNow.getCollection("super");
			FindIterable<Document> findIterable = table.find();
			MongoCursor<Document> cursor = findIterable.iterator();

			while (cursor.hasNext()) {
				result = cursor.next();
				response = result.toJson();

				String userDB = result.get("user").toString();
				String passwordDB = result.get("password").toString();

				if (userDB.equals(user) && passwordDB.equals(password)) {
					response = Boolean.TRUE.toString();
					System.out.println(response);
					cursor.close();
					break;
				} else {
					response = Boolean.FALSE.toString();
					System.out.println(response);
					cursor.close();
					break;
				}
			}
			cursor.close();
		} catch (Exception ex) {
			System.out.println("Enter to Exception");
		}
		return response;
	}

	/* Returns one resultver aca */
	@GET
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	public String getInfo(@QueryParam("name") String name, @QueryParam("ownerLastname") String ownerLastname, @QueryParam("ownerDni") String ownerDni, @QueryParam("user") String user) throws ConnectException {
		
		String pivot = null;
		String pivotName = null;
		String pivotOwnerLastname = null;
		String pivotDni = null;
		Document result = null;

		MongoCollection<Document> table = connectNow.getCollection(user);
		FindIterable<Document> findIterable = table.find();
		MongoCursor<Document> cursor = findIterable.iterator();
		
		while (cursor.hasNext()) {
			result = cursor.next();
			pivotName = result.get("name").toString();
			pivotOwnerLastname = result.get("ownerLastname").toString();
			pivotDni = result.get("ownerDni").toString();
			
			System.out.println(pivotName);
			System.out.println(pivotOwnerLastname);		
			System.out.println(pivotDni);
			
				if (pivotName.equals(name) ) {
					pivot = result.toJson();
					System.out.println("hay coincidencia");
					break;
				} else {
					System.out.println("No hay coincidencias");
				}
		}
		return pivot;
	}

	/******** Returns one result, deprecated at the moment ***********/
	@GET
	@Path("/url")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getURL(String name, String ownerName, String 	ownerLastname, String user) {
		return "https://pets2018.herokuapp.com/rest/pet/info?name="+name+"&ownerName="+ownerName+"&ownerLastname="+ownerLastname+"&user="+user;
	}
	/********  *******************/

	public String createQRFromPet(String data) {
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
	
	@GET
	@Path("/lost")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllResults(@QueryParam("user") String user){
		ArrayList<Pet> petList = new ArrayList<>();
		String pivotId = null;
		String pivotRaze = null;
		String pivotAge = null;
		String pivotName = null;
		String pivotStreet1 = null;
		LocalDate pivotDateLost = null;
		Gson gson = new Gson();
		String strJson = null;
		Document result = null;

		MongoCollection<Document> table = connectNow.getCollection(user);
		FindIterable<Document> findIterable = table.find();
		MongoCursor<Document> cursor = findIterable.iterator();
		
		while (cursor.hasNext()) {
			result = cursor.next();
			pivotId = result.get("_id").toString();
			pivotRaze = result.get("raze").toString();
			pivotName = result.get("name").toString();
			pivotAge = result.get("age").toString();
			pivotStreet1 = result.get("street1").toString();
			
			petList.add(new Pet(new ObjectId(pivotId).toString(), pivotRaze, pivotName, Integer.parseInt(pivotAge), pivotStreet1, pivotDateLost));
			
			strJson = gson.toJson(petList);
		}
		cursor.close();
		
		return strJson;
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String getMessage() {
		return "Hello World";
	}
	
	public static void main(String[] args) {
		PetController pc = new PetController();
System.out.println(pc.getAllResults("clivet"));
	}
}
