package com.kuzdowicz.rest.gpdapi.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.rest.gpdapi.db.domain.Composition;

public interface CompositionsRepository extends JpaRepository<Composition, String> {

}
