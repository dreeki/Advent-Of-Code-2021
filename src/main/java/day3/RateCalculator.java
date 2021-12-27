package day3;

import java.util.List;
import java.util.stream.IntStream;

import static day3.Bit.ONE;
import static day3.Bit.ZERO;
import static java.util.stream.Collectors.toList;

public class RateCalculator {
    private RateCalculator() {
    }

    public static int calculateGammaRate(List<BitLine> bitLines) {
        int halfAmountOfLines = bitLines.size() / 2;
        List<Integer> sumOfBits = getSumOfBits(bitLines);
        List<Bit> gammaRatePrep = sumOfBits.stream()
                .map(sum -> sum > halfAmountOfLines ? ONE : ZERO)
                .collect(toList());
        BitLine gammaRate = new BitLine(gammaRatePrep);

        return gammaRate.toDecimal();
    }

    public static int calculateEpsilonRate(List<BitLine> bitLines) {
        int halfAmountOfLines = bitLines.size() / 2;
        List<Integer> sumOfBits = getSumOfBits(bitLines);
        List<Bit> epsilonRatePrep = sumOfBits.stream()
                .map(sum -> sum > halfAmountOfLines ? ZERO : ONE)
                .collect(toList());
        BitLine epsilonRate = new BitLine(epsilonRatePrep);

        return epsilonRate.toDecimal();
    }

    public static int calculateOxygenGeneratorRate(List<BitLine> bitLines) {
        for(int i = 0; i < BitLine.bitLineLength; i++) {
            int position = i;
            int halfAmountOfLines = (int) Math.ceil(bitLines.size() * 1.0 / 2);
            int sum = getSumOfBits(bitLines, i);
            Bit bit = sum >= halfAmountOfLines ? ONE : ZERO;

            bitLines = bitLines.stream()
                    .filter(bitLine -> bitOnPositionIsSame(bitLine, position, bit))
                    .collect(toList());

            if(bitLines.size() < 2) {
                break;
            }
        }
        return bitLines.get(0).toDecimal();
    }

    public static int calculateCO2ScrubberRate(List<BitLine> bitLines) {
        for(int i = 0; i < BitLine.bitLineLength; i++) {
            int position = i;
            int halfAmountOfLines = (int) Math.ceil(bitLines.size() * 1.0 / 2);
            int sum = getSumOfBits(bitLines, i);
            Bit bit = sum >= halfAmountOfLines ? ZERO : ONE;

            bitLines = bitLines.stream()
                    .filter(bitLine -> bitOnPositionIsSame(bitLine, position, bit))
                    .collect(toList());

            if(bitLines.size() < 2) {
                break;
            }
        }
        return bitLines.get(0).toDecimal();
    }

    private static boolean bitOnPositionIsSame(BitLine bitLine, int position, Bit bit) {
        return bitLine.getBits().get(position).equals(bit);
    }

    private static List<Integer> getSumOfBits(List<BitLine> bitLines) {
        List<List<Integer>> bitValues = bitLines.stream()
                .map(BitLine::getBits)
                .map(RateCalculator::mapBitsToInts)
                .collect(toList());
        List<Integer> sumOfBits = IntStream.generate(() -> 0)
                .limit(BitLine.bitLineLength)
                .boxed()
                .collect(toList());
        for (List<Integer> bits : bitValues) {
            for (int i = 0; i < bits.size(); i++) {
                sumOfBits.set(i, sumOfBits.get(i) + bits.get(i));
            }
        }

        return sumOfBits;
    }

    private static int getSumOfBits(List<BitLine> bitLines, int position) {
        List<List<Integer>> bitValues = bitLines.stream()
                .map(BitLine::getBits)
                .map(RateCalculator::mapBitsToInts)
                .collect(toList());
        int sum = 0;
        for (List<Integer> bits : bitValues) {
            sum += bits.get(position);
        }

        return sum;
    }

    private static List<Integer> mapBitsToInts(List<Bit> bits) {
        return bits.stream()
                .mapToInt(Bit::getValue)
                .boxed()
                .collect(toList());
    }
}
