package com.kuzdowicz.rest.gpdapi.assembly.viewmodels;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.kuzdowicz.rest.gpdapi.assembly.resources.GuitarResource;

public class GuitarsViewModelDto extends ResourceSupport {

	private List<GuitarResource> guitars;

	public List<GuitarResource> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<GuitarResource> guitars) {
		this.guitars = guitars;
	}

}
