package day3;

public enum Bit {
    ZERO(0),
    ONE(1);

    private final int value;

    Bit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
