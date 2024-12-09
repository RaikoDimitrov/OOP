package com.company.Abstraction.cardsWithPower;

public class Card {
    private final RankPowers rankPower;
    private final SuitPowers suitPower;

    public Card(RankPowers rankPower, SuitPowers suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public int getPower() {
        return rankPower.getPower() + suitPower.getPower();
    }
}
