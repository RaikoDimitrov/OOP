package com.company.Polymorphism.vehicles;

import java.text.DecimalFormat;

public class Bus  extends Vehicle {

    private static final double CONSUMPTION_WITH_PEOPLE = 1.4;


    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + CONSUMPTION_WITH_PEOPLE, tankCapacity);
    }

    public String driveEmpty(double distance) {
        DecimalFormat format = new DecimalFormat("#.##");
        double emptyConsumption = super.getFuelConsumption() - CONSUMPTION_WITH_PEOPLE;
        double requiredFuelWithoutPeople = emptyConsumption * distance;
        if (requiredFuelWithoutPeople <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - requiredFuelWithoutPeople);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(distance));
        }
        return String.format("%s needs refueling.", this.getClass().getSimpleName());
    }

}
