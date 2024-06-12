package shapepackage;

public class Triangle extends Shape{
	private double sideA, sideB, sideC;
	
    public Triangle(double sideA, double sideB, double sideC) {
        this.numberOfSides = 3;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }	

    @Override
    double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC;
    }
}
