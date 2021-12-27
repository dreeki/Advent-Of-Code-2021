package day7;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Simulation {
    private final List<CrabSubmarine> crabSubmarines;

    public Simulation(String input) {
        crabSubmarines = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(CrabSubmarine::new)
                .collect(toList());
    }

    public int findCheapestPositionConsumptionLinear() {
        List<Integer> sortedHorizontalPositions = crabSubmarines.stream()
                .mapToInt(CrabSubmarine::getHorizontalPosition)
                .sorted()
                .boxed()
                .collect(toList());

        int halfSize = sortedHorizontalPositions.size() / 2;

        int medianFirst = sortedHorizontalPositions.get(halfSize - 1);
        int medianSecond = sortedHorizontalPositions.get(halfSize);

        int medianConsumptionFirst = findLinearAccumulatedFuelConsumptionForPosition(medianFirst);
        int medianConsumptionSecond = findLinearAccumulatedFuelConsumptionForPosition(medianSecond);

        return Math.min(medianConsumptionFirst, medianConsumptionSecond);
    }

    public int findCheapestPositionConsumptionIncreasing() {
        double average = crabSubmarines.stream()
                .mapToInt(CrabSubmarine::getHorizontalPosition)
                .average().orElseThrow();

        int meanFirst = (int) Math.floor(average);
        int meanSecond = (int) Math.ceil(average);

        int meanConsumptionFirst = findIncreasingAccumulatedFuelConsumptionForPosition(meanFirst);
        int meanConsumptionSecond = findIncreasingAccumulatedFuelConsumptionForPosition(meanSecond);

        return Math.min(meanConsumptionFirst, meanConsumptionSecond);
    }

    private int findLinearAccumulatedFuelConsumptionForPosition(int position) {
        return crabSubmarines.stream()
                .mapToInt(crabSubmarine -> crabSubmarine.calculateLinearFuelConsumptionToNewHorizontalPosition(position))
                .sum();
    }

    private int findIncreasingAccumulatedFuelConsumptionForPosition(int position) {
        return crabSubmarines.stream()
                .mapToInt(crabSubmarine -> crabSubmarine.calculateIncreasingFuelConsumptionToNewHorizontalPosition(position))
                .sum();
    }
}
