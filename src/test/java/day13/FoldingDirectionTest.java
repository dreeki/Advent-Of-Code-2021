package day13;

import org.junit.jupiter.api.Test;

import static day13.FoldingDirection.HORIZONTAL;
import static day13.FoldingDirection.VERTICAL;
import static org.assertj.core.api.Assertions.*;

class FoldingDirectionTest {

    @Test
    void findDirection() {
        assertThat(FoldingDirection.findDirection("y")).isEqualTo(VERTICAL);
        assertThat(FoldingDirection.findDirection("x")).isEqualTo(HORIZONTAL);

        assertThatIllegalArgumentException().isThrownBy(() -> FoldingDirection.findDirection("xy"));
    }
}