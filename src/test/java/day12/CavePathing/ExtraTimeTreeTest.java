package day12.CavePathing;

import day12.cave.Cave;
import day12.cave.CaveFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ExtraTimeTreeTest {

    @Test
    void findAmountOfPathsToEndByDFS() {
        Cave start = CaveFactory.makeCave("start");
        Cave capitalA = CaveFactory.makeCave("A");
        Cave b = CaveFactory.makeCave("b");
        Cave c = CaveFactory.makeCave("c");
        Cave d = CaveFactory.makeCave("d");
        Cave end = CaveFactory.makeCave("end");

        start.link(capitalA);
        start.link(b);
        capitalA.link(b);
        capitalA.link(c);
        capitalA.link(end);
        b.link(d);
        b.link(end);

        Tree tree = new ExtraTimeTree(start);

        assertThat(tree.findAmountOfPathsToEndByDFS()).isEqualTo(36);
    }
}