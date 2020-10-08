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
    public void move_N() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(12, 1));
        final Robot movedRobot = robot.move(90);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(91, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_E() {
        final Robot robot = new Robot(Orientation.E, new Coordinate(12, 1));
        final Robot movedRobot = robot.move(5);
        assertEquals(17, movedRobot.getCoordinate().getX());
        assertEquals(1, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_S() {
        final Robot robot = new Robot(Orientation.S, new Coordinate(12, 99));
        final Robot movedRobot = robot.move(90);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(9, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_W() {
        final Robot robot = new Robot(Orientation.W, new Coordinate(12, 1));
        final Robot movedRobot = robot.move(5);
        assertEquals(7, movedRobot.getCoordinate().getX());
        assertEquals(1, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_NToSamePosition() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(12, 1));
        final Robot movedRobot = robot.move(100);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(1, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_EToSamePosition() {
        final Robot robot = new Robot(Orientation.E, new Coordinate(12, 1));
        final Robot movedRobot = robot.move(100);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(1, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_SToSamePosition() {
        final Robot robot = new Robot(Orientation.S, new Coordinate(12, 99));
        final Robot movedRobot = robot.move(100);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(99, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_WToSamePosition() {
        final Robot robot = new Robot(Orientation.W, new Coordinate(12, 1));
        final Robot movedRobot = robot.move(100);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(1, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_NOverEdge() {
        final Robot robot = new Robot(Orientation.N, new Coordinate(12, 98));
        final Robot movedRobot = robot.move(3);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(1, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_EOverEdge() {
        final Robot robot = new Robot(Orientation.E, new Coordinate(50, 1));
        final Robot movedRobot = robot.move(50);
        assertEquals(0, movedRobot.getCoordinate().getX());
        assertEquals(1, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_SOverEdge() {
        final Robot robot = new Robot(Orientation.S, new Coordinate(12, 1));
        final Robot movedRobot = robot.move(10);
        assertEquals(12, movedRobot.getCoordinate().getX());
        assertEquals(91, movedRobot.getCoordinate().getY());
    }

    @Test
    public void move_WOverEdge() {
        final Robot robot = new Robot(Orientation.W, new Coordinate(12, 0));
        final Robot movedRobot = robot.move(13);
        assertEquals(99, movedRobot.getCoordinate().getX());
        assertEquals(0, movedRobot.getCoordinate().getY());
    }
}