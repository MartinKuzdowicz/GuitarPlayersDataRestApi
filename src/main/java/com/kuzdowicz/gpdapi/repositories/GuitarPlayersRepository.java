package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.GuitarPlayer;

public interface GuitarPlayersRepository extends JpaRepository<GuitarPlayer, Long> {

}
