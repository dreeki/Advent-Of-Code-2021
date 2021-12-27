package day13;

public enum FoldingDirection {
    HORIZONTAL,
    VERTICAL;

    public static FoldingDirection findDirection(String direction) {
        return switch (direction) {
            case "y" -> VERTICAL;
            case "x" -> HORIZONTAL;
            default -> throw new IllegalArgumentException("direction '" + direction + "' is not supported.");
        };
    }
}
