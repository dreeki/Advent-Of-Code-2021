package day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        HeightMap heightMap = new HeightMap();

        readLines(heightMap);
        heightMap.findLowPoints();

        System.out.println("puzzle1: " + heightMap.getSumOfRiskLevels());

        heightMap.findBasins();

        System.out.println("puzzle2: " + heightMap.multiplyThreeBiggestBasinSizes());
    }

    private static void readLines(HeightMap heightMap) throws IOException {
        Path path = Path.of("src", "main", "resources", "day9", "puzzle1.txt");
        Files.lines(path)
                .forEach(heightMap::addRow);
    }
}
