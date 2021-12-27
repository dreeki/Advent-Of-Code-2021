package day12.cave;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BigCaveTest {

    @Test
    void canBeVisitedOnlyOnce() {
        assertThat(new BigCave("A").canBeVisitedOnlyOnce()).isFalse();
    }

    @Test
    void canBeVisitedMultipleTimes() {
        assertThat(new BigCave("A").canBeVisitedMultipleTimes()).isTrue();
    }
}