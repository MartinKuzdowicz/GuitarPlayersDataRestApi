package com.kuzdowicz.gpdapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping(method = RequestMethod.POST)
	public void addOne(@RequestBody GuitarPlayer newGuitarPlayer) {

		guitarPlayersRepository.save(newGuitarPlayer);

	}

	@RequestMapping("/init-test-data")
	public void initTestData() {

		GuitarPlayer santana = new GuitarPlayer();
		santana.setName("Carlos");
		santana.setLastname("Santana");
		santana.setAge(72);
		santana.setGuitarBrand("PRS");
		santana.setHeIsAlive(true);

		GuitarPlayer hendrix = new GuitarPlayer();
		hendrix.setName("Jimi");
		hendrix.setLastname("Hendrix");
		hendrix.setAge(28);
		hendrix.setGuitarBrand("Fender");
		hendrix.setHeIsAlive(false);

		List<GuitarPlayer> initList = new ArrayList<>();
		initList.add(santana);
		initList.add(hendrix);

		guitarPlayersRepository.save(initList);

	}

}
