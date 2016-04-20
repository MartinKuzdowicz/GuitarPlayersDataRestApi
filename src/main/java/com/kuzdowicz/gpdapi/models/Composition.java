package com.kuzdowicz.gpdapi.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Id
	@Column(name = "COMPOSITION_ID")
	@JsonIgnore
	private String albumNameAndTrackTitle;

	@OneToMany
	@JoinColumn(name = "COMPOSITION_ID")
	private List<GuitarPlayer> authors;

	@ManyToOne
	@JoinColumn(name = "ALBUM_ID")
	@JsonBackReference
	private Album album;

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
