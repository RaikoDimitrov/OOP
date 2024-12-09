package com.company.Abstraction.cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RankPowers rank = RankPowers.valueOf(scanner.nextLine());
        SuitPowers suit = SuitPowers.valueOf(scanner.nextLine());
        Card card = new Card(rank, suit);
        System.out.printf("Card name: %s of %s; Card power: %d"
                , rank
                , suit
                , card.getPower());
    }
}
