package day10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    void findCorruptionPoints_ExampleInput() {
        assertThat(new Line("[({(<(())[]>[[{[]{<()<>>").findCorruptionPoints()).isZero();
        assertThat(new Line("[(()[<>])]({[<{<<[]>>(").findCorruptionPoints()).isZero();
        assertThat(new Line("{([(<{}[<>[]}>{[]{[(<()>").findCorruptionPoints()).isEqualTo(1197);
        assertThat(new Line("(((({<>}<{<{<>}{[]{[]{}").findCorruptionPoints()).isZero();
        assertThat(new Line("[[<[([]))<([[{}[[()]]]").findCorruptionPoints()).isEqualTo(3);
        assertThat(new Line("[{[{({}]{}}([{[{{{}}([]").findCorruptionPoints()).isEqualTo(57);
        assertThat(new Line("{<[[]]>}<{[{[{[]{()[[[]").findCorruptionPoints()).isZero();
        assertThat(new Line("[<(<(<(<{}))><([]([]()").findCorruptionPoints()).isEqualTo(3);
        assertThat(new Line("<{([([[(<>()){}]>(<<{{").findCorruptionPoints()).isEqualTo(25137);
        assertThat(new Line("<{([{{}}[<[[[<>{}]]]>[]]").findCorruptionPoints()).isZero();
    }

    @Test
    void findIncompletePoints_ExampleInput() {
        assertThat(new Line("[({(<(())[]>[[{[]{<()<>>").findIncompletePoints()).isEqualTo(288957);
        assertThat(new Line("[(()[<>])]({[<{<<[]>>(").findIncompletePoints()).isEqualTo(5566);
        assertThat(new Line("{([(<{}[<>[]}>{[]{[(<()>").findIncompletePoints()).isZero();
        assertThat(new Line("(((({<>}<{<{<>}{[]{[]{}").findIncompletePoints()).isEqualTo(1480781);
        assertThat(new Line("[[<[([]))<([[{}[[()]]]").findIncompletePoints()).isZero();
        assertThat(new Line("[{[{({}]{}}([{[{{{}}([]").findIncompletePoints()).isZero();
        assertThat(new Line("{<[[]]>}<{[{[{[]{()[[[]").findIncompletePoints()).isEqualTo(995444);
        assertThat(new Line("[<(<(<(<{}))><([]([]()").findIncompletePoints()).isZero();
        assertThat(new Line("<{([([[(<>()){}]>(<<{{").findIncompletePoints()).isZero();
        assertThat(new Line("<{([{{}}[<[[[<>{}]]]>[]]").findIncompletePoints()).isEqualTo(294);
    }
}