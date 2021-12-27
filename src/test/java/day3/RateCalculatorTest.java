package day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static day3.Bit.ONE;
import static day3.Bit.ZERO;
import static org.assertj.core.api.Assertions.*;

class RateCalculatorTest {

    @Test
    void calculateGammaRate_OneLine() {
        List<BitLine> bitLines = List.of(new BitLine("00100"));

        assertThat(RateCalculator.calculateGammaRate(bitLines)).isEqualTo(4);
    }

    @Test
    void calculateGammaRate_ThreeLines() {
        List<BitLine> bitLines = List.of(
                new BitLine("00100"),
                new BitLine("11110"),
                new BitLine("10110")
        );

        assertThat(RateCalculator.calculateGammaRate(bitLines)).isEqualTo(22);
    }

    @Test
    void calculateGammaRate_ExampleInput() {
        List<BitLine> bitLines = List.of(
                new BitLine("00100"),
                new BitLine("11110"),
                new BitLine("10110"),
                new BitLine("10111"),
                new BitLine("10101"),
                new BitLine("01111"),
                new BitLine("00111"),
                new BitLine("11100"),
                new BitLine("10000"),
                new BitLine("11001"),
                new BitLine("00010"),
                new BitLine("01010")
        );

        assertThat(RateCalculator.calculateGammaRate(bitLines)).isEqualTo(22);
    }

    @Test
    void calculateEpsilonRate_OneLine() {
        List<BitLine> bitLines = List.of(new BitLine("00100"));

        assertThat(RateCalculator.calculateEpsilonRate(bitLines)).isEqualTo(27);
    }

    @Test
    void calculateEpsilonRate_ThreeLines() {
        List<BitLine> bitLines = List.of(
                new BitLine("00100"),
                new BitLine("11110"),
                new BitLine("10110")
        );

        assertThat(RateCalculator.calculateEpsilonRate(bitLines)).isEqualTo(9);
    }

    @Test
    void calculateEpsilonRate_ExampleInput() {
        List<BitLine> bitLines = List.of(
                new BitLine("00100"),
                new BitLine("11110"),
                new BitLine("10110"),
                new BitLine("10111"),
                new BitLine("10101"),
                new BitLine("01111"),
                new BitLine("00111"),
                new BitLine("11100"),
                new BitLine("10000"),
                new BitLine("11001"),
                new BitLine("00010"),
                new BitLine("01010")
        );

        assertThat(RateCalculator.calculateEpsilonRate(bitLines)).isEqualTo(9);
    }

    @Test
    void calculateOxygenGeneratorRate_ExampleInput() {
        List<BitLine> bitLines = List.of(
                new BitLine("00100"),
                new BitLine("11110"),
                new BitLine("10110"),
                new BitLine("10111"),
                new BitLine("10101"),
                new BitLine("01111"),
                new BitLine("00111"),
                new BitLine("11100"),
                new BitLine("10000"),
                new BitLine("11001"),
                new BitLine("00010"),
                new BitLine("01010")
        );

        assertThat(RateCalculator.calculateOxygenGeneratorRate(bitLines)).isEqualTo(23);
    }

    @Test
    void calculateCO2Scrubber_ExampleInput() {
        List<BitLine> bitLines = List.of(
                new BitLine("00100"),
                new BitLine("11110"),
                new BitLine("10110"),
                new BitLine("10111"),
                new BitLine("10101"),
                new BitLine("01111"),
                new BitLine("00111"),
                new BitLine("11100"),
                new BitLine("10000"),
                new BitLine("11001"),
                new BitLine("00010"),
                new BitLine("01010")
        );

        assertThat(RateCalculator.calculateCO2ScrubberRate(bitLines)).isEqualTo(10);
    }
}