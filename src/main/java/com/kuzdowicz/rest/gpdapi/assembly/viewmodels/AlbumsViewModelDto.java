package com.kuzdowicz.rest.gpdapi.assembly.viewmodels;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.kuzdowicz.rest.gpdapi.assembly.resources.AlbumResource;

public class AlbumsViewModelDto extends ResourceSupport {

	private List<AlbumResource> albums;

	public List<AlbumResource> getAlbums() {
		return albums;
	}

	public void setAlbums(List<AlbumResource> albums) {
		this.albums = albums;
	}

}
