/**
 * Evaluation project for "ANALISTA DE TECNOLOGÍA".
 */
package com.test.circulation_predictor;

import java.awt.Desktop;
import java.net.URI;

/**
 * Main class for the Circulation predictor application.
 * Determines if a vehicle can circulate based on "Pico y Placa" regulations.
 * 
 * @author Jairo Martínez
 * @version 1.0.0 - 30 Sep 2024
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts the "Circulation Predictor" Spring Boot application.
 */
@SpringBootApplication
public class CirculationPredictorApplication {

	/**
	 * Launches the Spring Boot application.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CirculationPredictorApplication.class, args);

		// Open the default web browser to the application URL
		openBrowser("http://localhost:8080/");
		
		// Show the SWAGGER documentation url in the console
		System.out.println("---------- SWAGGER Documentation ------------");
		System.out.println("http://[ip_server]:8080/swagger-ui/index.html");
		System.out.println("---------------------------------------------");
	}

	/**
	 * Opens the default web browser to the specified URL. If the system does not
	 * support the Desktop API, the method will not perform any action.
	 *
	 * @param url The URL to open in the default web browser.
	 */
	private static void openBrowser(String url) {
		// Check if the Desktop API is supported on the current platform
		if (Desktop.isDesktopSupported()) {
			try {
				// Attempt to open the specified URL in the default web browser
				Desktop.getDesktop().browse(new URI(url));
			} catch (Exception e) {
				// Print the stack trace if an error occurs while opening the browser
				e.printStackTrace();
			}
		}
	}

}
