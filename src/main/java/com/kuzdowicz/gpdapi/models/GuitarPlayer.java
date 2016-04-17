package com.kuzdowicz.gpdapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GUITAR_PLAYER")
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

	@Column(name = "GUITAR_BRAND")
	private String guitarBrand;

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

	public String getGuitarBrand() {
		return guitarBrand;
	}

	public void setGuitarBrand(String guitarBrand) {
		this.guitarBrand = guitarBrand;
	}

}
