package day8;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final List<Integer> MULTIPLIERS = List.of(1000, 100, 10, 1);

    private final LinePart lineInput;
    private final LinePart lineOutput;
    private final Display display;

    public Line(String input) {
        String[] inputSplitted = input.split(" [|] ");
        lineInput = new LinePart(inputSplitted[0]);
        lineOutput = new LinePart(inputSplitted[1]);

        display = new Display();
    }

    public int countSimpleDigitsInOutput() {
        return (int) lineOutput.getDigits().stream()
                .filter(Digit::isSimpleValue)
                .count();
    }

    public void decodeDisplay() {
        Digit number1 = findNumber1();
        Digit number7 = findNumber7();
        Segment top = findTopSegment(number1, number7);
        display.setTop(top);

        Digit number6 = findNumber6(number1);
        Segment topRight = findTopRightSegment(number1, number6);
        display.setTopRight(topRight);

        Segment bottomRight = findBottomRightSegment(number1);
        display.setBottomRight(bottomRight);

        Digit number4 = findNumber4();
        Digit number9 = findNumber9(number4);
        Segment bottom = findBottomSegment(number4, number9);
        display.setBottom(bottom);

        Digit number3 = findNumber3();
        Segment middle = findMiddleSegment(number3);
        display.setMiddle(middle);

        Segment topLeft = findTopLeftSegment(number9);
        display.setTopLeft(topLeft);

        Digit number8 = findNumber8();
        Segment bottomLeft = findBottomLeftSegment(number8);
        display.setBottomLeft(bottomLeft);
    }

    private Segment findBottomLeftSegment(Digit number8) {
        Character value = number8.getSegments().stream()
                .filter(c -> display.getTop().getValue() != c)
                .filter(c -> display.getTopRight().getValue() != c)
                .filter(c -> display.getTopLeft().getValue() != c)
                .filter(c -> display.getMiddle().getValue() != c)
                .filter(c -> display.getBottomRight().getValue() != c)
                .filter(c -> display.getBottom().getValue() != c)
                .findFirst()
                .orElseThrow();
        return new Segment(value);
    }

    private Segment findTopLeftSegment(Digit number9) {
        Character value = number9.getSegments().stream()
                .filter(c -> display.getTop().getValue() != c)
                .filter(c -> display.getTopRight().getValue() != c)
                .filter(c -> display.getMiddle().getValue() != c)
                .filter(c -> display.getBottomRight().getValue() != c)
                .filter(c -> display.getBottom().getValue() != c)
                .findFirst()
                .orElseThrow();
        return new Segment(value);
    }

    private Segment findMiddleSegment(Digit number3) {
        Character value = number3.getSegments().stream()
                .filter(c -> display.getTop().getValue() != c)
                .filter(c -> display.getTopRight().getValue() != c)
                .filter(c -> display.getBottomRight().getValue() != c)
                .filter(c -> display.getBottom().getValue() != c)
                .findFirst()
                .orElseThrow();
        return new Segment(value);
    }

    private Segment findBottomSegment(Digit number4, Digit number9) {
        Character value = number9.getSegments().stream()
                .filter(c -> !number4.getSegments().contains(c))
                .filter(c -> display.getTop().getValue() != c)
                .findFirst()
                .orElseThrow();
        return new Segment(value);
    }

    private Segment findBottomRightSegment(Digit number1) {
        Character value = number1.getSegments().stream()
                .filter(c -> display.getTopRight().getValue() != c)
                .findFirst()
                .orElseThrow();
        return new Segment(value);
    }

    private Segment findTopRightSegment(Digit number1, Digit number6) {
        Character value = number1.getSegments().stream()
                .filter(c -> !number6.getSegments().contains(c))
                .findFirst()
                .orElseThrow();
        return new Segment(value);
    }

    private Segment findTopSegment(Digit number1, Digit number7) {
        Character value = number7.getSegments().stream()
                .filter(c -> !number1.getSegments().contains(c))
                .findFirst()
                .orElseThrow();
        return new Segment(value);
    }

    private Digit findNumber3() {
        return lineInput.getDigits().stream()
                .filter(digit -> digit.getAmountOfSegments() == 5)
                .filter(digit -> digit.getSegments().contains(display.getTop().getValue()))
                .filter(digit -> digit.getSegments().contains(display.getTopRight().getValue()))
                .filter(digit -> digit.getSegments().contains(display.getBottomRight().getValue()))
                .filter(digit -> digit.getSegments().contains(display.getBottomRight().getValue()))
                .findFirst()
                .orElseThrow();
    }

    private Digit findNumber9(Digit number4) {
        return lineInput.getDigits().stream()
                .filter(digit -> digit.getAmountOfSegments() == 6)
                .filter(digit -> digit.doesContainAllOf(number4))
                .findFirst()
                .orElseThrow();
    }

    private Digit findNumber8() {
        return lineInput.getDigits().stream()
                .filter(Digit::isNumber8)
                .findFirst()
                .orElseThrow();
    }

    private Digit findNumber4() {
        return lineInput.getDigits().stream()
                .filter(Digit::isNumber4)
                .findFirst()
                .orElseThrow();
    }

    private Digit findNumber6(Digit number1) {
        return lineInput.getDigits().stream()
                .filter(digit -> digit.getAmountOfSegments() == 6)
                .filter(digit -> digit.doesNotContainAllOf(number1))
                .findFirst()
                .orElseThrow();
    }

    private Digit findNumber7() {
        return lineInput.getDigits().stream()
                .filter(Digit::isNumber7)
                .findFirst()
                .orElseThrow();
    }

    private Digit findNumber1() {
        return lineInput.getDigits().stream()
                .filter(Digit::isNumber1)
                .findFirst()
                .orElseThrow();
    }

    public Display getDisplay() {
        return display;
    }

    public int decodeOutput() {
        return IntStream.rangeClosed(0, 3)
                .map(this::decodeValueAtIndex)
                .sum();

    }

    private int decodeValueAtIndex(int i){
        Digit digit = lineOutput.getDigits().get(i);

        int digitNumber = display.getNumber(digit);
        int multiplier = MULTIPLIERS.get(i);

        return digitNumber * multiplier;
    }
}
