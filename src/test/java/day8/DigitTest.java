package day8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DigitTest {

    @Test
    void isSimpleValue() {
        assertThat(new Digit("be").isSimpleValue()).isTrue();
        assertThat(new Digit("cfbegad").isSimpleValue()).isTrue();
        assertThat(new Digit("cgeb").isSimpleValue()).isTrue();
        assertThat(new Digit("edb").isSimpleValue()).isTrue();

        assertThat(new Digit("cbdgef").isSimpleValue()).isFalse();
        assertThat(new Digit("fgaecd").isSimpleValue()).isFalse();
        assertThat(new Digit("fdcge").isSimpleValue()).isFalse();
        assertThat(new Digit("agebfd").isSimpleValue()).isFalse();
        assertThat(new Digit("fecdb").isSimpleValue()).isFalse();
        assertThat(new Digit("fabcd").isSimpleValue()).isFalse();
    }

    @Test
    void isNumber1() {
        assertThat(new Digit("be").isNumber1()).isTrue();
        assertThat(new Digit("cfbegad").isNumber1()).isFalse();
        assertThat(new Digit("cgeb").isNumber1()).isFalse();
        assertThat(new Digit("edb").isNumber1()).isFalse();

        assertThat(new Digit("cbdgef").isNumber1()).isFalse();
        assertThat(new Digit("fgaecd").isNumber1()).isFalse();
        assertThat(new Digit("fdcge").isNumber1()).isFalse();
        assertThat(new Digit("agebfd").isNumber1()).isFalse();
        assertThat(new Digit("fecdb").isNumber1()).isFalse();
        assertThat(new Digit("fabcd").isNumber1()).isFalse();
    }

    @Test
    void isNumber4() {
        assertThat(new Digit("be").isNumber4()).isFalse();
        assertThat(new Digit("cfbegad").isNumber4()).isFalse();
        assertThat(new Digit("cgeb").isNumber4()).isTrue();
        assertThat(new Digit("edb").isNumber4()).isFalse();

        assertThat(new Digit("cbdgef").isNumber4()).isFalse();
        assertThat(new Digit("fgaecd").isNumber4()).isFalse();
        assertThat(new Digit("fdcge").isNumber4()).isFalse();
        assertThat(new Digit("agebfd").isNumber4()).isFalse();
        assertThat(new Digit("fecdb").isNumber4()).isFalse();
        assertThat(new Digit("fabcd").isNumber4()).isFalse();
    }

    @Test
    void isNumber7() {
        assertThat(new Digit("be").isNumber7()).isFalse();
        assertThat(new Digit("cfbegad").isNumber7()).isFalse();
        assertThat(new Digit("cgeb").isNumber7()).isFalse();
        assertThat(new Digit("edb").isNumber7()).isTrue();

        assertThat(new Digit("cbdgef").isNumber7()).isFalse();
        assertThat(new Digit("fgaecd").isNumber7()).isFalse();
        assertThat(new Digit("fdcge").isNumber7()).isFalse();
        assertThat(new Digit("agebfd").isNumber7()).isFalse();
        assertThat(new Digit("fecdb").isNumber7()).isFalse();
        assertThat(new Digit("fabcd").isNumber7()).isFalse();
    }

    @Test
    void isNumber8() {
        assertThat(new Digit("be").isNumber8()).isFalse();
        assertThat(new Digit("cfbegad").isNumber8()).isTrue();
        assertThat(new Digit("cgeb").isNumber8()).isFalse();
        assertThat(new Digit("edb").isNumber8()).isFalse();

        assertThat(new Digit("cbdgef").isNumber8()).isFalse();
        assertThat(new Digit("fgaecd").isNumber8()).isFalse();
        assertThat(new Digit("fdcge").isNumber8()).isFalse();
        assertThat(new Digit("agebfd").isNumber8()).isFalse();
        assertThat(new Digit("fecdb").isNumber8()).isFalse();
        assertThat(new Digit("fabcd").isNumber8()).isFalse();
    }

    @Test
    void doesContainAllOf() {
        Digit number1 = new Digit("be");
        Digit number7 = new Digit("edb");
        Digit number4 = new Digit("cgeb");

        assertThat(number7.doesContainAllOf(number1)).isTrue();
        assertThat(number4.doesContainAllOf(number1)).isTrue();
        assertThat(number7.doesContainAllOf(number4)).isFalse();
    }

    @Test
    void doesNotContainAllOf() {
        Digit number1 = new Digit("be");
        Digit number7 = new Digit("edb");
        Digit number4 = new Digit("cgeb");

        assertThat(number7.doesNotContainAllOf(number1)).isFalse();
        assertThat(number4.doesNotContainAllOf(number1)).isFalse();
        assertThat(number7.doesNotContainAllOf(number4)).isTrue();
    }
}