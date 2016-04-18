package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.Brand;

public interface GuitarBrandsRepository extends JpaRepository<Brand, String> {

}
