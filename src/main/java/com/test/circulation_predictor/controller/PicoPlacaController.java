package com.test.circulation_predictor.controller;

import com.test.circulation_predictor.service.PicoPlacaService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class that handles HTTP requests related to the "Pico y Placa" restriction system.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
@RestController
@RequestMapping("/pico-placa")
public class PicoPlacaController {

	@Autowired
    private final PicoPlacaService picoPlacaServices;

    /**
     * Constructor for PicoPlacaController.
     * 
     * @param picoPlacaServices the PicoPlacaService instance to be used for business logic.
     */
    @Autowired
    public PicoPlacaController(PicoPlacaService picoPlacaServices) {
        this.picoPlacaServices = picoPlacaServices;
    }

    /**
     * Endpoint to check if a vehicle can circulate.
     * 
     * @param requestData JSON that containing the license plate number and the date in the format dd/MM/yyyy.
     * @return ResponseEntity containing a message indicating if the vehicle can circulate or not.
     */
    @PostMapping("/predictor")
    public ResponseEntity<String> canCirculate(@RequestBody Map<String, String> requestData) {
        // Extract the plate number and date from the request data
        String plateNumber = requestData.get("plateNumber");
        String date = requestData.get("date");

        // Get the response message from the service layer
        String responseMessage = picoPlacaServices.canCirculate(plateNumber, date);
        
        // Return the response message wrapped in a ResponseEntity
        return ResponseEntity.ok(responseMessage);
    }
}
