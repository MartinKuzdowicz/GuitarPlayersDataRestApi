package com.kuzdowicz.gpdapi.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GUITAR_PLAYERS")
public class GuitarPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUITAR_PLAYER_ID")
	private Long guitarPlayerId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "AGE")
	private int age;

	@Column(name = "IS_ALIVE")
	private boolean heIsAlive;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name = "NATIONALITY")
	private String nationality;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "GUITAR_PLAYERS_AND_GUITARS_JOIN", //
			joinColumns = @JoinColumn(name = "GUITAR_PLAYER_ID"), //
			inverseJoinColumns = @JoinColumn(name = "MODEL_VERSION_NAME"))
	private List<Guitar> guitars;

	@Transient
	@JsonIgnore
	private String nameAndLastName;

	public void setTransientNameAndLastName() {
		this.nameAndLastName = this.name.trim() + " " + this.lastname.trim();
	}

	public Long getGuitarPlayerId() {
		return guitarPlayerId;
	}

	public void setGuitarPlayerId(Long guitarPlayerId) {
		this.guitarPlayerId = guitarPlayerId;
	}

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

	public boolean isHeIsAlive() {
		return heIsAlive;
	}

	public void setHeIsAlive(boolean heIsAlive) {
		this.heIsAlive = heIsAlive;
	}

	public List<Guitar> getGuitars() {
		if (guitars == null) {
			guitars = new ArrayList<>();
		}
		return guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNameAndLastName() {
		return nameAndLastName;
	}

	public void setNameAndLastName(String nameAndLastName) {
		this.nameAndLastName = nameAndLastName;
	}

}
