package com.kuzdowicz.rest.gpdapi.assembly.viewmodels;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.kuzdowicz.rest.gpdapi.assembly.resources.CompositionResource;

public class CompositionsViewModelDto extends ResourceSupport {

	private List<CompositionResource> compositions;

	public List<CompositionResource> getCompositions() {
		return compositions;
	}

	public void setCompositions(List<CompositionResource> compositions) {
		this.compositions = compositions;
	}

}
