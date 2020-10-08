package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    @Test
    public void rotateLeft() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(6);
        assertEquals(Orientation.S, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateLeft_fromS() {
        final Robot robot = new Robot(Orientation.S, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(2);
        assertEquals(Orientation.N, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateRight() {
        final Robot robot = new Robot(Orientation.E, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateRight(5);
        assertEquals(Orientation.S, rotatedRobot.getOrientation());
    }


    @Test
    public void rotateRight_fromW() {
        final Robot robot = new Robot(Orientation.W, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateRight(6);
        assertEquals(Orientation.E, rotatedRobot.getOrientation());
    }

    @Test
    public void move() {
        // TODO
    }
}