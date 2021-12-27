package day10;

public enum CloseIcons {
    PARENTHESIS(')', '(', 3),
    BRACKETS(']', '[', 57),
    BRACES('}', '{', 1197),
    CARRETS('>', '<', 25137);

    private final char openIcon;
    private final char icon;
    private final int illegalCloseCharacterPoints;

    CloseIcons(char icon, char openIcon, int illegalCloseCharacterPoints) {
        this.openIcon = openIcon;
        this.icon = icon;
        this.illegalCloseCharacterPoints = illegalCloseCharacterPoints;
    }

    public char getIcon() {
        return icon;
    }

    public char getOpenIcon() {
        return openIcon;
    }

    public int getIllegalCloseCharacterPoints() {
        return illegalCloseCharacterPoints;
    }
}
