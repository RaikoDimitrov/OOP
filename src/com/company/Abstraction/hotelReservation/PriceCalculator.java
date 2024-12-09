package com.company.Abstraction.hotelReservation;

public class PriceCalculator {

    public static double calculatePrice(Reservation reservation) {
        double priceWithoutDiscount = reservation.getNumberOfDays() * reservation.getPricePerDay() * reservation.getSeason().getValue();
        double discount = (reservation.getDiscountType().getDiscount() * priceWithoutDiscount) / 100;
        return priceWithoutDiscount - discount;
    }
}
