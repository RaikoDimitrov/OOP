package Polymorphism.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private final static String INVALID_FUEL = "Fuel must be a positive number.";

    private double fuelQuantity;
    private final double fuelConsumption;
    private final double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) throw new IllegalArgumentException(String.format
                ("%s needs refueling", this.getClass().getSimpleName()));
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void refuel(double liters) {
        if (this.fuelQuantity + liters > tankCapacity) throw new IllegalArgumentException("Cannot fit fuel in tank.");
        else if (liters <= 0) throw new IllegalArgumentException(INVALID_FUEL);
        this.fuelQuantity += liters;
    }

    public String drive(double distance) {
        DecimalFormat format = new DecimalFormat("#.##");
        double requiredFuel = this.fuelConsumption * distance;
        if (requiredFuel <= this.fuelQuantity) {
            this.fuelQuantity -= requiredFuel;
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(distance));
        }
        return String.format("%s needs refueling.", this.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
