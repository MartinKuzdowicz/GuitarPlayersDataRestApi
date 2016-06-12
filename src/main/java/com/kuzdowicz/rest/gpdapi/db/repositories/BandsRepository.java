package com.kuzdowicz.rest.gpdapi.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.rest.gpdapi.db.domain.Band;

public interface BandsRepository extends JpaRepository<Band, String> {

}
