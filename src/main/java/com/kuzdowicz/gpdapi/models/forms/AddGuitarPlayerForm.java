package com.kuzdowicz.gpdapi.models.forms;

public class AddGuitarPlayerForm {

	private String name;

	private String lastname;

	private int age;

	private boolean heIsAlive;

	private String dateOfBirth;

	private String dateOfDeath;

	private String nationality;

	private String guitarId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean getHeIsAlive() {
		return heIsAlive;
	}

	public void setHeIsAlive(boolean heIsAlive) {
		this.heIsAlive = heIsAlive;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGuitarId() {
		return guitarId;
	}

	public void setGuitarId(String guitarId) {
		this.guitarId = guitarId;
	}

}
