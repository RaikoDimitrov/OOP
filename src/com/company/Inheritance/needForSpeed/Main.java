package com.company.Inheritance.needForSpeed;

public class Main {
    public static void main(String[] args) {
        Motorcycle regularBike = new Motorcycle(70, 195);
        SportsCar raceCar = new SportsCar(50.5, 650);
        Motorcycle raceBike = new RaceMotorcycle(20.2, 210);
        raceBike.drive(5);
        System.out.println();
        regularBike.drive(10);
        System.out.println();
        raceCar.drive(6);
    }
}
