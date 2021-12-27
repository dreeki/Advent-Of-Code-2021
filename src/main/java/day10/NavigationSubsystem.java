package day10;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class NavigationSubsystem {
    private final List<Line> lines;

    public NavigationSubsystem() {
        lines = new ArrayList<>();
    }

    public void addLine(String input) {
        lines.add(new Line(input));
    }

    public int accumulateCorruptionPoints() {
        return lines.stream()
                .mapToInt(Line::findCorruptionPoints)
                .sum();
    }

    public long findMiddleOfIncompletePoints() {
        List<Long> points = lines.stream()
                .mapToLong(Line::findIncompletePoints)
                .filter(i -> i != 0)
                .sorted()
                .boxed()
                .collect(toList());
        int medianIndex = points.size() / 2;
        return points.get(medianIndex);
    }
}
