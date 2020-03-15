package com.example.moviecatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MoviecatalogApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllMovies() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Star Wars")));
	}

	@Test
	public void getAllDirectors() throws Exception {
		mockMvc.perform(get("/directors")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("George Lucas")));
	}

	@Test
	public void getAllRatings() throws Exception {
		mockMvc.perform(get("/ratings")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Mark Kermode")));
	}

}
