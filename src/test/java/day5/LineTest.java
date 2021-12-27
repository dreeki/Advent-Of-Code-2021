package day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void construction_Vertical() {
        Line lineVertical = new Line("1,1 -> 1,3");

        assertThat(lineVertical.getPointsExcludingDiagonal()).containsExactlyInAnyOrder(
                new Point(1, 1),
                new Point(1, 2),
                new Point(1, 3)
        );
    }

    @Test
    void construction_Horizontal() {
        Line lineHorizontal = new Line("9,7 -> 7,7");

        assertThat(lineHorizontal.getPointsExcludingDiagonal()).containsExactlyInAnyOrder(
                new Point(9, 7),
                new Point(8, 7),
                new Point(7, 7)
        );
    }
}