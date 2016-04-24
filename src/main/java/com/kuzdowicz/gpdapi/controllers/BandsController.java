package com.kuzdowicz.gpdapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.gpdapi.models.domain.Band;
import com.kuzdowicz.gpdapi.repositories.BandsRepository;

@RestController
@RequestMapping("/bands")
public class BandsController {

	private BandsRepository bandsRepository;

	@Autowired
	public BandsController(BandsRepository bandsRepository) {
		this.bandsRepository = bandsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Band> getAllBands() {
		return bandsRepository.findAll();
	}

}
