package com.kuzdowicz.gpdapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.gpdapi.models.domain.Guitar;
import com.kuzdowicz.gpdapi.repositories.GuitarsRepository;

@RestController
@RequestMapping("/guitars")
public class GuitarsController {

	private GuitarsRepository guitarsRepository;

	@Autowired
	public GuitarsController(GuitarsRepository guitarsRepository) {
		this.guitarsRepository = guitarsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Guitar> getAllGuitars() {
		return guitarsRepository.findAll();
	}

}
