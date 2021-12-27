package day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        CavePathingOrchestrator cavePathingOrchestrator = new CavePathingOrchestrator();

        readLines(cavePathingOrchestrator);

        cavePathingOrchestrator.processInput();

        System.out.println("puzzle1: " + cavePathingOrchestrator.getAmountOfPathsToEnd());
        System.out.println("puzzle2: " + cavePathingOrchestrator.getAmountOfPathsToEndWithExtraTime());
    }

    private static void readLines(CavePathingOrchestrator cavePathingOrchestrator) throws IOException {
        Path path = Path.of("src", "main", "resources", "day12", "puzzle1.txt");
        Files.lines(path)
                .forEach(cavePathingOrchestrator::addInputLine);
    }
}
