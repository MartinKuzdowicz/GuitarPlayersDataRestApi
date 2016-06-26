package com.kuzdowicz.rest.gpdapi.db.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BANDS")
public class Band {

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "NATIONALITY")
	private String nationality;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "DATE_OF_DISOLUTION")
	private Date dateOfDisolution;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "BANDS_AND_GUITAR_PLAYERS_JOIN", //
			joinColumns = @JoinColumn(name = "NAME"), //
			inverseJoinColumns = @JoinColumn(name = "GUITAR_PLAYER_ID"))
	private List<GuitarPlayer> guitarPlayers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDateOfDisolution() {
		return dateOfDisolution;
	}

	public void setDateOfDisolution(Date dateOfDisolution) {
		this.dateOfDisolution = dateOfDisolution;
	}

	public List<GuitarPlayer> getGuitarPlayers() {
		if (guitarPlayers == null) {
			guitarPlayers = new ArrayList<>();
		}
		return guitarPlayers;
	}

	public void setGuitarPlayers(List<GuitarPlayer> guitarPlayers) {
		this.guitarPlayers = guitarPlayers;
	}

}
