package com.kuzdowicz.rest.gpdapi.assembly.assemblers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.kuzdowicz.rest.gpdapi.assembly.resources.CompositionResource;
import com.kuzdowicz.rest.gpdapi.controllers.CompositionsController;
import com.kuzdowicz.rest.gpdapi.db.domain.Composition;

@Component
public class CompositionsResourceAssembler extends ResourceAssemblerSupport<Composition, CompositionResource> {

	@Autowired
	private GuitarPlayerResourceAssembler guitarPlayerResourceAssembler;

	public CompositionsResourceAssembler() {
		super(CompositionsController.class, CompositionResource.class);
	}

	@Override
	public CompositionResource toResource(Composition compositionEntity) {

		CompositionResource cr = new CompositionResource();
		cr.setAlbumTitle(compositionEntity.getAlbum().getTitle());
		cr.setAuthors(guitarPlayerResourceAssembler.toResources(compositionEntity.getAuthors()));
		cr.setTitle(compositionEntity.getTitle());
		cr.setDuration(compositionEntity.getDuration());

		cr.add(linkTo(methodOn(CompositionsController.class)
				.getOneCompositionById(compositionEntity.getAlbumNameAndTrackTitle())).withSelfRel());
		cr.add(linkTo(methodOn(CompositionsController.class).getAllCompositions()).withRel("all-compositions"));

		return cr;
	}

	@Override
	public List<CompositionResource> toResources(Iterable<? extends Composition> entities) {

		return StreamSupport.stream(entities.spliterator(), false)//
				.map(c -> toResource(c))//
				.collect(Collectors.toList());
	}

}
