package com.kuzdowicz.rest.gpdapi.assembly.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.kuzdowicz.rest.gpdapi.assembly.resources.GuitarResource;
import com.kuzdowicz.rest.gpdapi.controllers.GuitarsController;
import com.kuzdowicz.rest.gpdapi.db.domain.Guitar;

@Component
public class GuitarResourceAssembler extends ResourceAssemblerSupport<Guitar, GuitarResource> {

	public GuitarResourceAssembler() {
		super(GuitarsController.class, GuitarResource.class);
	}

	@Override
	public GuitarResource toResource(Guitar guitarEntity) {

		GuitarResource guitarResource = new GuitarResource();
		guitarResource.setModelVersionName(guitarEntity.getModelVersionName());
		guitarResource.setModelName(guitarEntity.getModelName());
		guitarResource.setBrand(guitarEntity.getBrand());
		guitarResource.setType(guitarEntity.getType());
		guitarResource.setAvgPrice(guitarEntity.getAvgPrice());

		guitarResource.add(
				linkTo(methodOn(GuitarsController.class).guitarById(guitarEntity.getModelVersionName())).withSelfRel());
		guitarResource.add(linkTo(methodOn(GuitarsController.class).getAllGuitars()).withRel("all-guitars"));

		return guitarResource;
	}

	@Override
	public List<GuitarResource> toResources(Iterable<? extends Guitar> entities) {

		return StreamSupport.stream(entities.spliterator(), false).map(g -> {
			return toResource(g);
		}).collect(Collectors.toList());
	}
}
