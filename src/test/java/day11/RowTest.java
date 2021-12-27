package day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RowTest {

    @Test
    void incrementAllEnergyLevels() {
        Row row = new Row("34543");

        row.incrementAllEnergyLevels();

        assertThat(row.getAtIndex(0).getEnergyLevel()).isEqualTo(4);
        assertThat(row.getAtIndex(1).getEnergyLevel()).isEqualTo(5);
        assertThat(row.getAtIndex(2).getEnergyLevel()).isEqualTo(6);
        assertThat(row.getAtIndex(3).getEnergyLevel()).isEqualTo(5);
        assertThat(row.getAtIndex(4).getEnergyLevel()).isEqualTo(4);
    }
}