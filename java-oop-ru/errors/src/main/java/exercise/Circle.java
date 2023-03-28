package exercise;

import java.io.IOException;

// BEGIN
public class Circle {
    protected final Point point;
    protected final int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public final int getRadius() {
        return radius;
    }

    public final double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Radius < 0");
        }
        return Math.PI * radius * radius;
    }
}
// END
