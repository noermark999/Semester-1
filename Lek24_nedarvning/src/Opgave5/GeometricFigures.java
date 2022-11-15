package Opgave5;

import java.util.ArrayList;

public abstract class GeometricFigures {
    private int xCoordinate;
    private int yCoordinate;

    public GeometricFigures(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void offsetX(int xCoordinate) {
        this.xCoordinate += xCoordinate;
    }

    public void offsetY(int yCoordinate) {
        this.yCoordinate += yCoordinate;
    }
    public abstract double getArea();

    public static double totalArea(ArrayList<GeometricFigures> figures) {
        double sum = 0;
        for (GeometricFigures geometricFigures : figures) {
            sum += geometricFigures.getArea();
        }
        return sum;
    }
}
