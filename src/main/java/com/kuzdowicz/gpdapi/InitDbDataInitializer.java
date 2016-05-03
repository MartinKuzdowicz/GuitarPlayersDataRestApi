package com.kuzdowicz.gpdapi;

import java.math.BigDecimal;
import java.util.Arrays;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kuzdowicz.gpdapi.constants.GuitarType;
import com.kuzdowicz.gpdapi.models.domain.Album;
import com.kuzdowicz.gpdapi.models.domain.Band;
import com.kuzdowicz.gpdapi.models.domain.Composition;
import com.kuzdowicz.gpdapi.models.domain.Guitar;
import com.kuzdowicz.gpdapi.models.domain.GuitarPlayer;
import com.kuzdowicz.gpdapi.models.domain.ProductBrand;
import com.kuzdowicz.gpdapi.repositories.AlbumsRepository;
import com.kuzdowicz.gpdapi.repositories.BandsRepository;
import com.kuzdowicz.gpdapi.repositories.GuitarPlayersRepository;

@Component
public class InitDbDataInitializer {

	private GuitarPlayersRepository guitarPlayersRepository;
	private BandsRepository bandsRepository;
	private AlbumsRepository albumsRepository;

	@Autowired
	public InitDbDataInitializer(GuitarPlayersRepository guitarPlayersRepository, BandsRepository bandsRepository,
			AlbumsRepository albumsRepository) {
		this.guitarPlayersRepository = guitarPlayersRepository;
		this.bandsRepository = bandsRepository;
		this.albumsRepository = albumsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initTestData() {

		ProductBrand fenderBrand = new ProductBrand();
		fenderBrand.setName("Fender");
		fenderBrand.setWebSite("https://www.fender.com");
		fenderBrand.setCountryOfOrigin("USA");

		ProductBrand gibsonBrand = new ProductBrand();
		gibsonBrand.setName("Gibson");
		gibsonBrand.setWebSite("https://www.gibson.com");
		gibsonBrand.setCountryOfOrigin("USA");

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

		guitarPlayersRepository.save(Arrays.asList(santana, hendrix));

		Band hendrixSantatnaBand = new Band();
		hendrixSantatnaBand.setName("Cool Band");
		hendrixSantatnaBand.setCreationDate(DateTime.now().toDate());
		hendrixSantatnaBand.setNationality("Poland");

		hendrixSantatnaBand.setGuitarPlayers(Arrays.asList(santana, hendrix));

		bandsRepository.save(hendrixSantatnaBand);

		Album santanaAbraxas = new Album();
		santanaAbraxas.getAuthors().add(santana);
		santanaAbraxas.setTitle("Abraxas");
		santanaAbraxas.generateAndSetPrimaryKey();

		Album electricLadyLand = new Album();
		electricLadyLand.getAuthors().add(hendrix);
		electricLadyLand.setTitle("Electric Ladyland");
		electricLadyLand.generateAndSetPrimaryKey();

		Composition voodooChile = new Composition("voodoo chile");
		voodooChile.setAuthors(Arrays.asList(hendrix));
		voodooChile.setAlbum(electricLadyLand);
		voodooChile.generateAndSetPrimaryKey();
		voodooChile.setDuration(4.66);

		Composition sambaPaTi = new Composition("samba pa ti");
		sambaPaTi.setAuthors(Arrays.asList(santana));
		sambaPaTi.setAlbum(santanaAbraxas);
		sambaPaTi.generateAndSetPrimaryKey();
		sambaPaTi.setDuration(3.59);

		Composition blackMagicWoman = new Composition("Black Magic Woman/Gypsy Queen");
		blackMagicWoman.setAuthors(Arrays.asList(santana));
		blackMagicWoman.setAlbum(santanaAbraxas);
		blackMagicWoman.generateAndSetPrimaryKey();
		blackMagicWoman.setDuration(2.40);

		santanaAbraxas.setTracks(Arrays.asList(sambaPaTi, blackMagicWoman));

		electricLadyLand.setTracks(Arrays.asList(voodooChile));

		albumsRepository.save(Arrays.asList(santanaAbraxas, electricLadyLand));

		return "DATA INITALIZED SUCCESSFUL !!!";

	}

}
