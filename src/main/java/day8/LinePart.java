package day8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LinePart {
    private final List<Digit> digits;

    public LinePart(String input) {
        digits = Arrays.stream(input.split(" "))
                .map(Digit::new)
                .collect(toList());
    }

    public List<Digit> getDigits() {
        return digits;
    }
}
