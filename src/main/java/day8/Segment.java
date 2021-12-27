package day8;

public class Segment {
    private final char value;

    public Segment(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean hasValue(char c) {
        return value == c;
    }
}
