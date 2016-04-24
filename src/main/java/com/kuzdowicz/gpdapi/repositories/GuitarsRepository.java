package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.domain.Guitar;

public interface GuitarsRepository extends JpaRepository<Guitar, String> {

}
