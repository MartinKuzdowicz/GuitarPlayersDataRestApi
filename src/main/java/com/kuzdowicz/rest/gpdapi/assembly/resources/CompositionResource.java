package com.kuzdowicz.rest.gpdapi.assembly.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class CompositionResource extends ResourceSupport {

	private String title;
	@JsonIgnoreProperties({ "guitars" })
	private List<GuitarPlayerResource> authors;
	private Double duration;
	private String albumTitle;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<GuitarPlayerResource> getAuthors() {
		return authors;
	}

	public void setAuthors(List<GuitarPlayerResource> authors) {
		this.authors = authors;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

}
