package com.test.circulation_predictor.utilities;

import java.util.regex.Pattern;

/**
 * 
 * This class is responsible for validating that the inputs for the services have the expected structure.
 * 
 * @author Jairo Martinez
 * @version 1.0
 */
public class InputValidator {

    // Regular expression for validating the plate number
    private static final String PLATE_REGEX = "^[A-Z]{3}-\\d{3,4}$";
    private static final Pattern PLATE_PATTERN = Pattern.compile(PLATE_REGEX);

    // Regular expression for validating the date in dd/MM/yyyy format
    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-9]|2[0-9]|3[01])/\\d{4}$";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);

    /**
     * Validates if the plate number matches the expected format (e.g., ABC-123 or ABC-1234).
     * 
     * @param plateNumber the plate number to be validated
     * @return true if valid, false otherwise
     */
    public static boolean isValidPlateNumber(String plateNumber) {
        return PLATE_PATTERN.matcher(plateNumber).matches();
    }

    /**
     * Validates if the date matches the expected format (dd/MM/yyyy).
     * 
     * @param date the date to be validated
     * @return true if valid, false otherwise
     */
    public static boolean isValidDate(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
}
