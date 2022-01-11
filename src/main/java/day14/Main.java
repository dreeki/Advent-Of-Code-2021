package day14;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Polymer polymer = readLines();
        polymer.initializePairs();
        polymer.doIterations(10);

        System.out.println("puzzle1: " + polymer.getResult());

        Polymer polymer2 = readLines();
        polymer2.initializePairs();
        polymer2.doIterations(40);

        System.out.println("puzzle2: " + polymer2.getResult());
    }

    private static Polymer readLines() throws IOException {
        Path path = Path.of("src", "main", "resources", "day14", "puzzle1.txt");
        List<String> input = Files.readAllLines(path);

        Polymer polymer = new Polymer(input.get(0));

        for(int i = 2; i < input.size(); i++) {
            polymer.addPairInsertionRule(input.get(i));
        }

        return polymer;
    }
}
