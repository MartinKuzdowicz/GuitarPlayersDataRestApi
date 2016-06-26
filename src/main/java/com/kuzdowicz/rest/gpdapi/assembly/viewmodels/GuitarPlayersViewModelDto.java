package com.kuzdowicz.rest.gpdapi.assembly.viewmodels;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.kuzdowicz.rest.gpdapi.assembly.resources.GuitarPlayerResource;

public class GuitarPlayersViewModelDto extends ResourceSupport {

	private List<GuitarPlayerResource> guitarPlayers;

	public List<GuitarPlayerResource> getGuitarPlayers() {
		return guitarPlayers;
	}

	public void setGuitarPlayers(List<GuitarPlayerResource> guitarPlayers) {
		this.guitarPlayers = guitarPlayers;
	}

}
