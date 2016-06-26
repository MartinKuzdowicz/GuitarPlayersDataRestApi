package com.kuzdowicz.rest.gpdapi.db.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUMS")
public class Album implements IDomainPKeySetable {

	@Column(name = "TITLE")
	private String title;

	@Id
	@Column(name = "ALBUM_ID")
	private String authorAndTitle;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ALBUMS_AUTHORS_JOIN", //
			joinColumns = @JoinColumn(name = "ALBUM_ID"), //
			inverseJoinColumns = @JoinColumn(name = "GUITAR_PLAYER_ID"))
	private List<GuitarPlayer> authors;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ALBUM_ID")
	private List<Composition> tracks;

	@Override
	public void generateAndSetPrimaryKey() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < this.authors.size(); i++) {
			GuitarPlayer author = authors.get(i);
			sb.append(author.getName().trim() + " " + //
					author.getLastname().trim());
			if (i > 0 && i != authors.size() - 1) {
				sb.append(", ");
			}
		}

		sb.append("(" + this.title + ")");

		this.authorAndTitle = sb.toString();
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

	public List<Composition> getTracks() {
		if (tracks == null) {
			tracks = new ArrayList<>();
		}
		return tracks;
	}

	public void setTracks(List<Composition> tracks) {
		this.tracks = tracks;
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

}
