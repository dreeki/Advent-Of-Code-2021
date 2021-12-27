package day12.cave;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CaveFactoryTest {

    @Test
    void makeCave() {
        assertThat(CaveFactory.makeCave("a")).isInstanceOf(SmallCave.class);
        assertThat(CaveFactory.makeCave("A")).isInstanceOf(BigCave.class);
    }
}