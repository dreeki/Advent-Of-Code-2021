package day3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BitMachineTest {

    @Test
    void calculatePowerConsumption() {
        BitMachine bitMachine = new BitMachine();

        bitMachine.addBitLine("00100");
        bitMachine.addBitLine("11110");
        bitMachine.addBitLine("10110");
        bitMachine.addBitLine("10111");
        bitMachine.addBitLine("10101");
        bitMachine.addBitLine("01111");
        bitMachine.addBitLine("00111");
        bitMachine.addBitLine("11100");
        bitMachine.addBitLine("10000");
        bitMachine.addBitLine("11001");
        bitMachine.addBitLine("00010");
        bitMachine.addBitLine("01010");

        assertThat(bitMachine.calculatePowerConsumption()).isEqualTo(198);
    }

    @Test
    void calculateLifeSupportRating() {
        BitMachine bitMachine = new BitMachine();

        bitMachine.addBitLine("00100");
        bitMachine.addBitLine("11110");
        bitMachine.addBitLine("10110");
        bitMachine.addBitLine("10111");
        bitMachine.addBitLine("10101");
        bitMachine.addBitLine("01111");
        bitMachine.addBitLine("00111");
        bitMachine.addBitLine("11100");
        bitMachine.addBitLine("10000");
        bitMachine.addBitLine("11001");
        bitMachine.addBitLine("00010");
        bitMachine.addBitLine("01010");

        assertThat(bitMachine.calculateLifeSupportRating()).isEqualTo(230);
    }
}