package org.example;

public class Coordinate {
    public static final int maxX = 99;
    public static final int minX = 0;
    public static final int maxY= 99;
    public static final int minY = 0;

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
