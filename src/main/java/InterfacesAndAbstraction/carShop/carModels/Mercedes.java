package InterfacesAndAbstraction.carShop.carModels;

import InterfacesAndAbstraction.carShop.CarImpl;
import InterfacesAndAbstraction.carShop.interfaces.Rentable;

public class Mercedes extends CarImpl implements Rentable {
    private final Integer minRentDay;
    private final Double pricePerDay;

    public Mercedes(String model, String color, Integer horsePower, String country, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString()
                + System.lineSeparator()
                + String.format("Minimum rental period for %d days. Price per day: %f",
                this.getMinRentDay(),
                this.getPricePerDay());
    }
}
