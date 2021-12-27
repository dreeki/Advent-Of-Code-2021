package day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class Point {
    private final int x;
    private final int y;

    public Point(String input) {
        String[] coords = input.split(",");

        this.x = Integer.parseInt(coords[0]);
        this.y = Integer.parseInt(coords[1]);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasSameX(Point p) {
        return x == p.x;
    }

    public boolean hasSameY(Point p) {
        return y == p.y;
    }

    public List<Point> getPointsExcludingDiagonalBetween(Point p) {
        return getPointsBetween(p, false);
    }

    public List<Point> getPointsBetween(Point p) {
        return getPointsBetween(p, true);
    }

    private List<Point> getPointsBetween(Point p, boolean withDiagonal) {
        if (hasSameX(p)) {
            return getVerticalPointsBetween(p);
        } else if (hasSameY(p)) {
            return getHorizontalPointsBetween(p);
        } else {
            if(withDiagonal) {
                return getDiagonalPointsBetween(p);
            }
            return emptyList();
        }
    }

    private List<Point> getVerticalPointsBetween(Point p) {
        int amountOfSteps = p.y - y;
        int step = amountOfSteps > 0 ? 1 : -1;

        List<Point> result = new ArrayList<>();
        result.add(this);
        for (int i = step; Math.abs(i) < Math.abs(amountOfSteps); i += step) {
            result.add(new Point(x, y + i));
        }
        result.add(p);

        return result;
    }

    private List<Point> getHorizontalPointsBetween(Point p) {
        int amountOfSteps = p.x - x;
        int step = amountOfSteps > 0 ? 1 : -1;

        List<Point> result = new ArrayList<>();
        result.add(this);
        for (int i = step; Math.abs(i) < Math.abs(amountOfSteps); i += step) {
            result.add(new Point(x + i, y));
        }
        result.add(p);

        return result;
    }

    private List<Point> getDiagonalPointsBetween(Point p) {
        int amountOfSteps = Math.abs(p.x - x);
        int stepX = p.x - x > 0 ? 1 : -1;
        int stepY = p.y - y > 0 ? 1 : -1;

        List<Point> result = new ArrayList<>();
        result.add(this);
        for (int i = 1; i < Math.abs(amountOfSteps); i++) {
            result.add(new Point(x + (i * stepX), y + (i * stepY)));
        }
        result.add(p);

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
