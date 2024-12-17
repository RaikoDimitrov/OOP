package com.company.Polymorphism.shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        Double perimeter = 2 * this.height + 2 * this.width;
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        Double area = this.height * this.width;
        super.setArea(area);
    }
}
