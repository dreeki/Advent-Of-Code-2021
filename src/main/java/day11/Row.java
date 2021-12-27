package day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static day11.Cave.SQUARE_SIZE;
import static day11.Octopus.aDummyOctopus;
import static java.util.stream.Collectors.toList;

public class Row {
    private final List<Octopus> octopusList;

    private Row() {
        octopusList = new ArrayList<>();
    }

    public Row(String input) {
        this();
        octopusList.add(aDummyOctopus());

        octopusList.addAll(Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(Octopus::new)
                .collect(toList()));

        octopusList.add(aDummyOctopus());
    }

    public static Row aDummyRow() {
        Row row = new Row();
        row.octopusList.add(aDummyOctopus());

        IntStream.range(0, SQUARE_SIZE)
                .forEach(i -> row.octopusList.add(aDummyOctopus()));

        row.octopusList.add(aDummyOctopus());
        return row;
    }

    public void incrementAllEnergyLevels() {
        octopusList.forEach(Octopus::incrementEnergyLevel);
    }

    public void resetAll() {
        octopusList.forEach(Octopus::resetDidFlash);
    }

    public Octopus getAtIndex(int i) {
        return octopusList.get(i + 1);
    }

    public int countAmountOfFlashes() {
        return octopusList.stream()
                .mapToInt(Octopus::getAmountOfFlashes)
                .sum();
    }

    public boolean didAllFlash() {
        return octopusList.stream()
                .filter(Octopus::isNotADummy)
                .allMatch(Octopus::isDidFlash);
    }
}
