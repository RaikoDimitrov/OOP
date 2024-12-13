package com.company.Inheritance.needForSpeed;

public class SportsCar extends Car {
    private final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportsCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
