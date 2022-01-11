package day14;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PolymerTest {

    @Test
    void initializePairs_ExampleInput() {
        Polymer polymer = new Polymer("NNCB");

        polymer.addPairInsertionRule("CH -> B");
        polymer.addPairInsertionRule("HH -> N");
        polymer.addPairInsertionRule("CB -> H");
        polymer.addPairInsertionRule("NH -> C");
        polymer.addPairInsertionRule("HB -> C");
        polymer.addPairInsertionRule("HC -> B");
        polymer.addPairInsertionRule("HN -> C");
        polymer.addPairInsertionRule("NN -> C");
        polymer.addPairInsertionRule("BH -> H");
        polymer.addPairInsertionRule("NC -> B");
        polymer.addPairInsertionRule("NB -> B");
        polymer.addPairInsertionRule("BN -> B");
        polymer.addPairInsertionRule("BB -> N");
        polymer.addPairInsertionRule("BC -> B");
        polymer.addPairInsertionRule("CC -> N");
        polymer.addPairInsertionRule("CN -> C");

        polymer.initializePairs();

        assertThat(polymer.getPairs().get("CH").getAmount()).isZero();
        assertThat(polymer.getPairs().get("HH").getAmount()).isZero();
        assertThat(polymer.getPairs().get("NH").getAmount()).isZero();
        assertThat(polymer.getPairs().get("HB").getAmount()).isZero();
        assertThat(polymer.getPairs().get("HC").getAmount()).isZero();
        assertThat(polymer.getPairs().get("HN").getAmount()).isZero();
        assertThat(polymer.getPairs().get("BH").getAmount()).isZero();
        assertThat(polymer.getPairs().get("NB").getAmount()).isZero();
        assertThat(polymer.getPairs().get("BN").getAmount()).isZero();
        assertThat(polymer.getPairs().get("BB").getAmount()).isZero();
        assertThat(polymer.getPairs().get("BC").getAmount()).isZero();
        assertThat(polymer.getPairs().get("CC").getAmount()).isZero();
        assertThat(polymer.getPairs().get("CN").getAmount()).isZero();

        assertThat(polymer.getPairs().get("CB").getAmount()).isOne();
        assertThat(polymer.getPairs().get("NN").getAmount()).isOne();
        assertThat(polymer.getPairs().get("NC").getAmount()).isOne();
    }

    @Test
    void doIterations_OneIteration_ExampleInput() {
        Polymer polymer = new Polymer("NNCB");

        polymer.addPairInsertionRule("CH -> B");
        polymer.addPairInsertionRule("HH -> N");
        polymer.addPairInsertionRule("CB -> H");
        polymer.addPairInsertionRule("NH -> C");
        polymer.addPairInsertionRule("HB -> C");
        polymer.addPairInsertionRule("HC -> B");
        polymer.addPairInsertionRule("HN -> C");
        polymer.addPairInsertionRule("NN -> C");
        polymer.addPairInsertionRule("BH -> H");
        polymer.addPairInsertionRule("NC -> B");
        polymer.addPairInsertionRule("NB -> B");
        polymer.addPairInsertionRule("BN -> B");
        polymer.addPairInsertionRule("BB -> N");
        polymer.addPairInsertionRule("BC -> B");
        polymer.addPairInsertionRule("CC -> N");
        polymer.addPairInsertionRule("CN -> C");

        polymer.initializePairs();
        polymer.doIterations(1);

        assertThat(polymer.getPairs().get("CH").getAmount()).isOne();
        assertThat(polymer.getPairs().get("HH").getAmount()).isZero();
        assertThat(polymer.getPairs().get("CB").getAmount()).isZero();
        assertThat(polymer.getPairs().get("NH").getAmount()).isZero();
        assertThat(polymer.getPairs().get("HB").getAmount()).isOne();
        assertThat(polymer.getPairs().get("HC").getAmount()).isZero();
        assertThat(polymer.getPairs().get("HN").getAmount()).isZero();
        assertThat(polymer.getPairs().get("NN").getAmount()).isZero();
        assertThat(polymer.getPairs().get("BH").getAmount()).isZero();
        assertThat(polymer.getPairs().get("NC").getAmount()).isOne();
        assertThat(polymer.getPairs().get("NB").getAmount()).isOne();
        assertThat(polymer.getPairs().get("BN").getAmount()).isZero();
        assertThat(polymer.getPairs().get("BB").getAmount()).isZero();
        assertThat(polymer.getPairs().get("BC").getAmount()).isOne();
        assertThat(polymer.getPairs().get("CC").getAmount()).isZero();
        assertThat(polymer.getPairs().get("CN").getAmount()).isOne();
    }

    @Test
    void getResult_TenIteration_ExampleInput() {
        Polymer polymer = new Polymer("NNCB");

        polymer.addPairInsertionRule("CH -> B");
        polymer.addPairInsertionRule("HH -> N");
        polymer.addPairInsertionRule("CB -> H");
        polymer.addPairInsertionRule("NH -> C");
        polymer.addPairInsertionRule("HB -> C");
        polymer.addPairInsertionRule("HC -> B");
        polymer.addPairInsertionRule("HN -> C");
        polymer.addPairInsertionRule("NN -> C");
        polymer.addPairInsertionRule("BH -> H");
        polymer.addPairInsertionRule("NC -> B");
        polymer.addPairInsertionRule("NB -> B");
        polymer.addPairInsertionRule("BN -> B");
        polymer.addPairInsertionRule("BB -> N");
        polymer.addPairInsertionRule("BC -> B");
        polymer.addPairInsertionRule("CC -> N");
        polymer.addPairInsertionRule("CN -> C");

        polymer.initializePairs();
        polymer.doIterations(10);

        assertThat(polymer.getResult()).isEqualTo(1588L);
    }

    @Test
    void getResult_FortyIteration_ExampleInput() {
        Polymer polymer = new Polymer("NNCB");

        polymer.addPairInsertionRule("CH -> B");
        polymer.addPairInsertionRule("HH -> N");
        polymer.addPairInsertionRule("CB -> H");
        polymer.addPairInsertionRule("NH -> C");
        polymer.addPairInsertionRule("HB -> C");
        polymer.addPairInsertionRule("HC -> B");
        polymer.addPairInsertionRule("HN -> C");
        polymer.addPairInsertionRule("NN -> C");
        polymer.addPairInsertionRule("BH -> H");
        polymer.addPairInsertionRule("NC -> B");
        polymer.addPairInsertionRule("NB -> B");
        polymer.addPairInsertionRule("BN -> B");
        polymer.addPairInsertionRule("BB -> N");
        polymer.addPairInsertionRule("BC -> B");
        polymer.addPairInsertionRule("CC -> N");
        polymer.addPairInsertionRule("CN -> C");

        polymer.initializePairs();
        polymer.doIterations(40);

        assertThat(polymer.getResult()).isEqualTo(2188189693529L);
    }
}
