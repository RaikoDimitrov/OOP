package com.company.Abstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printTop(n);
        printBottom(n);

    }
    private static void printBottom(int n) {
        for (int i = n - 1; i >= 1; i--) {
            StringBuilder sb = new StringBuilder();
            appendSpaces(n - i, sb);
            appendStars(i, sb);
            System.out.println(sb);
        }
    }

    private static void printTop(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            appendSpaces(n - i, sb);
            appendStars(i, sb);
            System.out.println(sb);
        }
    }

    private static void appendStars(int count, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.append("* ");
        }
    }
    private static void appendSpaces(int count, StringBuilder sb) {
        for (int j = count; j > 0; j--) {
            sb.append(" ");
        }
    }
}
