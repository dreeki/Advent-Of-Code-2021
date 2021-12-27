package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        HydrotermalVentField hydrotermalVentField = new HydrotermalVentField();

        readLines(hydrotermalVentField);

        System.out.println("puzzle1: " + hydrotermalVentField.getNumberOfPointsWithAtLeastTwoOverlappingLines(false));
        System.out.println("puzzle2: " + hydrotermalVentField.getNumberOfPointsWithAtLeastTwoOverlappingLines(true));
    }

    private static void readLines(HydrotermalVentField hydrotermalVentField) throws IOException {
        Path path = Path.of("src", "main", "resources", "day5", "puzzle1.txt");
        Files.lines(path)
                .forEach(hydrotermalVentField::addLine);
    }
}
