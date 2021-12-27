package day13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TransparentPaperTest {

    @Test
    void executeFoldInstruction_ExampleInput() {
        TransparentPaper transparentPaper = new TransparentPaper();

        transparentPaper.addDot("6,10");
        transparentPaper.addDot("0,14");
        transparentPaper.addDot("9,10");
        transparentPaper.addDot("0,3");
        transparentPaper.addDot("10,4");
        transparentPaper.addDot("4,11");
        transparentPaper.addDot("6,0");
        transparentPaper.addDot("6,12");
        transparentPaper.addDot("4,1");
        transparentPaper.addDot("0,13");
        transparentPaper.addDot("10,12");
        transparentPaper.addDot("3,4");
        transparentPaper.addDot("3,0");
        transparentPaper.addDot("8,4");
        transparentPaper.addDot("1,10");
        transparentPaper.addDot("2,14");
        transparentPaper.addDot("8,10");
        transparentPaper.addDot("9,0");

        transparentPaper.addFoldInstruction("fold along y=7");
        transparentPaper.addFoldInstruction("fold along x=5");

        transparentPaper.executeFoldInstruction();

        assertThat(transparentPaper.getAmountOfDots()).isEqualTo(17);
    }

    @Test
    void executeAllAfterFirstFoldInstruction_ExampleInput() {
        TransparentPaper transparentPaper = new TransparentPaper();

        transparentPaper.addDot("6,10");
        transparentPaper.addDot("0,14");
        transparentPaper.addDot("9,10");
        transparentPaper.addDot("0,3");
        transparentPaper.addDot("10,4");
        transparentPaper.addDot("4,11");
        transparentPaper.addDot("6,0");
        transparentPaper.addDot("6,12");
        transparentPaper.addDot("4,1");
        transparentPaper.addDot("0,13");
        transparentPaper.addDot("10,12");
        transparentPaper.addDot("3,4");
        transparentPaper.addDot("3,0");
        transparentPaper.addDot("8,4");
        transparentPaper.addDot("1,10");
        transparentPaper.addDot("2,14");
        transparentPaper.addDot("8,10");
        transparentPaper.addDot("9,0");

        transparentPaper.addFoldInstruction("fold along y=7");
        transparentPaper.addFoldInstruction("fold along x=5");

        transparentPaper.executeFoldInstruction();
        transparentPaper.executeAllAfterFirstFoldInstruction();

        assertThat(transparentPaper.getAmountOfDots()).isEqualTo(16);
    }
}