package com.company.InterfacesAndAbstraction.carShop.interfaces;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
