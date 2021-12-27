package day8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void countSimpleDigitsInOutput() {
        Line line = new Line("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");

        assertThat(line.countSimpleDigitsInOutput()).isEqualTo(2);
    }

    @Test
    void decodeDisplay() {
        Line line = new Line("abcefg cf acdeg acdfg bcdf abdfg abdefg acf abcdefg abcdfg | abcdefg abdfg abcefg bcdf");

        line.decodeDisplay();

        Display display = line.getDisplay();
        assertThat(display.getTop().getValue()).isEqualTo('a');
        assertThat(display.getTopLeft().getValue()).isEqualTo('b');
        assertThat(display.getTopRight().getValue()).isEqualTo('c');
        assertThat(display.getMiddle().getValue()).isEqualTo('d');
        assertThat(display.getBottomLeft().getValue()).isEqualTo('e');
        assertThat(display.getBottomRight().getValue()).isEqualTo('f');
        assertThat(display.getBottom().getValue()).isEqualTo('g');
    }

    @Test
    void decodeOutput() {
        Line line = new Line("abcefg cf acdeg acdfg bcdf abdfg abdefg acf abcdefg abcdfg | abcdefg abdfg abcefg bcdf");

        line.decodeDisplay();

        assertThat(line.decodeOutput()).isEqualTo(8504);
    }
}