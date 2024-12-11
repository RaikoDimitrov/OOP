package com.company.Encapsulation.box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        isValidSide(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        isValidSide(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        isValidSide(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * (this.length * this.height) + 2 * (this.length * this.width) + 2 * (this.width * this.height);
    }
    public double calculateLateralSurfaceArea() {
        return 2 * (this.length * this.height) + 2 * (this.width * this.height);
    }
    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    private void isValidSide(double param, String side) {
        if (param <= 0) throw new IllegalArgumentException(String.format("%s cannot be zero or negative", side));
    }
}
