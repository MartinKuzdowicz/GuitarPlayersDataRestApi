package com.kuzdowicz.gpdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.domain.GuitarPlayer;

public interface GuitarPlayersRepository extends JpaRepository<GuitarPlayer, Long> {
	
	
	List<GuitarPlayer> findByAge(int age);

}
