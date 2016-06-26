package com.kuzdowicz.rest.gpdapi.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.rest.gpdapi.assembly.assemblers.GuitarResourceAssembler;
import com.kuzdowicz.rest.gpdapi.assembly.resources.GuitarResource;
import com.kuzdowicz.rest.gpdapi.assembly.viewmodels.GuitarsViewModelDto;
import com.kuzdowicz.rest.gpdapi.db.repositories.GuitarsRepository;

@RestController
@RequestMapping(value = "/guitars", produces = MediaType.APPLICATION_JSON_VALUE)
public class GuitarsController {

	private final GuitarsRepository guitarsRepository;
	private final GuitarResourceAssembler guitarResourceAssembler;

	@Autowired
	public GuitarsController(GuitarsRepository guitarsRepository, GuitarResourceAssembler guitarResourceAssembler) {
		this.guitarsRepository = guitarsRepository;
		this.guitarResourceAssembler = guitarResourceAssembler;
	}

	@RequestMapping(method = RequestMethod.GET)
	public GuitarsViewModelDto getAllGuitars() {

		GuitarsViewModelDto allGuitarsResourceDto = new GuitarsViewModelDto();
		allGuitarsResourceDto.setGuitars(guitarResourceAssembler.toResources(guitarsRepository.findAll()));

		allGuitarsResourceDto.add(linkTo(methodOn(GuitarsController.class).getAllGuitars()).withSelfRel());

		return allGuitarsResourceDto;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GuitarResource guitarById(@PathVariable("id") String id) {

		return guitarResourceAssembler.toResource(guitarsRepository.findOne(id));
	}

}
