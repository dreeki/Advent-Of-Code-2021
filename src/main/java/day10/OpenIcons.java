package day10;

public enum OpenIcons {
    PARENTHESIS('(', ')', 1),
    BRACKETS('[', ']', 2),
    BRACES('{', '}', 3),
    CARRETS('<', '>', 4);

    private final char openIcon;
    private final char icon;
    private final int correctCharacterPoints;

    OpenIcons(char icon, char openIcon, int correctCharacterPoints) {
        this.openIcon = openIcon;
        this.icon = icon;
        this.correctCharacterPoints = correctCharacterPoints;
    }

    public char getIcon() {
        return icon;
    }

    public char getOpenIcon() {
        return openIcon;
    }

    public int getCorrectCharacterPoints() {
        return correctCharacterPoints;
    }
}
