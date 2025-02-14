package Reflection.harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"HARVEST".equals(input = reader.readLine())) {
            if (!input.equals("all")) {
                ConsoleFieldPrinter.printFieldsByGivenModifier(input, SoilLand.class);
            } else {
                ConsoleFieldPrinter.printAllFields(SoilLand.class);
            }
        }
    }
}
