package com.kuzdowicz.rest.gpdapi.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.rest.gpdapi.db.domain.GuitarPlayer;

public interface GuitarPlayersRepository extends JpaRepository<GuitarPlayer, Long> {
	
	List<GuitarPlayer> findByAge(int age);

}
