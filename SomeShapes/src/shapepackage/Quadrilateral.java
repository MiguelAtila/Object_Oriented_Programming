package shapepackage;

public class Quadrilateral extends Shape {
	 protected double sideA, sideB, sideC, sideD;

	    public Quadrilateral(double sideA, double sideB, double sideC, double sideD) {
	        this.numberOfSides = 4;
	        this.sideA = sideA;
	        this.sideB = sideB;
	        this.sideC = sideC;
	        this.sideD = sideD;
	    }

	    @Override
	    double getArea() {
	        // Placeholder: specific quadrilateral shapes need specific formulas
	        return 0;
	    }

	    @Override
	    double getPerimeter() {
	        return sideA + sideB + sideC + sideD;
	    }
	}

