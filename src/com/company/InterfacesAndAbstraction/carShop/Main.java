package com.company.InterfacesAndAbstraction.carShop;

import com.company.InterfacesAndAbstraction.carShop.carModels.Audi;
import com.company.InterfacesAndAbstraction.carShop.carModels.Mercedes;
import com.company.InterfacesAndAbstraction.carShop.interfaces.Car;

public class Main {
    public static void main(String[] args) {
        Car mercedes = new Mercedes("CLS63", "gray", 525, "Germany", 5, 150.0);
        Car audi = new Audi("RS7", "Nardo-grey", 625, "Germany", 200000.0);
        printCarInfo(mercedes);
        printCarInfo(audi);

    }

    private static void printCarInfo(Car car) {
        System.out.printf("%s is %s color and have %s horse power.%n",
                car.getModel(),
                car.getColor(),
                car.getHorsePower());
        System.out.println(car);
    }
}
