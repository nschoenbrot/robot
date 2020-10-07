package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    public static void main(final String... args) {
        final InputStream inputStream = Controller.class.getClassLoader().getResourceAsStream("input.txt");
        final List<String> inputList = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.toList());

        System.out.println(inputList);

        final Controller controller = new Controller();
        final Orientation orientation = controller.readCompassDirection(
                inputList.get(0)
        );
        final Coordinate coordinate = controller.readCoordinate(
                inputList.get(0).split(" ", 2)[1]
        );

        final Robot initialRobot = new Robot(orientation, coordinate);
        System.out.println("Initial robot: " + initialRobot);

        final Robot commandedRobot = controller.command(initialRobot, inputList.get(1));
        System.out.println("Commanded robot: " + commandedRobot);

        System.out.println(commandedRobot.getOrientation() + " " +
                commandedRobot.getCoordinate().getX() + " " +
                commandedRobot.getCoordinate().getY());
    }

    public Orientation readCompassDirection(final String input) {
        final char firstChar = input.charAt(0);
        return Orientation.valueOf(Character.toString(firstChar));
    }

    public Coordinate readCoordinate(final String input) {
        final String[] inputArray = input.split(" ");

        if (inputArray.length != 2) {
            throw new IllegalArgumentException();
        }

        final int x = Integer.parseInt(inputArray[0]);
        final int y = Integer.parseInt(inputArray[1]);

        if (x > Coordinate.maxX || y > Coordinate.maxY || x < Coordinate.minX || y < Coordinate.minY) {
            throw new IllegalArgumentException();
        }

        return new Coordinate(x, y);
    }

    public Robot command(final Robot robot, final String input) {
        // TODO
        return robot;
    }
}
