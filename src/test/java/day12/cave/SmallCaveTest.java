package day12.cave;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SmallCaveTest {

    @Test
    void canBeVisitedOnlyOnce() {
        assertThat(new SmallCave("a").canBeVisitedOnlyOnce()).isTrue();
    }

    @Test
    void canBeVisitedMultipleTimes() {
        assertThat(new SmallCave("a").canBeVisitedMultipleTimes()).isFalse();
    }
}