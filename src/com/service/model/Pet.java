package com.service.model;

public class Pet {
	private String raze;
	private String name;
	private int age;
	private String ownerName;
	private String ownerLastname;
	private String ownerDni;
	private String street1;
	private String phone1;
	private String phone2;
	private String clinicHistory;
	private String illness;
	private boolean medicated;
	private boolean status;
	private boolean subscription;
	
	public Pet() {
		
	}
	
	public Pet(String raze, String name, int age, String ownerName, String ownerLastname, String ownerDni, String street1, String phone1, String phone2, String clinicHistory,  String illness, boolean medicated, boolean status, boolean subscription) {
		this.raze = raze;
		this.name = name;
		this.age = age;
		this.ownerName = ownerName;
		this.ownerLastname = ownerLastname;
		this.ownerDni = ownerDni;
		this.street1 = street1;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.clinicHistory = clinicHistory;
		this.illness = illness;
		this.medicated = medicated;
		this.status = status;
		this.subscription = subscription;
	}

	public String getRaze() {
		return raze;
	}

	public void setRaze(String raze) {
		this.raze = raze;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getClinicHistory() {
		return clinicHistory;
	}

	public void setClinicHistory(String clinicHistory) {
		this.clinicHistory = clinicHistory;
	}

	public boolean isMedicated() {
		return medicated;
	}

	public void setMedicated(boolean medicated) {
		this.medicated = medicated;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerLastname() {
		return ownerLastname;
	}

	public void setOwnerLastname(String ownerLastname) {
		this.ownerLastname = ownerLastname;
	}

	public String getOwnerDni() {
		return ownerDni;
	}

	public void setOwnerDni(String ownerDni) {
		this.ownerDni = ownerDni;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}
}
