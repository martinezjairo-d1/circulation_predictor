package com.test.circulation_predictor.service;

import com.test.circulation_predictor.model.PicoPlaca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the PicoPlacaService class. The PicoPlaca
 * class is mocked to isolate and test the service layer independently.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
public class PicoPlacaServiceTest {

	private PicoPlacaService picoPlacaService;
	private PicoPlaca picoPlaca;

	/**
	 * Setup method that runs before each test. It initializes the PicoPlacaService
	 * and mocks the PicoPlaca model.
	 */
	@BeforeEach
	public void setup() {
		// Mock the PicoPlaca model to control its behavior in tests
		picoPlaca = Mockito.mock(PicoPlaca.class);

		// Initialize the service to be tested
		picoPlacaService = new PicoPlacaService();
	}

	/**
	 * Test to verify that when the vehicle is restricted, the correct restriction
	 * message is returned. It simulates a vehicle with a restricted license plate
	 * number on a restricted date.
	 */
	@Test
	public void testCanCirculate_returnsRestrictionMessage() {
		String plateNumber = "ABC-1232";

		System.out.println("-------------------------------------------------");
		System.out.println("TEST: Running  testCanCirculate_returnsRestrictionMessage...");

		// Date in dd/MM/yyyy format, which is a restricted date (Monday, 25th, Sep,
		// 2023)
		String date = "25/09/2023";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate localDate = LocalDate.parse(date, formatter);

		// Mock the behavior of the PicoPlaca model to return 'false' when the last
		// digit is 2 (restricted on Mondays)
		Mockito.when(picoPlaca.canCirculate(localDate, 2)).thenReturn(false);

		// Execute the canCirculate method of PicoPlacaService and capture the result
		String result = picoPlacaService.canCirculate(plateNumber, date);

		// Verify that the result matches the expected restriction message
		assertEquals(
				"Este día no puedes circular en la zona de Pico y Placa.:\n\nTe recordamos que los horarios de restricción son:\n\n- Matutino: 7:00 a.m. - 9:30 a.m.\n- Vespertino: 4:00 p.m. - 9:00 p.m.",
				result);

		System.out.println("TEST: testCanCirculate_returnsRestrictionMessage COMPLETED successfully.");
	}
}
