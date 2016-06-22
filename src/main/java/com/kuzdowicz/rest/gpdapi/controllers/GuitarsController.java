package com.kuzdowicz.rest.gpdapi.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.rest.gpdapi.assembly.resources.GuitarsViewModelResourceDto;
import com.kuzdowicz.rest.gpdapi.db.domain.Guitar;
import com.kuzdowicz.rest.gpdapi.db.repositories.GuitarsRepository;

@RestController
@RequestMapping("/guitars")
public class GuitarsController {

	private final GuitarsRepository guitarsRepository;

	@Autowired
	public GuitarsController(GuitarsRepository guitarsRepository) {
		this.guitarsRepository = guitarsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<GuitarsViewModelResourceDto> getAllGuitars() {

		GuitarsViewModelResourceDto allGuitarsResourceDto = new GuitarsViewModelResourceDto();
		List<Guitar> allGuitars = guitarsRepository.findAll();
		allGuitars.forEach(g -> {
			g.add(linkTo(methodOn(GuitarsController.class).guitarById(g.getModelVersionName()))
					.withRel(g.getModelVersionName()));
		});
		allGuitarsResourceDto.setGuitars(allGuitars);
		allGuitarsResourceDto.add(linkTo(methodOn(GuitarsController.class).getAllGuitars()).withSelfRel());

		return new ResponseEntity<GuitarsViewModelResourceDto>(allGuitarsResourceDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public HttpEntity<Guitar> guitarById(@PathVariable("id") String id) {

		Guitar guitar = guitarsRepository.findOne(id);

		guitar.add(linkTo(methodOn(GuitarsController.class).guitarById(id)).withSelfRel());
		guitar.add(linkTo(methodOn(GuitarsController.class).getAllGuitars()).withRel("all-guitars"));

		return new ResponseEntity<Guitar>(guitar, HttpStatus.OK);
	}

}
