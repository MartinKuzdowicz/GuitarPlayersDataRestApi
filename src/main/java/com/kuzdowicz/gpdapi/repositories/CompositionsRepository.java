package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.Composition;

public interface CompositionsRepository extends JpaRepository<Composition, String> {

}
