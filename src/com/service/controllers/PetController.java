package com.service.controllers;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Date;
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
	public String insertPet(@FormParam("user") String user, @FormParam("raze") String raze,
			@FormParam("name") String name, @FormParam("age") int age, @FormParam("ownerName") String ownerName,
			@FormParam("ownerLastname") String ownerLastname, @FormParam("ownerDni") String ownerDni,
			@FormParam("street1") String street1, @FormParam("phone1") String phone1,
			@FormParam("phone2") String phone2, @FormParam("clinicHistory") String clinicHistory,
			@FormParam("illness") String illness, @FormParam("medicated") boolean medicated,
			@FormParam("status") boolean status, @FormParam("subscription") boolean subscription,
			@FormParam("collection") String collection) {

		/* String response */
		String response = null;

		/* Declares Json and create a new Pet to insert data */
//		Gson gson = new Gson();
//		Pet pet = new Pet(raze, name, age, ownerName, ownerLastname, ownerDni, street1, phone1, phone2, clinicHistory,
//				illness, medicated, status, subscription);

		/* Add all data needed formatted to Json String */
//		String json = gson.toJson(pet);
		String toBase64QRCode = null;

		/* Makes new Connection */
		if (connectNow != null) {
			PetController pc = new PetController();
//			try {
//				toBase64QRCode = pc.createQRFromPet(json);
//				System.out.println(toBase64QRCode);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			MongoCollection<Document> table = connectNow.getCollection(user);
			Document document = new Document();
			document.append("raze", raze);
			document.append("name", name);
			document.append("age", age);
			document.append("ownerName", ownerName);
			document.append("ownerLastname", ownerLastname);
			document.append("ownerDni", ownerDni);
			document.append("street1", street1);
			document.append("phone1", phone1);
			document.append("phone2", phone2);
			document.append("illness", illness);
			document.append("medicated", medicated);
			document.append("status", status);
			document.append("subscription", subscription);
			document.append("toBase64QRCode", toBase64QRCode);
			document.append("createdDate", new Date());
			table.insertOne(document);

			/* Response */
			response = "Console: Dato insertado";
			System.out.println(response);
			String url = pc.getURL(name, ownerName, ownerLastname, user);
			toBase64QRCode = pc.createQRFromPet(url);
		} else {

			/* Response */
			response = "Console: La insercci�n no pudo realizarse, probablemente haya un conflicto con la DB";
			toBase64QRCode = response; // If goes wrong take the same value from response so server says cant do it;
			System.out.println(response);
		}
		return toBase64QRCode;
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
					break;
				} else {
					response = Boolean.FALSE.toString();
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
					break;
				} else {
					response = Boolean.FALSE.toString();
					System.out.println(response);
					break;
				}

			}
		} catch (Exception ex) {
			System.out.println("Enter to Exception");
		}
		return response;
	}

	/* Returns one resultver aca */
	@GET
	@Path("/info")
	@Produces(MediaType.APPLICATION_JSON)
	public String getInfo(@QueryParam("name") String name, @QueryParam("ownerName") String ownerName, @QueryParam("ownerLastname") String ownerLastname, @QueryParam("user") String user) throws ConnectException {
		
		String pivot = null;
		String pivotName = null;
		String pivotOwnerName = null;
		String pivotOwnerLastname = null;
		Document result = null;

		MongoCollection<Document> table = connectNow.getCollection(user);
		FindIterable<Document> findIterable = table.find();
		MongoCursor<Document> cursor = findIterable.iterator();
		
		while (cursor.hasNext()) {
			result = cursor.next();
			pivotName = result.get("name").toString();
			pivotOwnerName = result.get("ownerName").toString();
			pivotOwnerLastname = result.get("ownerLastname").toString();
			
			System.out.println(pivotName);
			System.out.println(pivotOwnerName);
			System.out.println(pivotOwnerLastname);		
			
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

	/* Returns one result */
	@GET
	@Path("/url")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getURL(String name, String ownerName, String 	ownerLastname, String user) {
		return "https://pets2018.herokuapp.com/rest/pet/info?name="+name+"&ownerName="+ownerName+"&ownerLastname="+ownerLastname+"&user="+user;
	}

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
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String getMessage() {
		return "Hello World";
	}

}
