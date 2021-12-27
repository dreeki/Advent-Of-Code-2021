package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Submarine submarine = new Submarine();

        doMovesFromInput(submarine);

        System.out.println("puzzle1: " + submarine.getMultiplication());

        Submarine complicatedSubmarine = new ComplicatedSubmarine();

        doMovesFromInput(complicatedSubmarine);

        System.out.println("puzzle2: " + complicatedSubmarine.getMultiplication());
    }

    private static void doMovesFromInput(Submarine submarine) throws IOException {
        Path path = Path.of("src", "main", "resources", "day2", "puzzle1.txt");
        Files.lines(path)
                .map(line -> line.split(" "))
                .forEach(splitted -> executeLine(submarine, splitted));
    }

    private static void executeLine(Submarine submarine, String[] splitted) {
        Direction direction = Direction.valueOf(splitted[0].toUpperCase());
        int amount = Integer.parseInt(splitted[1]);

        submarine.move(direction, amount);
    }
}
