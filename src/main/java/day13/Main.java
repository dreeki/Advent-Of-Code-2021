package day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TransparentPaper transparentPaper = new TransparentPaper();

        readLines(transparentPaper);

        transparentPaper.executeFoldInstruction();

        System.out.println("puzzle1: " + transparentPaper.getAmountOfDots());

        transparentPaper.executeAllAfterFirstFoldInstruction();

        System.out.println("puzzle2: ");
        transparentPaper.whatDoWeSee();
    }

    private static void readLines(TransparentPaper transparentPaper) throws IOException {
        Path path = Path.of("src", "main", "resources", "day13", "puzzle1.txt");
        List<String> input = Files.readAllLines(path);

        input.stream()
                .filter(Main::removeBlankLine)
                .filter(Main::isCoordinatesLine)
                .forEach(transparentPaper::addDot);

        input.stream()
                .filter(Main::removeBlankLine)
                .filter(Main::isFoldInstructionLine)
                .forEach(transparentPaper::addFoldInstruction);
    }

    private static boolean removeBlankLine(String s) {
        return !s.trim().isBlank();
    }

    private static boolean isCoordinatesLine(String input) {
        return input.split(" ").length == 1;
    }

    private static boolean isFoldInstructionLine(String input) {
        return input.split(" ").length == 3;
    }
}
