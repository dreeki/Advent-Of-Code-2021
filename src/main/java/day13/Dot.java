package day13;

import java.util.Objects;

public class Dot {
    private int x;
    private int y;

    public Dot(String input) {
        String[] coords = input.split(",");
        x = Integer.parseInt(coords[0]);
        y = Integer.parseInt(coords[1]);
    }

    public void executeFoldInstruction(FoldInstruction foldInstruction) {
        switch (foldInstruction.getDirection()) {
            case VERTICAL -> executeVerticalFold(foldInstruction.getPosition());
            case HORIZONTAL -> executeHorizontalFold(foldInstruction.getPosition());
        }
        ;
    }

    private void executeHorizontalFold(int position) {
        if (x >= position) {
            x = position * 2 - x;
        }
    }

    private void executeVerticalFold(int position) {
        if (y >= position) {
            y = position * 2 - y;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return x == dot.x && y == dot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
