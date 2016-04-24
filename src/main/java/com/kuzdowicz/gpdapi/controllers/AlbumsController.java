package com.kuzdowicz.gpdapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kuzdowicz.gpdapi.models.domain.Album;
import com.kuzdowicz.gpdapi.repositories.AlbumsRepository;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

	private AlbumsRepository albumsRepository;

	@Autowired
	public AlbumsController(AlbumsRepository albumsRepository) {
		this.albumsRepository = albumsRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Album> getAllAlbums() {
		return albumsRepository.findAll();
	}

}
