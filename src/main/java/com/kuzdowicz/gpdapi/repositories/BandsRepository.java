package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.Band;

public interface BandsRepository extends JpaRepository<Band, String> {

}