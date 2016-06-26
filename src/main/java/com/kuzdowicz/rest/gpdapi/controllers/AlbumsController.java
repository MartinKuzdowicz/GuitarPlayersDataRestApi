package com.kuzdowicz.rest.gpdapi.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.rest.gpdapi.assembly.assemblers.AlbumsResourceAssembler;
import com.kuzdowicz.rest.gpdapi.assembly.resources.AlbumResource;
import com.kuzdowicz.rest.gpdapi.assembly.viewmodels.AlbumsViewModelDto;
import com.kuzdowicz.rest.gpdapi.db.repositories.AlbumsRepository;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

	private final AlbumsRepository albumsRepository;
	private final AlbumsResourceAssembler albumsResourceAssembler;

	@Autowired
	public AlbumsController(AlbumsRepository albumsRepository, AlbumsResourceAssembler albumsResourceAssembler) {
		this.albumsRepository = albumsRepository;
		this.albumsResourceAssembler = albumsResourceAssembler;
	}

	@RequestMapping(method = RequestMethod.GET)
	public AlbumsViewModelDto getAllAlbums() {

		AlbumsViewModelDto avm = new AlbumsViewModelDto();
		avm.setAlbums(albumsResourceAssembler.toResources(albumsRepository.findAll()));

		avm.add(linkTo(methodOn(this.getClass()).getAllAlbums()).withSelfRel());

		return avm;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AlbumResource getOneAlbumById(@PathVariable("id") String authorAndTitle) {
		return albumsResourceAssembler.toResource(albumsRepository.findOne(authorAndTitle));

	}

}
