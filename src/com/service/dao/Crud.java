package com.service.dao;

import org.bson.Document;

import com.mongodb.DBObject;
import com.service.model.Pet;

public interface Crud {
	
	String insertPet(String raze, String name, int age, String street1, String phone1, String phone2, String illness);
	Document getPet(String name, String value);
	Pet updatePet();
	void deletePet();

}
