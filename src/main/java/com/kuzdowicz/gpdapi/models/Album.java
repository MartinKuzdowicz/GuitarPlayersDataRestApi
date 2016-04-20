package com.kuzdowicz.gpdapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ALBUMS")
public class Album implements IDomainPKeySetable {

	@Column(name = "TITLE")
	private String title;

	@Id
	@Column(name = "ALBUM_ID")
	@JsonIgnore
	private String authorAndTitle;

	public void setTransientAuthor() {
		if (this.singleAuthor != null) {
			this.author = singleAuthor.getName();
		}

		if (this.bandAuthor != null) {
			this.author = bandAuthor.getName();
		}
	}

	@Transient
	@JsonIgnore
	private String author;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GUITAR_PLAYER_ID")
	private GuitarPlayer singleAuthor;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NAME")
	private Band bandAuthor;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ALBUM_ID")
	@JsonManagedReference
	private List<Composition> tracks;

	@Override
	public void generateAndSetPrimaryKey() {

		String key = "";

		if (this.singleAuthor != null) {

			key = this.singleAuthor.getName().trim() + " " + //
					this.singleAuthor.getLastname().trim() + "(" + this.title + ")";
		}

		if (this.bandAuthor != null) {

			key = this.bandAuthor.getName().trim() + //
					"(" + this.title + ")";
		}

		this.authorAndTitle = key;
	}

	public String getAuthorAndTitle() {
		return authorAndTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GuitarPlayer getSingleAuthor() {
		return singleAuthor;
	}

	public void setSingleAuthor(GuitarPlayer singleAuthor) {
		this.singleAuthor = singleAuthor;
	}

	public Band getBandAuthor() {
		return bandAuthor;
	}

	public void setBandAuthor(Band bandAuthor) {
		this.bandAuthor = bandAuthor;
	}

	public List<Composition> getTracks() {

		if (tracks == null) {
			tracks = new ArrayList<>();
		}

		return tracks;
	}

	public void setTracks(List<Composition> tracks) {
		this.tracks = tracks;
	}

	public String getAuthor() {
		return author;
	}

}
