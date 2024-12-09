package com.company.Abstraction.pointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isGreaterOrEqual(Point p) {
        return this.x >= p.x && this.y >= p.y;
    }
    public boolean isLessOrEqual(Point p) {
        return this.x <= p.x && this.y <= p.y;
    }
}
