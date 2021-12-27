package day6;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class LanternFishTest {

    @Test
    void processDay_StartAt8() {
        LanternFish fish = new LanternFish(8);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(7);
    }

    @Test
    void processDay_StartAt7() {
        LanternFish fish = new LanternFish(7);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(6);
    }

    @Test
    void processDay_StartAt6() {
        LanternFish fish = new LanternFish(6);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(5);
    }

    @Test
    void processDay_StartAt5() {
        LanternFish fish = new LanternFish(5);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(4);
    }

    @Test
    void processDay_StartAt4() {
        LanternFish fish = new LanternFish(4);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(3);
    }

    @Test
    void processDay_StartAt3() {
        LanternFish fish = new LanternFish(3);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(2);
    }

    @Test
    void processDay_StartAt2() {
        LanternFish fish = new LanternFish(2);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(1);
    }

    @Test
    void processDay_StartAt1() {
        LanternFish fish = new LanternFish(1);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish).isEmpty();
        assertThat(fish.getInternalTimer()).isEqualTo(0);
    }

    @Test
    void processDay_StartAt0() {
        LanternFish fish = new LanternFish(0);

        Optional<LanternFish> newFish = fish.processDay();

        assertThat(newFish)
                .isPresent()
                .contains(new LanternFish(8));
        assertThat(fish.getInternalTimer()).isEqualTo(6);
    }
}