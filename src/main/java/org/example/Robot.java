package org.example;

public class Robot {
    private final Orientation orientation;
    private final Coordinate coordinate;

    public Robot(Orientation orientation, Coordinate coordinate) {
        this.orientation = orientation;
        this.coordinate = coordinate;
    }

    public Robot rotateLeft(final int numberOfTimes) {
        // TODO
        return new Robot(orientation, coordinate);
    }

    public Robot rotateRight(final int numberOfTimes) {
        // TODO
        return new Robot(orientation, coordinate);
    }

    public void move(final int numberOfSpaces) {
        // TODO
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "orientation=" + orientation +
                ", coordinate=" + coordinate +
                '}';
    }
}
