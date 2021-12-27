package day9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HeightMapTest {

    @Test
    void findLowPoints_Row() {
        HeightMap heightMap = new HeightMap();

        heightMap.addRow("2199943210");

        heightMap.findLowPoints();

        assertThat(heightMap.getRows().get(0).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(1).isLowPoint()).isTrue();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(2).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(3).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(4).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(5).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(6).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(7).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(8).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(9).isLowPoint()).isTrue();
    }

    @Test
    void findLowPoints_Column() {
        HeightMap heightMap = new HeightMap();

        heightMap.addRow("2");
        heightMap.addRow("3");
        heightMap.addRow("9");
        heightMap.addRow("8");
        heightMap.addRow("9");

        heightMap.findLowPoints();

        assertThat(heightMap.getRows().get(0).getLocationAtIndex(0).isLowPoint()).isTrue();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(0).isLowPoint()).isTrue();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(0).isLowPoint()).isFalse();
    }

    @Test
    void findLowPoints_ExampleInput() {
        HeightMap heightMap = new HeightMap();

        heightMap.addRow("2199943210");
        heightMap.addRow("3987894921");
        heightMap.addRow("9856789892");
        heightMap.addRow("8767896789");
        heightMap.addRow("9899965678");

        heightMap.findLowPoints();

        assertThat(heightMap.getRows().get(0).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(1).isLowPoint()).isTrue();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(2).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(3).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(4).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(5).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(6).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(7).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(8).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(0).getLocationAtIndex(9).isLowPoint()).isTrue();

        assertThat(heightMap.getRows().get(1).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(1).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(2).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(3).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(4).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(5).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(6).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(7).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(8).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(1).getLocationAtIndex(9).isLowPoint()).isFalse();

        assertThat(heightMap.getRows().get(2).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(1).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(2).isLowPoint()).isTrue();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(3).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(4).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(5).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(6).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(7).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(8).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(2).getLocationAtIndex(9).isLowPoint()).isFalse();

        assertThat(heightMap.getRows().get(3).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(1).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(2).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(3).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(4).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(5).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(6).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(7).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(8).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(3).getLocationAtIndex(9).isLowPoint()).isFalse();

        assertThat(heightMap.getRows().get(4).getLocationAtIndex(0).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(1).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(2).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(3).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(4).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(5).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(6).isLowPoint()).isTrue();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(7).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(8).isLowPoint()).isFalse();
        assertThat(heightMap.getRows().get(4).getLocationAtIndex(9).isLowPoint()).isFalse();
    }

    @Test
    void getSumOfRiskLevels_ExampleInput() {
        HeightMap heightMap = new HeightMap();

        heightMap.addRow("2199943210");
        heightMap.addRow("3987894921");
        heightMap.addRow("9856789892");
        heightMap.addRow("8767896789");
        heightMap.addRow("9899965678");

        heightMap.findLowPoints();

        assertThat(heightMap.getSumOfRiskLevels()).isEqualTo(15);
    }

    @Test
    void findBasins_ExampleInput() {
        HeightMap heightMap = new HeightMap();

        heightMap.addRow("2199943210");
        heightMap.addRow("3987894921");
        heightMap.addRow("9856789892");
        heightMap.addRow("8767896789");
        heightMap.addRow("9899965678");

        heightMap.findLowPoints();
        heightMap.findBasins();

        assertThat(heightMap.getBasins())
                .extracting(Basin::getBasinSize)
                .containsExactlyInAnyOrder(3, 9, 9, 14);
    }

    @Test
    void multiplyThreeBiggestBasinSizes_ExampleInput() {
        HeightMap heightMap = new HeightMap();

        heightMap.addRow("2199943210");
        heightMap.addRow("3987894921");
        heightMap.addRow("9856789892");
        heightMap.addRow("8767896789");
        heightMap.addRow("9899965678");

        heightMap.findLowPoints();
        heightMap.findBasins();

        assertThat(heightMap.multiplyThreeBiggestBasinSizes()).isEqualTo(1134);
    }
}