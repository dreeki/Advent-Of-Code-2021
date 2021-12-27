package day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    void construction() {
        assertThat(new Point("0,9")).isEqualTo(new Point(0, 9));
    }

    @Test
    void hasSameX() {
        assertThat(new Point(5, 7).hasSameX(new Point(5, 12))).isTrue();
        assertThat(new Point(5, 7).hasSameX(new Point(10, 7))).isFalse();
    }

    @Test
    void hasSameY() {
        assertThat(new Point(5, 7).hasSameY(new Point(5, 12))).isFalse();
        assertThat(new Point(5, 7).hasSameY(new Point(10, 7))).isTrue();
    }

    @Test
    void getPointsExcludingDiagonalBetween_HorizontalLine() {
        Point first = new Point(5, 7);
        Point second = new Point(8, 7);

        assertThat(first.getPointsExcludingDiagonalBetween(second)).containsExactlyInAnyOrder(
                first,
                new Point(6, 7),
                new Point(7, 7),
                second
        );
    }

    @Test
    void getPointsExcludingDiagonalBetween_HorizontalLine_Reversed() {
        Point first = new Point(5, 7);
        Point second = new Point(8, 7);

        assertThat(second.getPointsExcludingDiagonalBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(6, 7),
                new Point(7, 7),
                second
        );
    }

    @Test
    void getPointsExcludingDiagonalBetween_VerticalLine() {
        Point first = new Point(5, 7);
        Point second = new Point(5, 10);

        assertThat(first.getPointsExcludingDiagonalBetween(second)).containsExactlyInAnyOrder(
                first,
                new Point(5, 8),
                new Point(5, 9),
                second
        );
    }

    @Test
    void getPointsExcludingDiagonalBetween_VerticalLine_Reversed() {
        Point first = new Point(5, 7);
        Point second = new Point(5, 10);

        assertThat(second.getPointsExcludingDiagonalBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(5, 8),
                new Point(5, 9),
                second
        );
    }

    @Test
    void getPointsExcludingDiagonalBetween_Diagonal() {
        Point first = new Point(8, 0);
        Point second = new Point(0, 8);

        assertThat(second.getPointsExcludingDiagonalBetween(first)).isEmpty();
    }

    @Test
    void getPointsBetween_HorizontalLine() {
        Point first = new Point(5, 7);
        Point second = new Point(8, 7);

        assertThat(first.getPointsBetween(second)).containsExactlyInAnyOrder(
                first,
                new Point(6, 7),
                new Point(7, 7),
                second
        );
    }

    @Test
    void getPointsBetween_HorizontalLine_Reversed() {
        Point first = new Point(5, 7);
        Point second = new Point(8, 7);

        assertThat(second.getPointsBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(6, 7),
                new Point(7, 7),
                second
        );
    }

    @Test
    void getPointsBetween_VerticalLine() {
        Point first = new Point(5, 7);
        Point second = new Point(5, 10);

        assertThat(first.getPointsBetween(second)).containsExactlyInAnyOrder(
                first,
                new Point(5, 8),
                new Point(5, 9),
                second
        );
    }

    @Test
    void getPointsBetween_VerticalLine_Reversed() {
        Point first = new Point(5, 7);
        Point second = new Point(5, 10);

        assertThat(second.getPointsBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(5, 8),
                new Point(5, 9),
                second
        );
    }

    @Test
    void getPointsBetween_Diagonal_BothIncrease() {
        Point first = new Point(1, 1);
        Point second = new Point(3, 3);

        assertThat(second.getPointsBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(2, 2),
                second
        );
    }

    @Test
    void getPointsBetween_Diagonal_XIncrease_YDecrease() {
        Point first = new Point(1, 3);
        Point second = new Point(3, 1);

        assertThat(second.getPointsBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(2, 2),
                second
        );
    }

    @Test
    void getPointsBetween_Diagonal_XDecrease_YIncrease() {
        Point first = new Point(3, 1);
        Point second = new Point(1, 3);

        assertThat(second.getPointsBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(2, 2),
                second
        );
    }

    @Test
    void getPointsBetween_Diagonal_BothDecrease() {
        Point first = new Point(3, 3);
        Point second = new Point(1, 1);

        assertThat(second.getPointsBetween(first)).containsExactlyInAnyOrder(
                first,
                new Point(2, 2),
                second
        );
    }
}