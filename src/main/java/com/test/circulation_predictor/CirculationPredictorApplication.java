/**
 * Evaluation project for "ANALISTA DE TECNOLOGÍA".
 */
package com.test.circulation_predictor;

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
     * @param args Command-line arguments (if any).
     */
    public static void main(String[] args) {
        SpringApplication.run(CirculationPredictorApplication.class, args);
        System.out.println("---------- SWAGGER Documentation ------------");
		System.out.println("http://[ip_server]:8080/swagger-ui/index.html");
		System.out.println("---------------------------------------------");
    }
}
