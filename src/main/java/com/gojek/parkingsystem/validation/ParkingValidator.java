package com.gojek.parkingsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingValidator {

    public static boolean isMatch(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateRegistrationNumber(String registrationNumber) {
        String registrationNumberRegex = "[A-Z]{2}-[0-9]{2}-[A-Z]{2}-[0-9]{4}";
        return isMatch(registrationNumberRegex, registrationNumber);
    }
}
