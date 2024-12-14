package com.company.InterfacesAndAbstraction.carShop;

import com.company.InterfacesAndAbstraction.carShop.interfaces.Car;

public class CarImpl implements Car {
    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String country;

    public CarImpl(String model, String color, Integer horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.country;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires.",
                this.getModel(),
                this.countryProduced(),
                this.TIRES);
    }
}
