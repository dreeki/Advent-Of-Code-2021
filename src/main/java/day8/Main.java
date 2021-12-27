package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Notes notes = new Notes();

        readLines(notes);

        System.out.println("puzzle1: " + notes.countAccumulatedSimpleDigitsInOutput());
        System.out.println("puzzle2: " + notes.accumulateOutputs());
    }

    private static void readLines(Notes notes) throws IOException {
        Path path = Path.of("src", "main", "resources", "day8", "puzzle1.txt");
        Files.lines(path)
                .forEach(notes::addLine);
    }
}
