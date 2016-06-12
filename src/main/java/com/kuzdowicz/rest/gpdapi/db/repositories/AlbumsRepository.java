package com.kuzdowicz.rest.gpdapi.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.rest.gpdapi.db.domain.Album;

public interface AlbumsRepository extends JpaRepository<Album, String> {

}
