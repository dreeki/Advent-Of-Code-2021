package day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CaveTest {

    @Test
    void simulateSteps_1Step() {
        Cave cave = new Cave(5);

        cave.addRow("11111");
        cave.addRow("19991");
        cave.addRow("19191");
        cave.addRow("19991");
        cave.addRow("11111");

        cave.simulateSteps(1);

        assertThat(cave.getOctopusRow(0).getAtIndex(0).getEnergyLevel()).isEqualTo(3);
        assertThat(cave.getOctopusRow(0).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(1).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(0).getAtIndex(1).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(2).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(0).getAtIndex(2).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(3).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(0).getAtIndex(3).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(4).getEnergyLevel()).isEqualTo(3);
        assertThat(cave.getOctopusRow(0).getAtIndex(4).isDidFlash()).isFalse();

        assertThat(cave.getOctopusRow(1).getAtIndex(0).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(1).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(1).getAtIndex(1).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(1).getAtIndex(1).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(1).getAtIndex(2).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(1).getAtIndex(2).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(1).getAtIndex(3).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(1).getAtIndex(3).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(1).getAtIndex(4).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(1).getAtIndex(4).isDidFlash()).isFalse();

        assertThat(cave.getOctopusRow(2).getAtIndex(0).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(2).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(2).getAtIndex(1).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(2).getAtIndex(1).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(2).getAtIndex(2).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(2).getAtIndex(2).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(2).getAtIndex(3).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(2).getAtIndex(3).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(2).getAtIndex(4).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(2).getAtIndex(4).isDidFlash()).isFalse();

        assertThat(cave.getOctopusRow(3).getAtIndex(0).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(3).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(3).getAtIndex(1).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(3).getAtIndex(1).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(3).getAtIndex(2).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(3).getAtIndex(2).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(3).getAtIndex(3).getEnergyLevel()).isEqualTo(0);
        assertThat(cave.getOctopusRow(3).getAtIndex(3).isDidFlash()).isTrue();
        assertThat(cave.getOctopusRow(3).getAtIndex(4).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(3).getAtIndex(4).isDidFlash()).isFalse();

        assertThat(cave.getOctopusRow(4).getAtIndex(0).getEnergyLevel()).isEqualTo(3);
        assertThat(cave.getOctopusRow(4).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(1).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(4).getAtIndex(1).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(2).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(4).getAtIndex(2).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(3).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(4).getAtIndex(3).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(4).getEnergyLevel()).isEqualTo(3);
        assertThat(cave.getOctopusRow(4).getAtIndex(4).isDidFlash()).isFalse();
    }

    @Test
    void simulateSteps_2Steps() {
        Cave cave = new Cave(5);

        cave.addRow("11111");
        cave.addRow("19991");
        cave.addRow("19191");
        cave.addRow("19991");
        cave.addRow("11111");

        cave.simulateSteps(2);

        assertThat(cave.getOctopusRow(0).getAtIndex(0).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(0).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(0).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(0).getAtIndex(1).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(0).getAtIndex(1).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(1).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(0).getAtIndex(2).getEnergyLevel()).isEqualTo(6);
        assertThat(cave.getOctopusRow(0).getAtIndex(2).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(2).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(0).getAtIndex(3).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(0).getAtIndex(3).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(3).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(0).getAtIndex(4).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(0).getAtIndex(4).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(0).getAtIndex(4).getAmountOfFlashes()).isZero();

        assertThat(cave.getOctopusRow(1).getAtIndex(0).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(1).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(1).getAtIndex(0).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(1).getAtIndex(1).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(1).getAtIndex(1).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(1).getAtIndex(1).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(1).getAtIndex(2).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(1).getAtIndex(2).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(1).getAtIndex(2).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(1).getAtIndex(3).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(1).getAtIndex(3).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(1).getAtIndex(3).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(1).getAtIndex(4).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(1).getAtIndex(4).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(1).getAtIndex(4).getAmountOfFlashes()).isZero();

        assertThat(cave.getOctopusRow(2).getAtIndex(0).getEnergyLevel()).isEqualTo(6);
        assertThat(cave.getOctopusRow(2).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(2).getAtIndex(0).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(2).getAtIndex(1).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(2).getAtIndex(1).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(2).getAtIndex(1).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(2).getAtIndex(2).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(2).getAtIndex(2).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(2).getAtIndex(2).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(2).getAtIndex(3).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(2).getAtIndex(3).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(2).getAtIndex(3).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(2).getAtIndex(4).getEnergyLevel()).isEqualTo(6);
        assertThat(cave.getOctopusRow(2).getAtIndex(4).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(2).getAtIndex(4).getAmountOfFlashes()).isZero();

        assertThat(cave.getOctopusRow(3).getAtIndex(0).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(3).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(3).getAtIndex(0).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(3).getAtIndex(1).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(3).getAtIndex(1).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(3).getAtIndex(1).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(3).getAtIndex(2).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(3).getAtIndex(2).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(3).getAtIndex(2).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(3).getAtIndex(3).getEnergyLevel()).isEqualTo(1);
        assertThat(cave.getOctopusRow(3).getAtIndex(3).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(3).getAtIndex(3).getAmountOfFlashes()).isOne();
        assertThat(cave.getOctopusRow(3).getAtIndex(4).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(3).getAtIndex(4).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(3).getAtIndex(4).getAmountOfFlashes()).isZero();

        assertThat(cave.getOctopusRow(4).getAtIndex(0).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(4).getAtIndex(0).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(0).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(4).getAtIndex(1).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(4).getAtIndex(1).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(1).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(4).getAtIndex(2).getEnergyLevel()).isEqualTo(6);
        assertThat(cave.getOctopusRow(4).getAtIndex(2).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(2).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(4).getAtIndex(3).getEnergyLevel()).isEqualTo(5);
        assertThat(cave.getOctopusRow(4).getAtIndex(3).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(3).getAmountOfFlashes()).isZero();
        assertThat(cave.getOctopusRow(4).getAtIndex(4).getEnergyLevel()).isEqualTo(4);
        assertThat(cave.getOctopusRow(4).getAtIndex(4).isDidFlash()).isFalse();
        assertThat(cave.getOctopusRow(4).getAtIndex(4).getAmountOfFlashes()).isZero();
    }

    @Test
    void countAmountOfFlashes_ExampleInput() {
        Cave cave = new Cave(10);

        cave.addRow("5483143223");
        cave.addRow("2745854711");
        cave.addRow("5264556173");
        cave.addRow("6141336146");
        cave.addRow("6357385478");
        cave.addRow("4167524645");
        cave.addRow("2176841721");
        cave.addRow("6882881134");
        cave.addRow("4846848554");
        cave.addRow("5283751526");

        cave.simulateSteps(100);

        assertThat(cave.countAmountOfFlashes()).isEqualTo(1656);
    }

    @Test
    void findFirstStepAllFlashing_ExampleInput() {
        Cave cave = new Cave(10);

        cave.addRow("5483143223");
        cave.addRow("2745854711");
        cave.addRow("5264556173");
        cave.addRow("6141336146");
        cave.addRow("6357385478");
        cave.addRow("4167524645");
        cave.addRow("2176841721");
        cave.addRow("6882881134");
        cave.addRow("4846848554");
        cave.addRow("5283751526");

        assertThat(cave.findFirstStepAllFlashing()).isEqualTo(195);
    }
}