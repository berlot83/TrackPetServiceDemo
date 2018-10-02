package com.service.dao;

import org.bson.Document;

import com.mongodb.DBObject;
import com.service.model.Pet;

public interface Crud {
	
	String insertPet(String user,String raze, String name, int age, String ownerName, String ownerLastname, String ownerDni, String street1, String phone1, String phone2, String clinicHistory, String illness, boolean medicated, boolean status, boolean subscription, String collection);
	Document getPet(String name, String value);
	Pet updatePet();
	void deletePet();

}
