package com.company.Abstraction.cardsWithPower;

public enum SuitPowers {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int power;

    public int getPower() {
        return power;
    }

    SuitPowers(int power) {
        this.power = power;
    }
}
