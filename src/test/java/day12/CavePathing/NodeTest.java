package day12.CavePathing;

import day12.cave.Cave;
import day12.cave.CaveFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NodeTest {

    @Test
    void hasNotInParentPath_Root() {
        Node root = Node.builder(CaveFactory.makeCave("start")).build();

        assertThat(root.hasNotInParentPath(CaveFactory.makeCave("a"))).isTrue();
    }

    @Test
    void hasNotInParentPath_Siblings() {
        Cave rootCave = CaveFactory.makeCave("start");
        Cave childAOfRoot = CaveFactory.makeCave("a");
        Cave childBOfRoot = CaveFactory.makeCave("b");
        rootCave.link(childAOfRoot);
        rootCave.link(childBOfRoot);
        
        Node root = Node.builder(rootCave).build();
        root.addChild(childAOfRoot);
        root.addChild(childBOfRoot);


        assertThat(root.hasNotInParentPath(childAOfRoot)).isTrue();
        assertThat(root.hasNotInParentPath(childBOfRoot)).isTrue();
    }

    @Test
    void hasNotInParentPath_Level2Children() {
        Cave rootCave = CaveFactory.makeCave("start");
        Cave childAOfRoot = CaveFactory.makeCave("a");
        Cave childBOfA = CaveFactory.makeCave("b");
        rootCave.link(childAOfRoot);
        childAOfRoot.link(childBOfA);

        Node root = Node.builder(rootCave).build();
        root.addChild(childAOfRoot);
        root.getChild(0).addChild(childBOfA);

        assertThat(root.hasNotInParentPath(childAOfRoot)).isTrue();
        assertThat(root.getChild(0).hasNotInParentPath(childBOfA)).isTrue();
        assertThat(root.getChild(0).getChild(0).hasNotInParentPath(childAOfRoot)).isFalse();
    }

    @Test
    void hasNotInParentPath_LongerLine() {
        Cave rootCave = CaveFactory.makeCave("start");
        Cave childAOfRoot = CaveFactory.makeCave("a");
        Cave childBOfA = CaveFactory.makeCave("b");
        rootCave.link(childAOfRoot);
        childAOfRoot.link(childBOfA);
        rootCave.link(childAOfRoot);

        Node root = Node.builder(rootCave).build();
        root.addChild(childAOfRoot);
        root.getChild(0).addChild(childBOfA);
        root.getChild(0).getChild(0).addChild(rootCave);

        assertThat(root.hasNotInParentPath(childAOfRoot)).isTrue();
        assertThat(root.getChild(0).hasNotInParentPath(childBOfA)).isTrue();
        assertThat(root.getChild(0).getChild(0).hasNotInParentPath(rootCave)).isFalse();
    }

    @Test
    void hasNotInParentPathOneException() {
        Cave rootCave = CaveFactory.makeCave("start");
        Cave childAOfRoot = CaveFactory.makeCave("a");
        Cave childBOfA = CaveFactory.makeCave("b");

        rootCave.link(childAOfRoot);

        Node root = Node.builder(rootCave).build();
        root.addChild(childAOfRoot);
        root.getChild(0).addChild(childBOfA);
        root.getChild(0).getChild(0).addChild(childAOfRoot);
        root.getChild(0).getChild(0).getChild(0).addChild(childBOfA);

        assertThat(root.hasNotInParentPathOneException(childAOfRoot)).isTrue();
        assertThat(root.getChild(0).hasNotInParentPathOneException(childBOfA)).isTrue();
        assertThat(root.getChild(0).getChild(0).hasNotInParentPathOneException(childAOfRoot)).isTrue();
        assertThat(root.getChild(0).getChild(0).getChild(0).hasNotInParentPathOneException(childBOfA)).isFalse();
    }

    @Test
    void hasNotInParentPathOneException_MoreThanTwiceSame() {
        Cave rootCave = CaveFactory.makeCave("start");
        Cave childAOfRoot = CaveFactory.makeCave("A");
        Cave childBOfA = CaveFactory.makeCave("b");

        rootCave.link(childAOfRoot);

        Node root = Node.builder(rootCave).build();
        root.addChild(childAOfRoot);
        root.getChild(0).addChild(childBOfA);
        root.getChild(0).getChild(0).addChild(childAOfRoot);
        root.getChild(0).getChild(0).getChild(0).addChild(childBOfA);
        root.getChild(0).getChild(0).getChild(0).getChild(0).addChild(childAOfRoot);
        root.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).addChild(childBOfA);

        assertThat(root.hasNotInParentPathOneException(childAOfRoot)).isTrue();
        assertThat(root.getChild(0).hasNotInParentPathOneException(childBOfA)).isTrue();
        assertThat(root.getChild(0).getChild(0).hasNotInParentPathOneException(childAOfRoot)).isTrue();
        assertThat(root.getChild(0).getChild(0).getChild(0).hasNotInParentPathOneException(childBOfA)).isTrue();
        assertThat(root.getChild(0).getChild(0).getChild(0).getChild(0).hasNotInParentPathOneException(childAOfRoot)).isTrue();
        assertThat(root.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).hasNotInParentPathOneException(childBOfA)).isFalse();
    }
}