package DesignPatterns.builderAndFacade;

public class Main {
    public static void main(String[] args) {

        Car car = new CarBuilderFacade().info()
                .withType("Mercedes")
                .withColor("Black")
                .withNumberOfDoors(4)
                .built()
                .inCity("Germany")
                .atAddress("123123")
                .build();
        System.out.println(car);

    }
}
