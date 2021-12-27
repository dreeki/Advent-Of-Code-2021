package day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Cave cave = new Cave(10);

        readLines(cave);

        cave.simulateSteps(100);
        System.out.println("puzzle1: " + cave.countAmountOfFlashes());
        System.out.println("puzzle2: " + cave.findFirstStepAllFlashing());
    }

    private static void readLines(Cave cave) throws IOException {
        Path path = Path.of("src", "main", "resources", "day11", "puzzle1.txt");
        Files.lines(path)
                .forEach(cave::addRow);
    }
}
