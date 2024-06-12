package shapepackage;

public class Circle extends Ellipse {
    public Circle(double radius) {
        super(radius, radius);
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * majorAxis; // majorAxis es el radio
    }
}