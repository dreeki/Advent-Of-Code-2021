package day7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrabSubmarineTest {
    private static final int DISTANCE = 5;

    private static final CrabSubmarine CRAB_SUBMARINE = new CrabSubmarine(DISTANCE);

    @Test
    void calculateFuelConsumptionToNewHorizontalPosition() {
        assertThat(CRAB_SUBMARINE.calculateLinearFuelConsumptionToNewHorizontalPosition(0)).isEqualTo(DISTANCE);

        assertThat(CRAB_SUBMARINE.calculateLinearFuelConsumptionToNewHorizontalPosition(2 * DISTANCE)).isEqualTo(DISTANCE);
    }

    @Test
    void calculateIncreasingFuelConsumptionToNewHorizontalPosition() {
        assertThat(CRAB_SUBMARINE.calculateIncreasingFuelConsumptionToNewHorizontalPosition(0)).isEqualTo(15);

        assertThat(CRAB_SUBMARINE.calculateIncreasingFuelConsumptionToNewHorizontalPosition(2 * DISTANCE)).isEqualTo(15);

        assertThat(CRAB_SUBMARINE.calculateIncreasingFuelConsumptionToNewHorizontalPosition(DISTANCE + 11)).isEqualTo(66);
    }
}