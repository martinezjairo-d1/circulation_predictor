package com.test.circulation_predictor.controller;

import com.test.circulation_predictor.service.PicoPlacaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * This class tests the PicoPlacaController, which handles HTTP requests.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
@WebMvcTest(PicoPlacaController.class)
public class PicoPlacaControllerTest {

	/**
	 * MockMvc is used to simulate HTTP requests to the controller. This allows us
	 * to perform tests without starting the entire application.
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * MockBean is used to mock the PicoPlacaService, we can isolate the behavior of
	 * the controller.
	 */
	@MockBean
	private PicoPlacaService picoPlacaService;

	/**
	 * Test that verifies if the controller returns an OK (200) status when the
	 * vehicle can circulate.
	 * 
	 * @throws Exception if the request handling fails
	 */
	@Test
	public void testCanCirculate_returnsOk() throws Exception {

		System.out.println("-------------------------------------------------");
		System.out.println("TEST: Running  testCanCirculate_returnsOk...");

		// Set up the mock service to return a specific message when the method
		// canCirculate() is called.
		Mockito.when(picoPlacaService.canCirculate("ABC-1234", "25/09/2023"))
				.thenReturn("Este día puedes circular libremente en todo el Distrito Metropolitano de Quito.");

		// Perform an HTTP POST request
		mockMvc.perform(post("/pico-placa/predictor") // Simulates a POST
				.contentType("application/json").content("{\"plateNumber\": \"ABC-1234\", \"date\": \"25/09/2023\"}"))
				.andExpect(status().isOk()) // Expects an HTTP 200 OK status in response
				.andExpect(content().string("Este día puedes circular libremente en todo el Distrito Metropolitano de Quito.")); // Expects the response body to contain the correct message
		System.out.println("TEST: testCanCirculate_returnsOk COMPLETED successfully.");
	}
}
