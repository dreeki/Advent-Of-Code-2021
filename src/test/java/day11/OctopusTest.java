package day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OctopusTest {

    private static final int TOO_LOW_ENERGY_LEVEL = 5;
    private static final int HIGH_ENOUGH_ENERGY_LEVEL = 10;

    @Test
    void incrementEnergyLevel_NotYetFlashed() {
        Octopus octopus = new Octopus(TOO_LOW_ENERGY_LEVEL);

        octopus.incrementEnergyLevel();

        assertThat(octopus.getEnergyLevel()).isEqualTo(TOO_LOW_ENERGY_LEVEL + 1);
    }

    @Test
    void incrementEnergyLevel_Flashed() {
        Octopus octopus = new Octopus(HIGH_ENOUGH_ENERGY_LEVEL);
        octopus.flash();

        octopus.incrementEnergyLevel();

        assertThat(octopus.getEnergyLevel()).isZero();
    }

    @Test
    void resetDidFlash() {
        Octopus octopus = new Octopus(HIGH_ENOUGH_ENERGY_LEVEL);
        octopus.flash();

        octopus.resetDidFlash();

        assertThat(octopus.isDidFlash()).isFalse();
    }

    @Test
    void mustFlash() {
        assertThat(new Octopus(0).mustFlash()).isFalse();
        assertThat(new Octopus(1).mustFlash()).isFalse();
        assertThat(new Octopus(2).mustFlash()).isFalse();
        assertThat(new Octopus(3).mustFlash()).isFalse();
        assertThat(new Octopus(4).mustFlash()).isFalse();
        assertThat(new Octopus(5).mustFlash()).isFalse();
        assertThat(new Octopus(6).mustFlash()).isFalse();
        assertThat(new Octopus(7).mustFlash()).isFalse();
        assertThat(new Octopus(8).mustFlash()).isFalse();
        assertThat(new Octopus(9).mustFlash()).isFalse();
        assertThat(new Octopus(10).mustFlash()).isTrue();
    }

    @Test
    void flash_TooLow() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Octopus(TOO_LOW_ENERGY_LEVEL).flash())
                .withMessage("this should not happen");
    }

    @Test
    void flash_EnoughEnergy() {
        Octopus octopus = new Octopus(HIGH_ENOUGH_ENERGY_LEVEL);

        octopus.flash();

        assertThat(octopus.isDidFlash()).isTrue();
        assertThat(octopus.getAmountOfFlashes()).isOne();
        assertThat(octopus.isDidFlash()).isTrue();
    }
}