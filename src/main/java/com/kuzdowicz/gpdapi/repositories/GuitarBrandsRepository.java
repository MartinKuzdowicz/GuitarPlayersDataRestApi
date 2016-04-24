package com.kuzdowicz.gpdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuzdowicz.gpdapi.models.domain.ProductBrand;

public interface GuitarBrandsRepository extends JpaRepository<ProductBrand, String> {

}
