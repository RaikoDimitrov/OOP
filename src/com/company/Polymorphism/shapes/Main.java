package com.company.Polymorphism.shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.5);
        Shape rectangle = new Rectangle(12.5, 7.0);
        calculateArea(circle);
        calculateArea(rectangle);

        calculatePerimeter(circle);
        calculatePerimeter(rectangle);
    }

    private static void calculatePerimeter(Shape shape) {
        shape.calculatePerimeter();
        System.out.printf("%s perimeter is: %.2f%n", shape.getClass().getSimpleName(), shape.getPerimeter());
    }

    private static void calculateArea(Shape shape) {
        shape.calculateArea();
        System.out.printf("%s area is: %.2f%n", shape.getClass().getSimpleName(), shape.getArea());
    }
}
