package com.test.circulation_predictor.model;

import java.time.LocalDate;

/**
 * This class models the "Pico y Placa" restriction system.
 *  It contains the logic to determine if a vehicle can circulate.
 *  
 * @author Jairo Martinez
 * @version 1.0
 */
public class PicoPlaca {

    /**
     * Array representing the restriction days for each weekday.
     */
    private final int[][] restrictions = { 
        { 1, 2 }, // Monday
        { 3, 4 }, // Tuesday
        { 5, 6 }, // Wednesday
        { 7, 8 }, // Thursday
        { 9, 0 }  // Friday
    };

    /**
     * Determines if a vehicle can circulate on a given date based on the last digit of its license plate.
     * 
     * @param date the date to be reviewed
     * @param lastDigit the last digit of the license plate.
     * @return true if the vehicle can circulate, false otherwise.
     */
    public boolean canCirculate(LocalDate date, int lastDigit) {
        // Get the day of the week as an integer (1=Monday, ..., 7=Sunday)
        int dayOfWeek = date.getDayOfWeek().getValue();

        // If the day is Saturday or Sunday, there are no restrictions.
        if (dayOfWeek == 6 || dayOfWeek == 7) {
            return true;
        }
        
        // Check if the last digit of the plate is restricted on that weekday
        for (int restrictedDigit : restrictions[dayOfWeek - 1]) {
            if (restrictedDigit == lastDigit) {
                return false; 
            }
        }
        return true;
    }
}
