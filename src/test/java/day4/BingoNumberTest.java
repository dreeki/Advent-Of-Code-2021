package day4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BingoNumberTest {

    private static final int NUMBER = 6;
    private static final int OTHER_NUMBER = 8;

    @Test
    void mark_WrongNumber() {
        BingoNumber bingoNumber = new BingoNumber(NUMBER);

        bingoNumber.mark(OTHER_NUMBER);

        assertThat(bingoNumber.isMarked()).isFalse();
    }

    @Test
    void mark_RightNumber() {
        BingoNumber bingoNumber = new BingoNumber(NUMBER);

        bingoNumber.mark(NUMBER);

        assertThat(bingoNumber.isMarked()).isTrue();
    }
}