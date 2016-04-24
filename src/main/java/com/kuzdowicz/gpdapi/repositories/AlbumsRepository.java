package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.domain.Album;

public interface AlbumsRepository extends JpaRepository<Album, String> {

}
