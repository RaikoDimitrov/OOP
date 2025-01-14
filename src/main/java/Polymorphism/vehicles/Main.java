package Polymorphism.vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] vehiclesInfo = reader.readLine().split("\\s+");
        double initialFuelQuantity = Double.parseDouble(vehiclesInfo[1]);
        double fuelConsumption = Double.parseDouble(vehiclesInfo[2]);
        double tankCapacity = Double.parseDouble(vehiclesInfo[3]);
        Vehicle car = new Car(initialFuelQuantity, fuelConsumption, tankCapacity);
        
        vehiclesInfo = reader.readLine().split("\\s+");
        initialFuelQuantity = Double.parseDouble(vehiclesInfo[1]);
        fuelConsumption = Double.parseDouble(vehiclesInfo[2]);
        tankCapacity = Double.parseDouble(vehiclesInfo[3]);
        Vehicle truck = new Truck(initialFuelQuantity, fuelConsumption, tankCapacity);

        vehiclesInfo = reader.readLine().split("\\s+");
        initialFuelQuantity = Double.parseDouble(vehiclesInfo[1]);
        fuelConsumption = Double.parseDouble(vehiclesInfo[2]);
        tankCapacity = Double.parseDouble(vehiclesInfo[3]);
        Vehicle bus = new Bus(initialFuelQuantity, fuelConsumption, tankCapacity);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int commandsCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] commandParts = reader.readLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];
            switch (command) {
                case "Drive" -> {
                    double distance = Double.parseDouble(commandParts[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                }
                case "Refuel" -> {
                    try {
                        double liters = Double.parseDouble(commandParts[2]);
                        vehicles.get(vehicleType).refuel(liters);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "DriveEmpty" -> {
                    try {
                        double distance = Double.parseDouble(commandParts[2]);
                        System.out.println(((Bus) bus).driveEmpty(distance));
                    } catch ( IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        vehicles.values().forEach(System.out::println);
    }
}
