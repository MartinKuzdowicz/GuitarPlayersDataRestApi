package com.kuzdowicz.rest.gpdapi.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.rest.gpdapi.db.domain.ProductBrand;

public interface GuitarBrandsRepository extends JpaRepository<ProductBrand, String> {

}
