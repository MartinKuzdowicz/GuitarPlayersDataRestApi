package com.kuzdowicz.rest.gpdapi.assembly.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class AlbumResource extends ResourceSupport {

	private String title;
	private List<CompositionResource> tracks;
	@JsonIgnoreProperties({ "guitars" })
	private List<GuitarPlayerResource> authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CompositionResource> getTracks() {
		return tracks;
	}

	public void setTracks(List<CompositionResource> tracks) {
		this.tracks = tracks;
	}

	public List<GuitarPlayerResource> getAuthors() {
		return authors;
	}

	public void setAuthors(List<GuitarPlayerResource> authors) {
		this.authors = authors;
	}

}
