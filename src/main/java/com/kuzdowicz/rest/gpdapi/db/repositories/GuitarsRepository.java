package com.kuzdowicz.rest.gpdapi.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.rest.gpdapi.db.domain.Guitar;

public interface GuitarsRepository extends JpaRepository<Guitar, String> {

}
