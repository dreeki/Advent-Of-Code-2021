package day9;

public class Location {
    private final int row;
    private final int col;

    private final int height;
    private boolean isLowPoint;

    public Location(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
        isLowPoint = false;
    }

    public boolean isNotHigher(Location location) {
        return height <= location.height;
    }

    public int getHeight() {
        return height;
    }

    public boolean isLowPoint() {
        return isLowPoint;
    }

    public void makeLowPoint() {
        isLowPoint = true;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return row == location.row && col == location.col;
    }

    @Override
    public int hashCode() {
        return row * 1000 + col;
    }
}
