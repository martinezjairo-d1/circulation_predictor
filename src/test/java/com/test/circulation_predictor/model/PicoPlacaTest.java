package com.test.circulation_predictor.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the PicoPlaca class.
 * The tests check the behavior of the canCirculate method under different conditions.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
public class PicoPlacaTest {

    /**
     * Test to check if the vehicle cannot circulate on a restricted day with a restricted last digit.
     * This simulates a case where a vehicle with the last digit 2 tries to circulate on a Monday.
     */
    @Test
    public void testCanCirculate_returnsFalse() {
        PicoPlaca picoPlaca = new PicoPlaca();
        
        System.out.println("-------------------------------------------------");
        System.out.println("TEST: Running  testCanCirculate_returnsFalse...");
        
        // Set a restricted date (Monday, 25th, Sep, 2023)
        LocalDate restrictedDate = LocalDate.of(2023, 9, 25);
        
        // Set a restricted last digit on Mondays.
        int restrictedLastDigit = 2;

        // Execute the canCirculate method and check if it returns false
        boolean result = picoPlaca.canCirculate(restrictedDate, restrictedLastDigit);

        // Assert that the result is false, meaning the vehicle cannot circulate
        assertFalse(result, "Expected vehicle to be restricted on this day and last digit.");
        System.out.println("TEST: testCanCirculate_returnsFalse COMPLETED successfully.");
    }

    /**
     * Test to check if the vehicle can circulate on a weekend (Saturday).
     * There should be no restrictions on weekends.
     */
    @Test
    public void testCanCirculate_returnsTrue() {
        PicoPlaca picoPlaca = new PicoPlaca();
        
        System.out.println("-------------------------------------------------");
        System.out.println("TEST: Running  testCanCirculate_returnsTrue...");
        
        // Set a weekend date (Saturday, 30th, Sep, 2023)
        LocalDate saturday = LocalDate.of(2023, 9, 30);
        
        // Any digit can be used here because weekends are free.
        int anyDigit = 3;

        // Execute the canCirculate method and check if it returns true
        boolean result = picoPlaca.canCirculate(saturday, anyDigit);

        // Assert that the result is true, meaning the vehicle can circulate
        assertTrue(result, "Expected vehicle to be free to circulate on weekends.");
   
        System.out.println("TEST: testCanCirculate_returnsTrue COMPLETED successfully.");
    }
}
