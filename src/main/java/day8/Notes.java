package day8;

import java.util.ArrayList;
import java.util.List;

public class Notes {
    private final List<Line> lines;

    public Notes() {
        lines = new ArrayList<>();
    }

    public void addLine(String input) {
        lines.add(new Line(input));
    }

    public int countAccumulatedSimpleDigitsInOutput() {
        return lines.stream()
                .mapToInt(Line::countSimpleDigitsInOutput)
                .sum();
    }

    public int accumulateOutputs() {
        lines.forEach(Line::decodeDisplay);
        return lines.stream()
                .mapToInt(Line::decodeOutput)
                .sum();
    }
}
