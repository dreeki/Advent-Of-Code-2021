package day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        NavigationSubsystem navigationSubsystem = new NavigationSubsystem();

        readLines(navigationSubsystem);

        System.out.println("puzzle1: " + navigationSubsystem.accumulateCorruptionPoints());
        System.out.println("puzzle2: " + navigationSubsystem.findMiddleOfIncompletePoints());
    }

    private static void readLines(NavigationSubsystem navigationSubsystem) throws IOException {
        Path path = Path.of("src", "main", "resources", "day10", "puzzle1.txt");
        Files.lines(path)
                .forEach(navigationSubsystem::addLine);
    }
}
