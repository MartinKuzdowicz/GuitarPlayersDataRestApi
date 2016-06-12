package com.kuzdowicz.gpdapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kuzdowicz.rest.gpdapi.GuitarPlayersDataApiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GuitarPlayersDataApiApplication.class)
@WebAppConfiguration
public class GuitarPlayersDataApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
