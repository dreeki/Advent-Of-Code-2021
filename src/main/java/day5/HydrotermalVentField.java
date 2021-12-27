package day5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class HydrotermalVentField {
    private final List<Line> lines;

    public HydrotermalVentField() {
        lines = new ArrayList<>();
    }

    public void addLine(String input) {
        lines.add(new Line(input));
    }

    public int getNumberOfPointsWithAtLeastTwoOverlappingLines(boolean withDiagonal) {
        Function<Line, List<Point>> getPointsFunction = withDiagonal ? Line::getPoints : Line::getPointsExcludingDiagonal;
        return (int) lines.stream()
                .map(getPointsFunction)
                .flatMap(Collection::stream)
                .collect(groupingBy(point -> point, counting()))
                .values()
                .stream()
                .filter(count -> count > 1)
                .count();
    }
}
