package com.kuzdowicz.gpdapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.gpdapi.models.Composition;
import com.kuzdowicz.gpdapi.repositories.CompositionsRepository;

@RestController
@RequestMapping("/compositions")
public class CompositionsController {

	private CompositionsRepository compositionsRepository;

	@Autowired
	public CompositionsController(CompositionsRepository compositionsRepository) {
		this.compositionsRepository = compositionsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Composition> getAllCompositions() {
		return compositionsRepository.findAll();
	}

}
