package com.service.dao;

import com.mongodb.DBObject;
import com.service.model.Pet;

public interface Crud {
	
	String insertPet(String raze, String name, int age, String street1, String street2, String city, String phone1, String phone2, String illness);
	DBObject getPet(String name, String value);
	Pet updatePet();
	void deletePet();

}
