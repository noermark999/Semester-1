package Opgave5;

public class Rectangle extends GeometricFigures{
    private double side1;
    private double side2;

    public Rectangle(int xCoordinate, int yCoordinate, double side1, double side2) {
        super(xCoordinate,yCoordinate);
        this.side1 = side1;
        this.side2 = side2;
    }
    @Override
    public double getArea() {
        return side1*side2;
    }
}
