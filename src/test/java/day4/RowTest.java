package day4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RowTest {

    private static final int NUMBER = 6;
    private static final int OTHER_NUMBER = 8;

    @Test
    void mark_WrongNumber() {
        Row row = new Row(" 1  6 34 11 12");

        row.mark(OTHER_NUMBER);

        assertThat(row.getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(row.getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(row.getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(row.getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(row.getBingoNumbers().get(4).isMarked()).isFalse();
    }

    @Test
    void mark_RightNumber() {
        Row row = new Row(" 1  6 34 11 12");

        row.mark(NUMBER);

        assertThat(row.getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(row.getBingoNumbers().get(1).isMarked()).isTrue();
        assertThat(row.getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(row.getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(row.getBingoNumbers().get(4).isMarked()).isFalse();
    }

    @Test
    void isBingo_NoneMarked() {
        Row row = new Row(" 1  6 34 11 12");

        assertThat(row.isBingo()).isFalse();
    }

    @Test
    void isBingo_OneMarked() {
        Row row = new Row(" 1  6 34 11 12");

        row.mark(6);

        assertThat(row.isBingo()).isFalse();
    }

    @Test
    void isBingo_AllMarked() {
        Row row = new Row(" 1  6 34 11 12");

        row.mark(1);
        row.mark(6);
        row.mark(34);
        row.mark(11);
        row.mark(12);

        assertThat(row.isBingo()).isTrue();
    }
}