package day8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DisplayTest {
    private static final Display DISPLAY = aDisplay();

    @Test
    void getNumber_0() {
        Digit digit = new Digit("abcefg");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(0);
    }

    @Test
    void getNumber_1() {
        Digit digit = new Digit("cf");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(1);
    }

    @Test
    void getNumber_2() {
        Digit digit = new Digit("acdeg");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(2);
    }

    @Test
    void getNumber_3() {
        Digit digit = new Digit("acdfg");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(3);
    }

    @Test
    void getNumber_4() {
        Digit digit = new Digit("bcdf");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(4);
    }

    @Test
    void getNumber_5() {
        Digit digit = new Digit("abdfg");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(5);
    }

    @Test
    void getNumber_6() {
        Digit digit = new Digit("abdefg");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(6);
    }

    @Test
    void getNumber_7() {
        Digit digit = new Digit("acf");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(7);
    }

    @Test
    void getNumber_8() {
        Digit digit = new Digit("abcdefg");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(8);
    }

    @Test
    void getNumber_9() {
        Digit digit = new Digit("abcdfg");

        assertThat(DISPLAY.getNumber(digit)).isEqualTo(9);
    }

    private static Display aDisplay() {
        Display display = new Display();

        display.setTop(aSegment('a'));
        display.setTopLeft(aSegment('b'));
        display.setTopRight(aSegment('c'));
        display.setMiddle(aSegment('d'));
        display.setBottomLeft(aSegment('e'));
        display.setBottomRight(aSegment('f'));
        display.setBottom(aSegment('g'));

        return display;
    }

    private static Segment aSegment(char c){
        return new Segment(c);
    }
}