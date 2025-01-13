package com.company.ExceptionsAndErrorHandling.validPerson;

public class Main {
    public static void main(String[] args) {
        try {
//            Person invalid = new Person("Unknown", "Unknown", -5);
            Person invalid = new Person("Unknown123", "", 25);

        } catch (InvalidInputException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
