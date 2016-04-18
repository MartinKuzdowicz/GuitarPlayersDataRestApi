package com.kuzdowicz.gpdapi.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.gpdapi.constants.GuitarType;
import com.kuzdowicz.gpdapi.models.Brand;
import com.kuzdowicz.gpdapi.models.Guitar;
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

	@RequestMapping("/init-test-data")
	public void initTestData() {
		
		
		Brand fenderBrand = new Brand();
		fenderBrand.setName("Fender");
		fenderBrand.setWebSite("https://www.fender.com");
		
		Brand gibsonBrand = new Brand();
		gibsonBrand.setName("Gibson");
		gibsonBrand.setWebSite("https://www.gibson.com");
		
		Guitar stratocaster = new Guitar();
		stratocaster.setType(GuitarType.ELECTRIC_SOLID_BODY);
		stratocaster.setModelName("Stratocatser");
		stratocaster.setBrand(fenderBrand);
		stratocaster.setAvgPrice(new BigDecimal("2500.99"));
		
		Guitar lesPaul = new Guitar();
		lesPaul.setType(GuitarType.ELECTRIC_SOLID_BODY);
		lesPaul.setModelName("Les Paul");
		lesPaul.setBrand(gibsonBrand);
		lesPaul.setAvgPrice(new BigDecimal("4500.99"));
	
		GuitarPlayer santana = new GuitarPlayer();
		santana.setName("Carlos");
		santana.setLastname("Santana");
		santana.setAge(72);
		santana.setHeIsAlive(true);
		santana.getGuitars().add(lesPaul);

		GuitarPlayer hendrix = new GuitarPlayer();
		hendrix.setName("Jimi");
		hendrix.setLastname("Hendrix");
		hendrix.setAge(28);
		hendrix.setHeIsAlive(false);
		hendrix.getGuitars().add(stratocaster);

		GuitarPlayer blackmore = new GuitarPlayer();
		hendrix.setName("Ritchie");
		hendrix.setLastname("Blackmore");
		hendrix.setAge(28);
		hendrix.setHeIsAlive(false);
		blackmore.getGuitars().add(stratocaster);
		blackmore.getGuitars().add(lesPaul);

		List<GuitarPlayer> guitarPlayers = new ArrayList<>();
		guitarPlayers.add(santana);
		guitarPlayers.add(hendrix);
		guitarPlayers.add(blackmore);

		guitarPlayersRepository.save(guitarPlayers);

	}

}
