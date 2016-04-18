package com.kuzdowicz.gpdapi.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kuzdowicz.gpdapi.constants.GuitarType;

@Entity
@Table(name = "GUITARS")
public class Guitar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUITAR_ID")
	private Long guitarId;

	@Column(name = "MODEL_NAME")
	private String modelName;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "BRAND_ID")
	private Brand brand;

	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private GuitarType type;

	@Column(name = "AVG_PRICE")
	private BigDecimal avgPrice;

	@ManyToMany(mappedBy = "guitars")
	private List<GuitarPlayer> players;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
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

	public Long getGuitarId() {
		return guitarId;
	}

	public void setGuitarId(Long guitarId) {
		this.guitarId = guitarId;
	}

	public List<GuitarPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<GuitarPlayer> players) {
		this.players = players;
	}

}
