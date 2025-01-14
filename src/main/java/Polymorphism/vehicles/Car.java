package Polymorphism.vehicles;

public class Car extends Vehicle {

    private static final double CLIMATIC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + CLIMATIC_CONSUMPTION, tankCapacity);
    }


}
