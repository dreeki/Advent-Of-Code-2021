package day3;

import java.util.List;
import java.util.stream.IntStream;

import static day3.Bit.ONE;
import static day3.Bit.ZERO;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

public class BitLine {
    public static int bitLineLength;

    private static List<Integer> powerOfTwoValues;
    private final List<Bit> bits;

    public BitLine(String bitString) {
        bits = bitString.chars().mapToObj(this::characterToBit).collect(toList());
        if (powerOfTwoValues == null) {
            bitLineLength = bitString.length();
            initializePowerOfTwoValues();
        }
    }

    public BitLine(List<Bit> bits) {
        this.bits = bits;
        if (powerOfTwoValues == null) {
            initializePowerOfTwoValues();
        }
    }

    public int toDecimal() {
        int decimalValue = 0;
        for (int i = 0; i < bits.size(); i++) {
            decimalValue += bits.get(i).getValue() * powerOfTwoValues.get(i);
        }
        return decimalValue;
    }

    private Bit characterToBit(int character) {
        return (char) character == '1' ? ONE : ZERO;
    }

    private void initializePowerOfTwoValues() {
        powerOfTwoValues = IntStream.iterate(1, i -> i * 2)
                .limit(bitLineLength)
                .boxed()
                .sorted(reverseOrder())
                .collect(toList());
    }

    public List<Bit> getBits() {
        return bits;
    }
}
