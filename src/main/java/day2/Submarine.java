package day2;

public class Submarine {
    protected int horizontal;
    protected int depth;

    public Submarine() {
        this.horizontal = 0;
        this.depth = 0;
    }

    public void move(Direction direction, int amount) {
        horizontal += direction.getHorizontalMultiplier() * amount;
        depth += direction.getVerticalMultiplier() * amount;
    }

    public int getMultiplication() {
        return horizontal * depth;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getDepth() {
        return depth;
    }
}
