package day5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HydrotermalVentFieldTest {

    @Test
    void getNumberOfPointsWithAtLeastTwoOverlappingLines_WithoutDiagonal() {
        HydrotermalVentField hydrotermalVentField = new HydrotermalVentField();

        hydrotermalVentField.addLine("0,9 -> 5,9");
        hydrotermalVentField.addLine("8,0 -> 0,8");
        hydrotermalVentField.addLine("9,4 -> 3,4");
        hydrotermalVentField.addLine("2,2 -> 2,1");
        hydrotermalVentField.addLine("7,0 -> 7,4");
        hydrotermalVentField.addLine("6,4 -> 2,0");
        hydrotermalVentField.addLine("0,9 -> 2,9");
        hydrotermalVentField.addLine("3,4 -> 1,4");
        hydrotermalVentField.addLine("0,0 -> 8,8");
        hydrotermalVentField.addLine("5,5 -> 8,2");

        assertThat(hydrotermalVentField.getNumberOfPointsWithAtLeastTwoOverlappingLines(false)).isEqualTo(5);
    }

    @Test
    void getNumberOfPointsWithAtLeastTwoOverlappingLines_WithDiagonal() {
        HydrotermalVentField hydrotermalVentField = new HydrotermalVentField();

        hydrotermalVentField.addLine("0,9 -> 5,9");
        hydrotermalVentField.addLine("8,0 -> 0,8");
        hydrotermalVentField.addLine("9,4 -> 3,4");
        hydrotermalVentField.addLine("2,2 -> 2,1");
        hydrotermalVentField.addLine("7,0 -> 7,4");
        hydrotermalVentField.addLine("6,4 -> 2,0");
        hydrotermalVentField.addLine("0,9 -> 2,9");
        hydrotermalVentField.addLine("3,4 -> 1,4");
        hydrotermalVentField.addLine("0,0 -> 8,8");
        hydrotermalVentField.addLine("5,5 -> 8,2");

        assertThat(hydrotermalVentField.getNumberOfPointsWithAtLeastTwoOverlappingLines(true)).isEqualTo(12);
    }
}