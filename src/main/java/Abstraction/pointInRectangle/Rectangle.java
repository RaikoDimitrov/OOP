package Abstraction.pointInRectangle;

public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
    public boolean contains(Point point) {
        return point.isGreaterOrEqual(bottomLeft) && point.isLessOrEqual(topRight);
    }
}
