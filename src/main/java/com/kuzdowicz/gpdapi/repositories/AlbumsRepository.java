package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.Album;

public interface AlbumsRepository extends JpaRepository<Album, String> {

}
