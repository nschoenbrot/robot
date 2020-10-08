package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {
    @Test
    public void rotateLeft_NtoS() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(6);
        assertEquals(Orientation.S, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateLeft_NtoE() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(7);
        assertEquals(Orientation.E, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateLeft_NtoW() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(1);
        assertEquals(Orientation.W, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateLeft_WtoS() {
        final Robot robot = new Robot(Orientation.W, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(1);
        assertEquals(Orientation.S, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateLeft_StoN() {
        final Robot robot = new Robot(Orientation.S, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(2);
        assertEquals(Orientation.N, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateLeft_EToW() {
        final Robot robot = new Robot(Orientation.E, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(3);
        assertEquals(Orientation.S, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateLeft_EToE() {
        final Robot robot = new Robot(Orientation.E, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateLeft(60);
        assertEquals(Orientation.E, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateRightEtoS() {
        final Robot robot = new Robot(Orientation.E, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateRight(5);
        assertEquals(Orientation.S, rotatedRobot.getOrientation());
    }


    @Test
    public void rotateRight_WtoE() {
        final Robot robot = new Robot(Orientation.W, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateRight(6);
        assertEquals(Orientation.E, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateRight_WtoS() {
        final Robot robot = new Robot(Orientation.W, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateRight(3);
        assertEquals(Orientation.S, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateRight_NtoN() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateRight(60);
        assertEquals(Orientation.N, rotatedRobot.getOrientation());
    }

    @Test
    public void rotateRight_StoE() {
        final Robot robot = new Robot(Orientation.S, new Coordinate(0, 0));
        final Robot rotatedRobot = robot.rotateRight(63);
        assertEquals(Orientation.E, rotatedRobot.getOrientation());
    }

    @Test
    public void move() {
        // TODO
    }
}