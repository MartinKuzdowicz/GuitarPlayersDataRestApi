package com.kuzdowicz.gpdapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GUITAR_BRANDS")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BRAND_ID")
	private Long brandId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "WEBSITE")
	private String webSite;

	@OneToMany
	@JoinColumn(name = "GUITAR_ID")
	private List<Guitar> guitars;
	

	public List<Guitar> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

}
