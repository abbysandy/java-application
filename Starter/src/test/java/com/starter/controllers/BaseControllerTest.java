package com.starter.controllers;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.starter.StarterApplication;
import com.starter.configuration.ErrorConfiguration;
import com.starter.configuration.SecurityConfiguration;
import com.starter.configuration.StarterConfiguration;
import com.starter.configuration.TileConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { StarterApplication.class, StarterConfiguration.class, SecurityConfiguration.class, ErrorConfiguration.class, TileConfiguration.class })
@WebAppConfiguration
public abstract class BaseControllerTest {

	@Autowired
	protected WebApplicationContext	wac;

	protected MockMvc				mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

}
