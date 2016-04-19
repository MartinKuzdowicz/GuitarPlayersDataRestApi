package com.kuzdowicz.gpdapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.gpdapi.models.GuitarPlayer;
import com.kuzdowicz.gpdapi.repositories.GuitarPlayersRepository;

@RestController
@RequestMapping("/guitar-players")
public class GuitarPlayersController {

	private GuitarPlayersRepository guitarPlayersRepository;

	@Autowired
	public GuitarPlayersController(GuitarPlayersRepository guitarPlayersRepository) {
		this.guitarPlayersRepository = guitarPlayersRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<GuitarPlayer> getAllGuitarPlayers() {
		return guitarPlayersRepository.findAll();
	}

	@RequestMapping(value = "/age/{ageVal}", method = RequestMethod.GET)
	public List<GuitarPlayer> getAllByAge(@PathVariable int ageVal) {
		return guitarPlayersRepository.findByAge(ageVal);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addOne(@RequestBody GuitarPlayer newGuitarPlayer) {

		guitarPlayersRepository.save(newGuitarPlayer);

	}

}
