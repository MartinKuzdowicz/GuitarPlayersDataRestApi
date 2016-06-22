package com.kuzdowicz.rest.gpdapi.assembly.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.kuzdowicz.rest.gpdapi.db.domain.Guitar;

public class GuitarsViewModelResourceDto extends ResourceSupport {

	private List<Guitar> guitars;

	public List<Guitar> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

}
