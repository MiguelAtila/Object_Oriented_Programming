package shapepackage;

public class Rectangle extends Quadrilateral {
	public Rectangle(double length, double width) {
        super(length, width, length, width);
    }

    @Override
    double getArea() {
        return sideA * sideB;
    }
}

