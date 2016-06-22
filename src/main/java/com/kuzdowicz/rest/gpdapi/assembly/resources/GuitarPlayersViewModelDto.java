package com.kuzdowicz.rest.gpdapi.assembly.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.kuzdowicz.rest.gpdapi.db.domain.GuitarPlayer;

public class GuitarPlayersViewModelDto extends ResourceSupport {

	private List<GuitarPlayer> guitarPlayers;

	public List<GuitarPlayer> getGuitarPlayers() {
		return guitarPlayers;
	}

	public void setGuitarPlayers(List<GuitarPlayer> guitarPlayers) {
		this.guitarPlayers = guitarPlayers;
	}

}
