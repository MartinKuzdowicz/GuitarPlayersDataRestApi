package com.kuzdowicz.gpdapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GUITAR_BRANDS")
public class Brand {

	@Id
	@Column(name = "BRAND_NAME")
	private String name;

	@Column(name = "WEBSITE")
	private String webSite;

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

}
