package com.kuzdowicz.gpdapi.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.gpdapi.constants.GuitarType;
import com.kuzdowicz.gpdapi.models.Band;
import com.kuzdowicz.gpdapi.models.ProductBrand;
import com.kuzdowicz.gpdapi.models.Guitar;
import com.kuzdowicz.gpdapi.models.GuitarPlayer;
import com.kuzdowicz.gpdapi.repositories.BandsRepository;
import com.kuzdowicz.gpdapi.repositories.GuitarPlayersRepository;

@RestController
@RequestMapping("/init")
public class InitDataController {

	private GuitarPlayersRepository guitarPlayersRepository;

	private BandsRepository bandsRepository;

	@Autowired
	public InitDataController(GuitarPlayersRepository guitarPlayersRepository, BandsRepository bandsRepository) {
		this.guitarPlayersRepository = guitarPlayersRepository;
		this.bandsRepository = bandsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initTestData() {

		ProductBrand fenderBrand = new ProductBrand();
		fenderBrand.setName("Fender");
		fenderBrand.setWebSite("https://www.fender.com");

		ProductBrand gibsonBrand = new ProductBrand();
		gibsonBrand.setName("Gibson");
		gibsonBrand.setWebSite("https://www.gibson.com");

		Guitar stratocaster = new Guitar();
		stratocaster.setType(GuitarType.ELECTRIC_SOLID_BODY);
		stratocaster.setModelName("Stratocatser");
		stratocaster.setAvgPrice(new BigDecimal("2500.99"));
		stratocaster.setModelVersionName("50 anniversary v001");
		stratocaster.setBrand(fenderBrand);

		Guitar lesPaul = new Guitar();
		lesPaul.setType(GuitarType.ELECTRIC_SOLID_BODY);
		lesPaul.setModelName("Les Paul");
		lesPaul.setAvgPrice(new BigDecimal("4500.99"));
		lesPaul.setModelVersionName("59");
		lesPaul.setBrand(gibsonBrand);

		GuitarPlayer santana = new GuitarPlayer();
		santana.setName("Carlos");
		santana.setLastname("Santana");
		santana.setAge(72);
		santana.setHeIsAlive(true);
		DateTime dt = new DateTime();
		dt.withYear(1955);
		dt.withMonthOfYear(03);
		dt.withDayOfMonth(1);
		santana.setDateOfBirth(dt.toDate());
		santana.getGuitars().add(lesPaul);
		santana.setNationality("MEXICO");

		GuitarPlayer hendrix = new GuitarPlayer();
		hendrix.setName("Jimi");
		hendrix.setLastname("Hendrix");
		hendrix.setAge(28);
		hendrix.setHeIsAlive(false);
		DateTime dt2 = new DateTime();
		dt2.withYear(1965);
		dt2.withMonthOfYear(10);
		dt2.withDayOfMonth(2);
		hendrix.setDateOfBirth(dt2.toDate());
		hendrix.getGuitars().add(stratocaster);
		hendrix.setNationality("USA");

		List<GuitarPlayer> guitarPlayers = new ArrayList<>();
		guitarPlayers.add(santana);
		guitarPlayers.add(hendrix);
		
		guitarPlayersRepository.save(guitarPlayers);

		Band hendrixSantatnaBand = new Band();
		hendrixSantatnaBand.setName("Cool Band");
		hendrixSantatnaBand.setCreationDate(DateTime.now().toDate());
		hendrixSantatnaBand.setNationality("Poland");

		hendrixSantatnaBand.setGuitarPlayers(guitarPlayers);

		bandsRepository.save(hendrixSantatnaBand);

		

		return "DATA INITALIZED SUCCESSFUL !!!";

	}

}
