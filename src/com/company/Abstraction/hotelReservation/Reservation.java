package com.company.Abstraction.hotelReservation;

public class Reservation {
    private double pricePerDay;
    private int numberOfDays;

    private Season season;
    private DiscountType discountType;

    public Reservation(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Season getSeason() {
        return season;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }
}
