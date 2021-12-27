package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        BitMachine bitMachine = new BitMachine();

        readBitLines(bitMachine);

        System.out.println("puzzle1: " + bitMachine.calculatePowerConsumption());
        System.out.println("puzzle2: " + bitMachine.calculateLifeSupportRating());
    }

    private static void readBitLines(BitMachine bitMachine) throws IOException {
        Path path = Path.of("src", "main", "resources", "day3", "puzzle1.txt");
        Files.lines(path)
                .forEach(bitMachine::addBitLine);
    }
}
