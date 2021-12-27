package day2;

public enum Direction {
    FORWARD(1, 0),
    DOWN(0, 1),
    UP(0, -1);

    private final int horizontalMultiplier;
    private final int verticalMultiplier;

    Direction(int horizontalMultiplier, int verticalMultiplier) {
        this.horizontalMultiplier = horizontalMultiplier;
        this.verticalMultiplier = verticalMultiplier;
    }

    public int getHorizontalMultiplier() {
        return horizontalMultiplier;
    }

    public int getVerticalMultiplier() {
        return verticalMultiplier;
    }
}
