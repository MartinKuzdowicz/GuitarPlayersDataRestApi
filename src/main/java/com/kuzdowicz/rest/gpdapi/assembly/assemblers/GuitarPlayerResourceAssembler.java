package com.kuzdowicz.rest.gpdapi.assembly.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.kuzdowicz.rest.gpdapi.assembly.resources.GuitarPlayerResource;
import com.kuzdowicz.rest.gpdapi.assembly.viewmodels.GuitarPlayersViewModelDto;
import com.kuzdowicz.rest.gpdapi.controllers.GuitarPlayersController;
import com.kuzdowicz.rest.gpdapi.db.domain.GuitarPlayer;

@Component
public class GuitarPlayerResourceAssembler extends ResourceAssemblerSupport<GuitarPlayer, GuitarPlayerResource> {

	@Autowired
	private GuitarResourceAssembler guitarResourceAssembler;

	public GuitarPlayerResourceAssembler() {

		super(GuitarPlayersController.class, GuitarPlayerResource.class);
	}

	@Override
	public GuitarPlayerResource toResource(GuitarPlayer gpEntity) {

		GuitarPlayerResource guitarPlayerResource = new GuitarPlayerResource();
		guitarPlayerResource.setName(gpEntity.getName());
		guitarPlayerResource.setLastname(gpEntity.getLastname());
		guitarPlayerResource.setAge(gpEntity.getAge());
		guitarPlayerResource.setDateOfBirth(gpEntity.getDateOfBirth());
		guitarPlayerResource.setDateOfDeath(gpEntity.getDateOfDeath());
		guitarPlayerResource.setNationality(gpEntity.getNationality());
		guitarPlayerResource.setGuitars(guitarResourceAssembler.toResources(gpEntity.getGuitars()));

		guitarPlayerResource.add(linkTo(methodOn(GuitarPlayersController.class)//
				.oneById(gpEntity.getGuitarPlayerId()))//
						.withSelfRel());
		guitarPlayerResource.add(linkTo(methodOn(GuitarPlayersController.class)//
				.getAllGuitarPlayers())//
						.withRel("all-guitar-players"));

		return guitarPlayerResource;
	}

	@Override
	public List<GuitarPlayerResource> toResources(Iterable<? extends GuitarPlayer> entities) {
		List<GuitarPlayerResource> gprList = new ArrayList<>();
		entities.forEach(gp -> {
			gprList.add(toResource(gp));
		});
		return gprList;
	}

	public GuitarPlayersViewModelDto toGuitarPlayersViewModel(Iterable<? extends GuitarPlayer> entities) {
		GuitarPlayersViewModelDto gvm = new GuitarPlayersViewModelDto();
		gvm.setGuitarPlayers(toResources(entities));
		gvm.add(linkTo(methodOn(GuitarPlayersController.class)//
				.getAllGuitarPlayers())//
						.withSelfRel());
		return gvm;

	}

}
