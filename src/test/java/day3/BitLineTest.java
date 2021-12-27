package day3;

import org.junit.jupiter.api.Test;

import static day3.Bit.ONE;
import static day3.Bit.ZERO;
import static org.assertj.core.api.Assertions.*;

class BitLineTest {

    @Test
    void parseBits() {
        BitLine bitLine = new BitLine("00100");

        assertThat(bitLine.getBits()).containsExactly(ZERO, ZERO, ONE, ZERO, ZERO);
    }

    @Test
    void toDecimal() {
        assertThat(new BitLine("10110").toDecimal()).isEqualTo(22);
        assertThat(new BitLine("01001").toDecimal()).isEqualTo(9);
    }
}