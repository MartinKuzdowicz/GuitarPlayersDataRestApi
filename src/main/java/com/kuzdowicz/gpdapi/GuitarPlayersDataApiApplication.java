package com.kuzdowicz.gpdapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GuitarPlayersDataApiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GuitarPlayersDataApiApplication.class, args);

		InitDbDataInitializer dbDataInitializer = ctx.getBean(InitDbDataInitializer.class);
		dbDataInitializer.initTestData();
		System.out.println(ctx.getApplicationName());
	}
}
