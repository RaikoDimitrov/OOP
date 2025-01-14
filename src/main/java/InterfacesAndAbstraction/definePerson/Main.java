package InterfacesAndAbstraction.definePerson;

import InterfacesAndAbstraction.definePerson.interfaces.Birthable;
import InterfacesAndAbstraction.definePerson.interfaces.Identifiable;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Birthable> birthables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandParts = input.split("\\s+");
            String type = commandParts[0];
            try {
                switch (type) {
                    case "Citizen":
                        Birthable citizen = new Citizen(commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3], commandParts[4]);
                        birthables.add(citizen);
                        break;
                    case "Robot":
                        Identifiable robot = new Robot(commandParts[1], commandParts[2]);
                        break;
                    case "Pet":
                        Birthable pet = new Pet(commandParts[1], commandParts[2]);
                        birthables.add(pet);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
        int year = Integer.parseInt(scanner.nextLine());
        String yearStr = Integer.toString(year);
        boolean found = false;
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().contains(yearStr)) {
                System.out.println(birthable.getBirthDate());
                found = true;
            }
        }
        if (!found) System.out.println("No output");
    }
}
