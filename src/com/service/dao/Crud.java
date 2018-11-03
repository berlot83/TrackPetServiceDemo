package com.service.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.DBObject;
import com.service.model.Pet;

public interface Crud {
	
	String insertPet(String user,String raze, String name, int age, String ownerName, String ownerLastname, String ownerDni, String street1, String phone1, String phone2, String email, String facebook, String instagram, String dateAntiRabicVaccine, String datePolivalentVaccine, String dateSextupleVaccine, String dateOctupleVaccine, String clinicHistory, String illness, boolean medicated, boolean status, boolean subscription, String collection);
	Document getPet(String name, String value);
	Pet updatePet();
	void deletePet();

}
