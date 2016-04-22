package com.kuzdowicz.gpdapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "COMPOSITIONS")
public class Composition implements IDomainPKeySetable {

	public Composition() {
	}

	public Composition(String title) {
		this.title = title;
	}

	@Column(name = "TITLE")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ALBUM_ID")
	@JsonBackReference
	private Album album;

	@Id
	@Column(name = "COMPOSITION_ID")
	@JsonIgnore
	private String albumNameAndTrackTitle;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "GUITAR_PLAYERS_COMPOSITIONS_JOIN", //
	joinColumns = @JoinColumn(name = "COMPOSITION_ID"),//
	inverseJoinColumns = @JoinColumn(name = "GUITAR_PLAYER_ID"))
	@JsonIgnoreProperties({ "guitars" })
	private List<GuitarPlayer> authors;

	@Override
	public void generateAndSetPrimaryKey() {

		this.albumNameAndTrackTitle = this.album.getTitle().trim() + "(" + this.title + ")";

	}

	public String getAlbumNameAndTrackTitle() {
		return albumNameAndTrackTitle;
	}

	public void setAlbumNameAndTrackTitle(String albumNameAndTrackTitle) {
		this.albumNameAndTrackTitle = albumNameAndTrackTitle;
	}

	public String getTitle() {
		return title;
	}

	public List<GuitarPlayer> getAuthors() {
		if (authors == null) {
			authors = new ArrayList<>();
		}
		return authors;
	}

	public void setAuthors(List<GuitarPlayer> authors) {
		this.authors = authors;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

}
