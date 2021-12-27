package day4;

public class BingoNumber {
    private final int value;
    private boolean marked;

    public BingoNumber(int value) {
        this.value = value;
        marked = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isMarked() {
        return marked;
    }

    public boolean isNotMarked() {
        return !marked;
    }

    public void mark(int number) {
        if (value == number) {
            marked = true;
        }
    }
}
