package day11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static day11.Row.aDummyRow;

public class Cave {
    public static int SQUARE_SIZE = 10;

    private final List<Row> octopusRows;

    public Cave(int squareSize) {
        SQUARE_SIZE = squareSize;

        octopusRows = new ArrayList<>();
        octopusRows.add(aDummyRow());
    }

    public void simulateSteps(int amountOfSteps){
        octopusRows.add(aDummyRow());
        IntStream.range(0, amountOfSteps)
                .forEach(i -> doStep());
    }

    public int countAmountOfFlashes() {
        return octopusRows.stream()
                .mapToInt(Row::countAmountOfFlashes)
                .sum();
    }

    public int findFirstStepAllFlashing() {
        octopusRows.add(aDummyRow());
        int amountOfStepsUntilAllFlashed = 100;
        boolean allFlashed = false;
        while(!allFlashed) {
            amountOfStepsUntilAllFlashed++;
            doStep();
            allFlashed = didAllFlash();
        }
        return amountOfStepsUntilAllFlashed;
    }

    private boolean didAllFlash() {
        return octopusRows.stream().allMatch(Row::didAllFlash);
    }

    private void doStep() {
        resetAll();
        incrementAllEnergyLevels();
        startFlashing();
    }

    private void startFlashing() {
        for(int row = 0; row < SQUARE_SIZE; row++) {
            for(int col = 0; col < SQUARE_SIZE; col++) {
                tryFlash(row, col);
            }
        }
    }

    private void tryFlash(int row, int col) {
        Octopus octopus = getOctopusRow(row).getAtIndex(col);
        if(octopus.mustFlash()) {
            List<Location> octopusAroundCurrentLocations = List.of(
                    new Location(row - 1, col - 1),
                    new Location(row - 1, col),
                    new Location(row - 1, col + 1),
                    new Location(row, col - 1),
                    new Location(row, col + 1),
                    new Location(row + 1, col - 1),
                    new Location(row + 1, col),
                    new Location(row + 1, col + 1)
            );
            octopus.flash();

            octopusAroundCurrentLocations
                    .forEach(location -> {
                        Octopus o = getOctopusRow(location.row).getAtIndex(location.col);
                        o.incrementEnergyLevel();
                        tryFlash(location.row, location.col);
                    });
        }
    }

    private void incrementAllEnergyLevels() {
        octopusRows.forEach(Row::incrementAllEnergyLevels);
    }

    private void resetAll() {
        octopusRows.forEach(Row::resetAll);
    }

    public void addRow(String input) {
        octopusRows.add(new Row(input));
    }

    public Row getOctopusRow(int i) {
        return octopusRows.get(i + 1);
    }

    private static record Location(int row, int col) {}
}
