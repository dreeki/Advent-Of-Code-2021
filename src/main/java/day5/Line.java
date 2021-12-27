package day5;

import java.util.List;

public class Line {
    private final List<Point> pointsExcludingDiagonal;
    private final List<Point> points;

    public Line(String input) {
        String[] pointsInput = input.split(" -> ");

        Point first = new Point(pointsInput[0]);
        Point second = new Point(pointsInput[1]);

        pointsExcludingDiagonal = first.getPointsExcludingDiagonalBetween(second);
        points = first.getPointsBetween(second);
    }

    public List<Point> getPointsExcludingDiagonal() {
        return pointsExcludingDiagonal;
    }

    public List<Point> getPoints() {
        return points;
    }
}
