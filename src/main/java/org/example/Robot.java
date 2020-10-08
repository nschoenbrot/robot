package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Robot {
    private static final List<Orientation> orderedOrientations =
            Stream.of(Orientation.N, Orientation.E, Orientation.S, Orientation.W).collect(Collectors.toList());

    private final Orientation orientation;
    private final Coordinate coordinate;

    public Robot(Orientation orientation, Coordinate coordinate) {
        this.orientation = orientation;
        this.coordinate = coordinate;
    }

    public Robot rotateLeft(int numberOfTimes) {
        numberOfTimes = numberOfTimes % 4;
        final int index = orderedOrientations.indexOf(orientation);
        final int newIndex = index - numberOfTimes;
        return new Robot(orderedOrientations.get(Math.abs(newIndex)), coordinate);
    }

    public Robot rotateRight(int numberOfTimes) {
        numberOfTimes = numberOfTimes % 4;
        final int index = orderedOrientations.indexOf(orientation);
        final int newIndex = index + numberOfTimes < orderedOrientations.size() ?
                index + numberOfTimes : (index + numberOfTimes) - orderedOrientations.size();
        return new Robot(orderedOrientations.get(newIndex), coordinate);
    }

    public Robot move(final int numberOfSpaces) {
        // TODO
        return new Robot(orientation, coordinate);
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
