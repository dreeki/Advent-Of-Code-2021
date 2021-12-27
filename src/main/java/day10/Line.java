package day10;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Line {
    private static final Map<Character, CloseIcons> CLOSE_ICON_MAP = Map.ofEntries(
            Map.entry(')', CloseIcons.PARENTHESIS),
            Map.entry(']', CloseIcons.BRACKETS),
            Map.entry('}', CloseIcons.BRACES),
            Map.entry('>', CloseIcons.CARRETS)
    );
    private static final Map<Character, OpenIcons> OPEN_ICON_MAP = Map.ofEntries(
            Map.entry('(', OpenIcons.PARENTHESIS),
            Map.entry('[', OpenIcons.BRACKETS),
            Map.entry('{', OpenIcons.BRACES),
            Map.entry('<', OpenIcons.CARRETS)
    );
    private static final int INCOMPLETE_LINE_MULTIPLIER = 5;

    private final List<Character> value;

    public Line(String input) {
        value = IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .collect(toList());
    }

    public int findCorruptionPoints() {
        Stack<Character> stack = new Stack<>();
        for (Character character : value) {
            Optional<CloseIcons> closeIcon = Optional.ofNullable(CLOSE_ICON_MAP.get(character));
            if (closeIcon.isPresent()) {
                CloseIcons icon = closeIcon.get();
                if (isSyntaxError(stack, icon)) {
                    return closeIcon.map(CloseIcons::getIllegalCloseCharacterPoints).orElse(-1);
                } else {
                    stack.pop();
                }
            } else {
                stack.push(character);
            }
        }

        return 0;
    }

    public Long findIncompletePoints() {
        Stack<Character> stack = new Stack<>();
        for (Character character : value) {
            Optional<CloseIcons> closeIcon = Optional.ofNullable(CLOSE_ICON_MAP.get(character));
            if (closeIcon.isPresent()) {
                CloseIcons icon = closeIcon.get();
                if (isSyntaxError(stack, icon)) {
                    return 0L;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(character);
            }
        }

        return processIncompleteLine(stack);
    }

    private boolean isSyntaxError(Stack<Character> stack, CloseIcons closeIcon) {
        return !stack.peek().equals(closeIcon.getOpenIcon());
    }

    private long processIncompleteLine(Stack<Character> stack) {
        long points = 0;

        while(!stack.isEmpty()){
            char nextCharacter = stack.pop();
            OpenIcons icon = OPEN_ICON_MAP.get(nextCharacter);
            points = (points * 5) + icon.getCorrectCharacterPoints();
        }

        return points;
    }
}
