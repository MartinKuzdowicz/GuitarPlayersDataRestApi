package com.kuzdowicz.rest.gpdapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.kuzdowicz.rest.gpdapi.assembly.assemblers.CompositionsResourceAssembler;
import com.kuzdowicz.rest.gpdapi.assembly.resources.CompositionResource;
import com.kuzdowicz.rest.gpdapi.assembly.viewmodels.CompositionsViewModelDto;
import com.kuzdowicz.rest.gpdapi.db.repositories.CompositionsRepository;

@RestController
@RequestMapping("/compositions")
public class CompositionsController {

	private final CompositionsRepository compositionsRepository;
	private final CompositionsResourceAssembler compositionsResourceAssembler;

	@Autowired
	public CompositionsController(CompositionsRepository compositionsRepository,
			CompositionsResourceAssembler compositionsResourceAssembler) {
		this.compositionsRepository = compositionsRepository;
		this.compositionsResourceAssembler = compositionsResourceAssembler;
	}

	@RequestMapping(method = RequestMethod.GET)
	public CompositionsViewModelDto getAllCompositions() {

		CompositionsViewModelDto cvm = new CompositionsViewModelDto();
		cvm.setCompositions(compositionsResourceAssembler.toResources(compositionsRepository.findAll()));
		cvm.add(linkTo(methodOn(this.getClass()).getAllCompositions()).withSelfRel());

		return cvm;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CompositionResource getOneCompositionById(@PathVariable("id") String albumNameAndTrackTitle) {
		return compositionsResourceAssembler.toResource(compositionsRepository.findOne(albumNameAndTrackTitle));

	}

	@RequestMapping(method = RequestMethod.GET, value = "/titels")
	public List<String> getAllCompositionsTitels() {
		return compositionsRepository.findAll().stream().map(el -> {
			return el.getTitle();
		}).collect(Collectors.toList());
	}

}
