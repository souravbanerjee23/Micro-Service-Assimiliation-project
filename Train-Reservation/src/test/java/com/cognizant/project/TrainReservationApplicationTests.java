package com.cognizant.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.project.controller.ReservationController;
import com.cognizant.project.model.Reservation;
import com.google.gson.Gson;

@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class TrainReservationApplicationTests {

	@Autowired
	private ReservationController reservation;

	@Autowired
	private MockMvc mvc;

	@Test
	@Order(1)
	void contextLoader() throws Exception {
		assertNotNull(reservation);
	}

	@Test
	@Order(2)
	void testReserve() throws Exception {
		Reservation r = new Reservation((long) 900, (long) 9);
		Gson g = new Gson();
		String s = g.toJson(r);
		ResultActions actions = mvc
				.perform(post("/user/reserve/9/900").contentType(MediaType.APPLICATION_JSON).content(s));

		actions.andExpect(status().isUnauthorized());
	}

	@Test
	@Order(3)
	void testFindReservationByUserId() throws Exception {
		ResultActions actions = mvc.perform(get("/user/reserve/200"));
		actions.andExpect(status().isUnauthorized());
		//actions.andExpect(jsonPath("$[o].name").value("DEF"));

	}

	@Test
	@Order(4)
	void testDelete() throws Exception {
		ResultActions actions = mvc.perform(delete("/user/cancel/800"));
		actions.andExpect(status().isUnauthorized());
	}

}
