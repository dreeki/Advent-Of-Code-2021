package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Simulation simulation = readLine();

        System.out.println("puzzle1: " + simulation.findCheapestPositionConsumptionLinear());
        System.out.println("puzzle2: " + simulation.findCheapestPositionConsumptionIncreasing());
    }

    private static Simulation readLine() throws IOException {
        Path path = Path.of("src", "main", "resources", "day7", "puzzle1.txt");
        List<String> input = Files.readAllLines(path);
        return new Simulation(input.get(0));
    }
}
