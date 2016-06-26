package com.kuzdowicz.rest.gpdapi.assembly.resources;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Relation(value = "guitarPlayer", collectionRelation = "guitarPlayers")
@JsonInclude(Include.NON_EMPTY)
public class GuitarPlayerResource extends ResourceSupport {

	private String name;
	private String lastname;
	private int age;
	private Date dateOfBirth;
	private Date dateOfDeath;
	private String nationality;
	private List<GuitarResource> guitars;

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<GuitarResource> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<GuitarResource> guitars) {
		this.guitars = guitars;
	}

}
