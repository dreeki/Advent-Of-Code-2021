package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        DepthProcessor depthProcessor = new DepthProcessor();
        addDepthsFromInput(depthProcessor);

        System.out.println("puzzle1: " + depthProcessor.calculateAmountOfIncreases());
        System.out.println("puzzle2: " + depthProcessor.calculateAmountOfWindowIncreases());
    }

    private static void addDepthsFromInput(DepthProcessor depthProcessor) throws IOException {
        Path path = Path.of("src", "main", "resources", "day1", "puzzle1.txt");
        Files.lines(path)
                .mapToInt(Integer::parseInt)
                .forEach(depthProcessor::addDepthNumber);
    }
}
