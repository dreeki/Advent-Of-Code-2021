package day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

    private static final int NUMBER = 6;
    private static final int OTHER_NUMBER = 40;

    @Test
    void mark_WrongNumber() {
        List<String> inputs = List.of(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19"
        );
        Board board = new Board(inputs);

        board.mark(OTHER_NUMBER);

        assertThat(board.getRows().get(0).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(1).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(2).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(3).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(3).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(3).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(3).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(3).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(4).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(4).isMarked()).isFalse();
    }

    @Test
    void mark_RightNumber() {
        List<String> inputs = List.of(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19"
        );
        Board board = new Board(inputs);

        board.mark(NUMBER);

        assertThat(board.getRows().get(0).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(0).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(1).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(1).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(2).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(2).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(3).getBingoNumbers().get(0).isMarked()).isTrue();
        assertThat(board.getRows().get(3).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(3).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(3).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(3).getBingoNumbers().get(4).isMarked()).isFalse();

        assertThat(board.getRows().get(4).getBingoNumbers().get(0).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(1).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(2).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(3).isMarked()).isFalse();
        assertThat(board.getRows().get(4).getBingoNumbers().get(4).isMarked()).isFalse();
    }

    @Test
    void isBingo_NotAllMarked() {
        List<String> inputs = List.of(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19"
        );
        Board board = new Board(inputs);

        board.mark(6);
        board.mark(3);
        board.mark(13);

        assertThat(board.isBingo()).isFalse();
    }

    @Test
    void isBingo_RowBingo() {
        List<String> inputs = List.of(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19"
        );
        Board board = new Board(inputs);

        board.mark(6);
        board.mark(10);
        board.mark(3);
        board.mark(18);
        board.mark(5);

        assertThat(board.isBingo()).isTrue();
    }

    @Test
    void isBingo_ColumnBingo() {
        List<String> inputs = List.of(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19"
        );
        Board board = new Board(inputs);

        board.mark(17);
        board.mark(23);
        board.mark(14);
        board.mark(3);
        board.mark(20);

        assertThat(board.isBingo()).isTrue();
    }

    @Test
    void getSumOfUnmarkedNumbers() {
        List<String> inputs = List.of(
                "22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19"
        );
        Board board = new Board(inputs);

        board.mark(22);
        board.mark(1);
        board.mark(19);
        board.mark(17);
        board.mark(23);
        board.mark(14);
        board.mark(3);
        board.mark(20);

        assertThat(board.getSumOfUnmarkedNumbers()).isEqualTo(181);
    }
}