package Abstraction.hotelReservation;

public enum DiscountType {
    VIP(20),
    SecondVisit(10),
    None(0);

    private double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
