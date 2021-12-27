package day12.cave;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CaveTest {

    @Test
    void link() {
        Cave caveFirst = CaveFactory.makeCave("a");
        Cave caveSecond = CaveFactory.makeCave("b");

        caveFirst.link(caveSecond);

        assertThat(caveFirst.getReachableCaves())
                .hasSize(1)
                .containsExactly(caveSecond);
        assertThat(caveSecond.getReachableCaves())
                .hasSize(1)
                .containsExactly(caveFirst);
    }
}