package com.company.ExceptionsAndErrorHandling;

import java.util.Scanner;

public class RangePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());
                printNumbers(start, end);
                break;

            } catch (NumberFormatException ex) {
                System.out.println("Please enter valid integers.");


            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again!");
            }
        }
    }

    private static void printNumbers(int start, int end) {
        if (start <= 1 || start >= end || end >= 100) {
            throw new IllegalArgumentException("The range should be  1 < start < end < 100");
        }

        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }

    }
}
