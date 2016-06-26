package com.kuzdowicz.rest.gpdapi.assembly.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.kuzdowicz.rest.gpdapi.assembly.resources.AlbumResource;
import com.kuzdowicz.rest.gpdapi.controllers.AlbumsController;
import com.kuzdowicz.rest.gpdapi.db.domain.Album;

@Component
public class AlbumsResourceAssembler extends ResourceAssemblerSupport<Album, AlbumResource> {

	@Autowired
	private GuitarPlayerResourceAssembler guitarPlayerResourceAssembler;

	public AlbumsResourceAssembler() {
		super(AlbumsController.class, AlbumResource.class);
	}

	@Override
	public AlbumResource toResource(Album albumEntity) {

		AlbumResource ar = new AlbumResource();
		ar.setAuthors(guitarPlayerResourceAssembler.toResources(albumEntity.getAuthors()));
		ar.setTitle(albumEntity.getTitle());
		ar.setTracks(albumEntity.getTracks());

		ar.add(linkTo(methodOn(AlbumsController.class).getOneAlbumById(albumEntity.getAuthorAndTitle())).withSelfRel());
		ar.add(linkTo(methodOn(AlbumsController.class).getAllAlbums()).withRel("all-albums"));

		return ar;
	}

	@Override
	public List<AlbumResource> toResources(Iterable<? extends Album> albumsEntities) {
		return StreamSupport.stream(albumsEntities.spliterator(), false).map(a -> toResource(a))
				.collect(Collectors.toList());
	}

}
