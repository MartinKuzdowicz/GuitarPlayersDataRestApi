package com.kuzdowicz.rest.gpdapi.assembly.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kuzdowicz.rest.gpdapi.db.domain.Composition;

public class AlbumResource extends ResourceSupport {

	private String title;
	private List<Composition> tracks;
	@JsonIgnoreProperties({ "guitars" })
	private List<GuitarPlayerResource> authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Composition> getTracks() {
		return tracks;
	}

	public void setTracks(List<Composition> tracks) {
		this.tracks = tracks;
	}

	public List<GuitarPlayerResource> getAuthors() {
		return authors;
	}

	public void setAuthors(List<GuitarPlayerResource> authors) {
		this.authors = authors;
	}

}
