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
        numberOfTimes = numberOfTimes % orderedOrientations.size();
        final int index = orderedOrientations.indexOf(orientation);
        final int newIndex = index - numberOfTimes > -1 ?
                index - numberOfTimes : (index - numberOfTimes) + orderedOrientations.size();
        return new Robot(orderedOrientations.get(newIndex), coordinate);
    }

    public Robot rotateRight(int numberOfTimes) {
        numberOfTimes = numberOfTimes % orderedOrientations.size();
        final int index = orderedOrientations.indexOf(orientation);
        final int newIndex = index + numberOfTimes < orderedOrientations.size() ?
                index + numberOfTimes : (index + numberOfTimes) - orderedOrientations.size();
        return new Robot(orderedOrientations.get(newIndex), coordinate);
    }

    public Robot move(final int numberOfSpaces) {
        // TODO wrapping
        final int numberOfSpacesVertical = numberOfSpaces % (Coordinate.maxY + 1);
        final int numberOfSpacesHorizontal = numberOfSpaces % (Coordinate.maxY + 1);
        switch (orientation) {
            case N:
                return new Robot(
                        orientation,
                        new Coordinate(
                                coordinate.getX(),
                                coordinate.getY() + numberOfSpacesVertical > Coordinate.maxY ?
                                        coordinate.getY() + numberOfSpacesVertical - Coordinate.maxY - 1 :
                                        coordinate.getY() + numberOfSpacesVertical
                        ));
            case E:
                return new Robot(
                        orientation,
                        new Coordinate(
                                coordinate.getX() + numberOfSpacesHorizontal > Coordinate.maxX ?
                                        coordinate.getX() + numberOfSpacesHorizontal - Coordinate.maxX - 1 :
                                        coordinate.getX() + numberOfSpacesHorizontal,
                                coordinate.getY()
                        ));
            case S:
                return new Robot(
                        orientation,
                        new Coordinate(
                                coordinate.getX(),
                                coordinate.getY() - numberOfSpacesVertical < Coordinate.minX ?
                                        coordinate.getY() - numberOfSpacesVertical + Coordinate.maxY + 1 :
                                        coordinate.getY() - numberOfSpacesVertical
                        ));
            case W:
                return new Robot(
                        orientation,
                        new Coordinate(
                                coordinate.getX() - numberOfSpacesHorizontal < Coordinate.minX ?
                                        coordinate.getX() - numberOfSpacesHorizontal + Coordinate.maxX + 1 :
                                        coordinate.getX() - numberOfSpacesHorizontal,
                                coordinate.getY()
                        ));
            default:
                return new Robot(orientation, coordinate);
        }
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
