package com.company.Polymorphism.shapes;

public class Circle extends Shape {

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public void calculatePerimeter() {
        Double perimeter = 2 * Math.PI * this.radius;
        super.setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        Double area = Math.PI * (this.radius * 2);
        super.setArea(area);

    }
}
