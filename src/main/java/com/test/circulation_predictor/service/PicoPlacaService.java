package com.test.circulation_predictor.service;

import com.test.circulation_predictor.model.PicoPlaca;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Service class that provides logic to determine if a vehicle can circulate
 * based on the "Pico y Placa" restriction.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
@Service
public class PicoPlacaService {

	/**
	 * Determines if a vehicle can circulate.
	 * 
	 * @param plateNumber the license plate number.
	 * @param date        the date to be reviewed.
	 * @return a String message indicating if the vehicle can circulate or not.
	 */
	public String canCirculate(String plateNumber, String date) {
		// Extract the last digit from the license plate numbe
		int lastDigit = Integer.parseInt(plateNumber.substring(plateNumber.length() - 1));

		// Format the provided date String into a LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);

		// Create an instance of the PicoPlaca model
		PicoPlaca picoPlaca = new PicoPlaca();

		// Check if the vehicle can circulate
		if (picoPlaca.canCirculate(localDate, lastDigit)) {
			return "Tu vehículo puede circular.";
		}
		return "Tu vehículo no puede circular en los siguienets horarios:\n" + "- 7:00 a.m. - 9:30 a.m.\n"
				+ "- 4:00 p.m. - 9:00 p.m.";
	}
}
