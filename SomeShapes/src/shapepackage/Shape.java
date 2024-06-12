package shapepackage;

public abstract class Shape {
	 protected int numberOfSides;

	    public int getNumberOfSides() {
	        return numberOfSides;
	    }

	    abstract double getArea();
	    abstract double getPerimeter();
	}

