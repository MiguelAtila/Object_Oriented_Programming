package shapepackage;

public class Ellipse extends Shape {
	protected double majorAxis;
    protected double minorAxis;

    public Ellipse(double majorAxis, double minorAxis) {
        this.numberOfSides = 1;
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    double getArea() {
        return Math.PI * majorAxis * minorAxis;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((majorAxis * majorAxis + minorAxis * minorAxis) / 2);
    }
}
