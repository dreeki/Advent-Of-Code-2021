package day10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NavigationSubsystemTest {

    @Test
    void accumulateCorruptionPoints() {
        NavigationSubsystem navigationSubsystem = new NavigationSubsystem();

        navigationSubsystem.addLine("[({(<(())[]>[[{[]{<()<>>");
        navigationSubsystem.addLine("[(()[<>])]({[<{<<[]>>(");
        navigationSubsystem.addLine("{([(<{}[<>[]}>{[]{[(<()>");
        navigationSubsystem.addLine("(((({<>}<{<{<>}{[]{[]{}");
        navigationSubsystem.addLine("[[<[([]))<([[{}[[()]]]");
        navigationSubsystem.addLine("[{[{({}]{}}([{[{{{}}([]");
        navigationSubsystem.addLine("{<[[]]>}<{[{[{[]{()[[[]");
        navigationSubsystem.addLine("[<(<(<(<{}))><([]([]()");
        navigationSubsystem.addLine("<{([([[(<>()){}]>(<<{{");
        navigationSubsystem.addLine("<{([{{}}[<[[[<>{}]]]>[]]");

        assertThat(navigationSubsystem.accumulateCorruptionPoints()).isEqualTo(26397);
    }

    @Test
    void findMiddleOfIncompletePoints() {
        NavigationSubsystem navigationSubsystem = new NavigationSubsystem();

        navigationSubsystem.addLine("[({(<(())[]>[[{[]{<()<>>");
        navigationSubsystem.addLine("[(()[<>])]({[<{<<[]>>(");
        navigationSubsystem.addLine("{([(<{}[<>[]}>{[]{[(<()>");
        navigationSubsystem.addLine("(((({<>}<{<{<>}{[]{[]{}");
        navigationSubsystem.addLine("[[<[([]))<([[{}[[()]]]");
        navigationSubsystem.addLine("[{[{({}]{}}([{[{{{}}([]");
        navigationSubsystem.addLine("{<[[]]>}<{[{[{[]{()[[[]");
        navigationSubsystem.addLine("[<(<(<(<{}))><([]([]()");
        navigationSubsystem.addLine("<{([([[(<>()){}]>(<<{{");
        navigationSubsystem.addLine("<{([{{}}[<[[[<>{}]]]>[]]");

        assertThat(navigationSubsystem.findMiddleOfIncompletePoints()).isEqualTo(288957);
    }
}