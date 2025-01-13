package com.company.ExceptionsAndErrorHandling.validPerson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtils {

    public static boolean validateAge(int age) throws InvalidInputException {

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in between [0-120]");
        }
        return true;
    }

    public static void validateName(String firstOrLast, String name) throws  InvalidInputException {
        Pattern pattern = Pattern.compile("[!@#$%^&*(),.?\":{}|<>0-9]+");
        Matcher matcher = pattern.matcher(name);

        if (name.trim().isBlank()) {
            String message = String.format("%s name cannot be null or empty.", firstOrLast);
            throw new IllegalArgumentException(message);
        }
        if (matcher.find()) {
            throw new InvalidInputException();
        }
    }
}
