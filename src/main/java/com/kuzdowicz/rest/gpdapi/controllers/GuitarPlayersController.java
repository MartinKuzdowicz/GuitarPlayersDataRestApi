package com.kuzdowicz.rest.gpdapi.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.rest.gpdapi.assembly.assemblers.GuitarPlayerResourceAssembler;
import com.kuzdowicz.rest.gpdapi.assembly.resources.GuitarPlayerResource;
import com.kuzdowicz.rest.gpdapi.assembly.viewmodels.GuitarPlayersViewModelDto;
import com.kuzdowicz.rest.gpdapi.constants.Formats;
import com.kuzdowicz.rest.gpdapi.db.domain.Guitar;
import com.kuzdowicz.rest.gpdapi.db.domain.GuitarPlayer;
import com.kuzdowicz.rest.gpdapi.db.repositories.GuitarPlayersRepository;
import com.kuzdowicz.rest.gpdapi.db.repositories.GuitarsRepository;
import com.kuzdowicz.rest.gpdapi.dto.forms.AddGuitarPlayerForm;

@RestController
@RequestMapping("/guitar-players")
public class GuitarPlayersController {

	private final static Logger logger = LoggerFactory.getLogger(GuitarPlayersController.class);

	private final GuitarPlayersRepository guitarPlayersRepository;
	private final GuitarsRepository guitarsRepository;
	private final GuitarPlayerResourceAssembler guitarPlayerResourceAssembler;

	@Autowired
	public GuitarPlayersController(GuitarPlayersRepository guitarPlayersRepository, GuitarsRepository guitarsRepository,
			GuitarPlayerResourceAssembler guitarPlayerResourceAssembler) {
		this.guitarPlayersRepository = guitarPlayersRepository;
		this.guitarsRepository = guitarsRepository;
		this.guitarPlayerResourceAssembler = guitarPlayerResourceAssembler;
	}

	@RequestMapping(method = RequestMethod.GET)
	public GuitarPlayersViewModelDto getAllGuitarPlayers() {

		List<GuitarPlayerResource> guitarPlayers = guitarPlayerResourceAssembler
				.toResources(guitarPlayersRepository.findAll());

		GuitarPlayersViewModelDto gvm = new GuitarPlayersViewModelDto();
		gvm.setGuitarPlayers(guitarPlayers);
		gvm.add(linkTo(methodOn(GuitarPlayersController.class)//
				.getAllGuitarPlayers())//
						.withSelfRel());

		return gvm;
	}

	@RequestMapping(value = "/age/{ageVal}", method = RequestMethod.GET)
	public List<GuitarPlayer> getAllByAge(@PathVariable int ageVal) {
		return guitarPlayersRepository.findByAge(ageVal);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GuitarPlayerResource oneById(@PathVariable("id") Long id) {

		return guitarPlayerResourceAssembler.toResource(guitarPlayersRepository.findOne(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public GuitarPlayerResource addOne(@RequestBody AddGuitarPlayerForm addGuitarPlayerForm) {

		GuitarPlayer newGuitarPlayer = new GuitarPlayer();
		newGuitarPlayer.setName(addGuitarPlayerForm.getName());
		newGuitarPlayer.setLastname(addGuitarPlayerForm.getLastname());
		newGuitarPlayer.setAge(addGuitarPlayerForm.getAge());
		newGuitarPlayer.setHeIsAlive(addGuitarPlayerForm.getHeIsAlive());
		newGuitarPlayer.setNationality(addGuitarPlayerForm.getNationality());

		SimpleDateFormat dateFormatter = new SimpleDateFormat(Formats.GUITAR_PLAYER_DATE_FORMAT);
		try {
			newGuitarPlayer.setDateOfBirth(dateFormatter.parse(addGuitarPlayerForm.getDateOfBirth()));
		} catch (ParseException e) {
			logger.debug("Exception occured: ", e);
		}

		Guitar guitar = guitarsRepository.findOne(addGuitarPlayerForm.getGuitarId());
		newGuitarPlayer.setGuitars(Arrays.asList(guitar));
		GuitarPlayer savedGuitarPlayer = guitarPlayersRepository.save(newGuitarPlayer);

		return guitarPlayerResourceAssembler.toResource(savedGuitarPlayer);

	}

}
