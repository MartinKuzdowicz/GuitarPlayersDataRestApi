package com.kuzdowicz.rest.gpdapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Guitar> getAllGuitars() {
		return guitarsRepository.findAll();
	}

}
