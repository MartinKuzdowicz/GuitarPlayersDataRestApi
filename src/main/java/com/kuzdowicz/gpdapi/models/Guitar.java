package com.kuzdowicz.gpdapi.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.kuzdowicz.gpdapi.constants.GuitarType;

@Entity
@Table(name = "GUITARS")
@JsonInclude(Include.NON_EMPTY)
public class Guitar {

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "BRAND_NAME")
	private ProductBrand brand;

	@Id
	@Column(name = "MODEL_VERSION_NAME")
	@JsonIgnore
	private String modelVersionName;

	@Column(name = "MODEL_NAME")
	private String modelName;

	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private GuitarType type;

	@Column(name = "AVG_PRICE")
	private BigDecimal avgPrice;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public ProductBrand getBrand() {
		return brand;
	}

	public void setBrand(ProductBrand brand) {
		this.brand = brand;
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

	public String getModelVersionName() {
		return modelVersionName;
	}

	public void setModelVersionName(String modelVersionName) {
		this.modelVersionName = modelVersionName;
	}

}
