package day7;

public class CrabSubmarine {
    private final int horizontalPosition;

    public CrabSubmarine(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int calculateLinearFuelConsumptionToNewHorizontalPosition(int newHorizontalPosition) {
        return Math.abs(newHorizontalPosition - horizontalPosition);
    }

    public int calculateIncreasingFuelConsumptionToNewHorizontalPosition(int newHorizontalPosition) {
        int linearDistance = Math.abs(newHorizontalPosition - horizontalPosition);
        return (linearDistance * (linearDistance + 1)) / 2;
    }
}
