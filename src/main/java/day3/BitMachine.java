package day3;

import java.util.ArrayList;
import java.util.List;

import static day3.RateCalculator.calculateCO2ScrubberRate;
import static day3.RateCalculator.calculateEpsilonRate;
import static day3.RateCalculator.calculateGammaRate;
import static day3.RateCalculator.calculateOxygenGeneratorRate;

public class BitMachine {
    private final List<BitLine> bitLines;

    public BitMachine() {
        bitLines = new ArrayList<>();
    }

    public void addBitLine(String line) {
        BitLine bitLine = new BitLine(line);

        bitLines.add(bitLine);
    }

    public int calculatePowerConsumption() {
        return calculateGammaRate(bitLines) * calculateEpsilonRate(bitLines);
    }

    public int calculateLifeSupportRating() {
        return calculateOxygenGeneratorRate(bitLines) * calculateCO2ScrubberRate(bitLines);
    }
}
