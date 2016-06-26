package com.kuzdowicz.rest.gpdapi.assembly.resources;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kuzdowicz.rest.gpdapi.constants.GuitarType;
import com.kuzdowicz.rest.gpdapi.db.domain.ProductBrand;

@JsonInclude(Include.NON_EMPTY)
public class GuitarResource extends ResourceSupport {

	private ProductBrand brand;
	private String modelName;
	private String modelVersionName;
	private GuitarType type;
	private BigDecimal avgPrice;

	public ProductBrand getBrand() {
		return brand;
	}

	public void setBrand(ProductBrand brand) {
		this.brand = brand;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelVersionName() {
		return modelVersionName;
	}

	public void setModelVersionName(String modelVersionName) {
		this.modelVersionName = modelVersionName;
	}

	public GuitarType getType() {
		return type;
	}

	public void setType(GuitarType type) {
		this.type = type;
	}

	public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

}
