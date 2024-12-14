package com.company.InterfacesAndAbstraction.carShop.carModels;

import com.company.InterfacesAndAbstraction.carShop.CarImpl;
import com.company.InterfacesAndAbstraction.carShop.interfaces.Sellable;

public class Audi extends CarImpl implements Sellable {
    private final Double price;

    public Audi(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString()
                + System.lineSeparator()
                + String.format("%s sells for %f",
                this.getModel(),
                this.getPrice());
    }
}
