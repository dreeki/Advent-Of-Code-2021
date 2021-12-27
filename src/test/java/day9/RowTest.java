package day9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RowTest {

    @Test
    void getLowPoints_NoLowPoints() {
        Row row = new Row(0, "123");

        assertThat(row.getLowPoints()).isEmpty();
    }

    @Test
    void getLowPoints_ExampleInput() {
        Row row = new Row(0, "2199943210");

        row.setLocationAsLowPoint(1);
        row.setLocationAsLowPoint(9);

        assertThat(row.getLowPoints())
                .extracting(Location::getHeight)
                .containsExactly(1, 0);
    }
}