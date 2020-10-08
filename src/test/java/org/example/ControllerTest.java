package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    private Controller controller;

    @Mock
    private Robot robot;

    @Before
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void readCompassDirection_north() {
        final Orientation orientation = controller.readCompassDirection("N 0 0");
        assertEquals(Orientation.N, orientation);
    }


    @Test
    public void readCompassDirection_east() {
        final Orientation orientation = controller.readCompassDirection("E 9 0");
        assertEquals(Orientation.E, orientation);
    }

    @Test
    public void readCompassDirection_west() {
        final Orientation orientation = controller.readCompassDirection("W 8 99");
        assertEquals(Orientation.W, orientation);
    }

    @Test
    public void readCompassDirection_south() {
        final Orientation orientation = controller.readCompassDirection("S 18 99");
        assertEquals(Orientation.S, orientation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCompassDirection_badInput() {
        controller.readCompassDirection("B 18 99");
    }

    @Test
    public void readCoordinate() {
        final Coordinate coordinate = controller.readCoordinate("0 12");
        assertEquals(0, coordinate.getX());
        assertEquals(12, coordinate.getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCoordinate_badInput() {
       controller.readCoordinate("sdkjnfds 0 12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCoordinate_badInputNoSpace() {
        controller.readCoordinate("012");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCoordinate_badInputLetters() {
        controller.readCoordinate("a b");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCoordinate_badInputMoreThanMaxX() {
        controller.readCoordinate(Coordinate.maxX + 1 + " " + Coordinate.maxY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readCoordinate_badInputMoreThanMaxY() {
        controller.readCoordinate(Coordinate.maxX + " " + Coordinate.maxY + 1);
    }

    @Test(expected = RuntimeException.class)
    public void readCoordinate_badInputLessThanMinX() {
        final Coordinate coordinate = controller.readCoordinate(Coordinate.minX - 1 + " 12");
    }

    @Test(expected = RuntimeException.class)
    public void readCoordinate_badInputLessThanMinY() {
        final Coordinate coordinate = controller.readCoordinate("1 " + (Coordinate.minY - 1));
    }

    @Test
    public void command_rightLeft() {
        when(robot.rotateRight(1)).thenReturn(robot);
        controller.command(robot, "RL");
        verify(robot).rotateLeft(1);
        verify(robot).rotateRight(1);
    }

    @Test
    public void command_rightLeftWithNumber() {
        when(robot.rotateRight(8)).thenReturn(robot);
        controller.command(robot, "R8L9");
        verify(robot).rotateLeft(9);
        verify(robot).rotateRight(8);
    }
}