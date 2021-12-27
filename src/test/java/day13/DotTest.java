package day13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DotTest {
    private static final FoldInstruction FOLD_INSTRUCTION_VERTICAL = new FoldInstruction("fold along y=7");
    private static final FoldInstruction FOLD_INSTRUCTION_HORIZONTAL = new FoldInstruction("fold along x=5");

    @Test
    void executeFoldInstruction_TopLeft_Vertical() {
        Dot dot = new Dot("0,0");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_VERTICAL);

        assertThat(dot.getX()).isEqualTo(0);
        assertThat(dot.getY()).isEqualTo(0);
    }

    @Test
    void executeFoldInstruction_TopLeft_Horizontal() {
        Dot dot = new Dot("0,0");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_HORIZONTAL);

        assertThat(dot.getX()).isEqualTo(0);
        assertThat(dot.getY()).isEqualTo(0);
    }

    @Test
    void executeFoldInstruction_BottomLeft_Vertical() {
        Dot dot = new Dot("0,14");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_VERTICAL);

        assertThat(dot.getX()).isEqualTo(0);
        assertThat(dot.getY()).isEqualTo(0);
    }

    @Test
    void executeFoldInstruction_BottomLeft_Horizontal() {
        Dot dot = new Dot("0,14");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_HORIZONTAL);

        assertThat(dot.getX()).isEqualTo(0);
        assertThat(dot.getY()).isEqualTo(14);
    }

    @Test
    void executeFoldInstruction_TopRight_Vertical() {
        Dot dot = new Dot("10,0");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_VERTICAL);

        assertThat(dot.getX()).isEqualTo(10);
        assertThat(dot.getY()).isEqualTo(0);
    }

    @Test
    void executeFoldInstruction_TopRight_Horizontal() {
        Dot dot = new Dot("10,0");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_HORIZONTAL);

        assertThat(dot.getX()).isEqualTo(0);
        assertThat(dot.getY()).isEqualTo(0);
    }

    @Test
    void executeFoldInstruction_BottomRight_Vertical() {
        Dot dot = new Dot("10,14");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_VERTICAL);

        assertThat(dot.getX()).isEqualTo(10);
        assertThat(dot.getY()).isEqualTo(0);
    }

    @Test
    void executeFoldInstruction_BottomRight_Horizontal() {
        Dot dot = new Dot("10,14");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_HORIZONTAL);

        assertThat(dot.getX()).isEqualTo(0);
        assertThat(dot.getY()).isEqualTo(14);
    }

    @Test
    void executeFoldInstruction_BottomRight_OneHigherAndOneMoreLeft_Vertical() {
        Dot dot = new Dot("9,13");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_VERTICAL);

        assertThat(dot.getX()).isEqualTo(9);
        assertThat(dot.getY()).isEqualTo(1);
    }

    @Test
    void executeFoldInstruction_BottomRight_OneHigherAndOneMoreLeft_Horizontal() {
        Dot dot = new Dot("9,13");

        dot.executeFoldInstruction(FOLD_INSTRUCTION_HORIZONTAL);

        assertThat(dot.getX()).isEqualTo(1);
        assertThat(dot.getY()).isEqualTo(13);
    }
}