package day12.CavePathing;

import day12.cave.Cave;
import day12.cave.CaveFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TreeTest {
    @Test
    void construction_MiniExample() {
        Cave start = CaveFactory.makeCave("start");
        Cave capitalA = CaveFactory.makeCave("A");
        Cave b = CaveFactory.makeCave("b");
        Cave end = CaveFactory.makeCave("end");

        start.link(capitalA);
        start.link(b);
        capitalA.link(b);
        capitalA.link(end);
        b.link(end);

        Tree tree = new Tree(start);

        assertThat(tree.getRootSimpleTree().isLeaf()).isFalse();

        assertThat(tree.getRootSimpleTree().getParent()).isEmpty();
        assertThat(tree.getRootSimpleTree().getChild(0).getCave()).isEqualTo(capitalA);
        assertThat(tree.getRootSimpleTree().getChild(0).getParent()).contains(tree.getRootSimpleTree());
        assertThat(tree.getRootSimpleTree().getChild(0).isLeaf()).isFalse();

        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getCave()).isEqualTo(b);
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getParent()).contains(tree.getRootSimpleTree().getChild(0));
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).isLeaf()).isFalse();

        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(0).getCave()).isEqualTo(capitalA);
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(0).getParent()).contains(tree.getRootSimpleTree().getChild(0).getChild(0));
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(0).isLeaf()).isFalse();

        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(0).getChild(0).getCave()).isEqualTo(end);
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(0).getChild(0).getParent()).contains(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(0));
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(0).getChild(0).isLeaf()).isTrue();

        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(1).getCave()).isEqualTo(end);
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(1).getParent()).contains(tree.getRootSimpleTree().getChild(0).getChild(0));
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(0).getChild(1).isLeaf()).isTrue();

        assertThat(tree.getRootSimpleTree().getChild(0).getChild(1).getCave()).isEqualTo(end);
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(1).getParent()).contains(tree.getRootSimpleTree().getChild(0));
        assertThat(tree.getRootSimpleTree().getChild(0).getChild(1).isLeaf()).isTrue();

        assertThat(tree.getRootSimpleTree().getChild(1).getCave()).isEqualTo(b);
        assertThat(tree.getRootSimpleTree().getChild(1).getParent()).contains(tree.getRootSimpleTree());
        assertThat(tree.getRootSimpleTree().getChild(1).isLeaf()).isFalse();

        assertThat(tree.getRootSimpleTree().getChild(1).getChild(0).getCave()).isEqualTo(capitalA);
        assertThat(tree.getRootSimpleTree().getChild(1).getChild(0).getParent()).contains(tree.getRootSimpleTree().getChild(1));
        assertThat(tree.getRootSimpleTree().getChild(1).getChild(0).isLeaf()).isFalse();

        assertThat(tree.getRootSimpleTree().getChild(1).getChild(0).getChild(0).getCave()).isEqualTo(end);
        assertThat(tree.getRootSimpleTree().getChild(1).getChild(0).getChild(0).getParent()).contains(tree.getRootSimpleTree().getChild(1).getChild(0));
        assertThat(tree.getRootSimpleTree().getChild(1).getChild(0).getChild(0).isLeaf()).isTrue();

        assertThat(tree.getRootSimpleTree().getChild(1).getChild(1).getCave()).isEqualTo(end);
        assertThat(tree.getRootSimpleTree().getChild(1).getChild(1).getParent()).contains(tree.getRootSimpleTree().getChild(1));
        assertThat(tree.getRootSimpleTree().getChild(1).getChild(1).isLeaf()).isTrue();
    }

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

        Tree tree = new Tree(start);

        assertThat(tree.findAmountOfPathsToEndByDFS()).isEqualTo(10);
    }
}