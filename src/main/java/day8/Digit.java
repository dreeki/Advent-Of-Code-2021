package day8;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Digit {
    private final String value;

    public Digit(String value) {
        this.value = value;
    }

    public boolean isSimpleValue() {
        return isNumber1() || isNumber7() || isNumber4() || isNumber8();
    }

    public boolean isNumber8() {
        return value.length() == 7;
    }

    public boolean isNumber4() {
        return value.length() == 4;
    }

    public boolean isNumber7() {
        return value.length() == 3;
    }

    public boolean isNumber1() {
        return value.length() == 2;
    }

    public int getAmountOfSegments() {
        return value.length();
    }

    public String getValue() {
        return value;
    }

    public List<Character> getSegments() {
        return IntStream.range(0, value.length())
                .mapToObj(value::charAt)
                .collect(toList());
    }

    public boolean doesNotContainAllOf(Digit digit) {
        return !doesContainAllOf(digit);
    }

    public boolean doesContainAllOf(Digit digit) {
        for(Character c : digit.getSegments()) {
            if(getSegments().stream().noneMatch(c2 -> c == c2)){
                return false;
            }
        }
        return true;
    }
}
