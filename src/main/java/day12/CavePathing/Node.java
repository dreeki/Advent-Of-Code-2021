package day12.CavePathing;

import day12.cave.Cave;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Node {
    private final Cave cave;
    private final Node parent;
    private final List<Node> children;

    public Node(NodeBuilder nodeBuilder) {
        this.cave = nodeBuilder.cave;
        this.parent = nodeBuilder.parent;
        children = new ArrayList<>();
    }

    public boolean hasNotInParentPath(Cave reachableCave) {
        return !hasInParentPath(reachableCave);
    }

    private boolean hasInParentPath(Cave reachableCave) {
        Optional<Node> parent = getParent();
        return parent
                .map(node -> node.cave.equals(reachableCave) || node.hasInParentPath(reachableCave))
                .orElse(false);
    }

    public boolean hasNotInParentPathOneException(Cave reachableCave) {
        List<Cave> parentLine = new ArrayList<>();
        addSmallCaveToList(parentLine, cave);
        addSmallCaveToList(parentLine, reachableCave);

        Optional<Node> currentParent = getParent();
        while(currentParent.isPresent()) {
            addSmallCaveToList(parentLine, currentParent.get().getCave());
            currentParent = currentParent.get().getParent();
        }
        Map<String, Long> amountOfOccurences = parentLine.stream()
                .map(Cave::getName)
                .collect(groupingBy(name -> name, counting()));

        List<Long> counts = amountOfOccurences.values().stream()
                .mapToLong(l -> l)
                .filter(count -> count > 1)
                .boxed()
                .collect(toList());

        if(counts.isEmpty()) {
            return true;
        }
        return counts.size() < 2 && counts.get(0) < 3;
    }

    private void addSmallCaveToList(List<Cave> smallCaves, Cave cave) {
        if(cave.canBeVisitedOnlyOnce()) {
            smallCaves.add(cave);
        }
    }

    public void addChild(Cave cave) {
        Node node = Node.builder(cave)
                .parent(this)
                .build();
        children.add(node);
    }

    public Optional<Node> getParent() {
        return Optional.ofNullable(parent);
    }

    public Cave getCave() {
        return cave;
    }

    public int getAmountOfChildren() {
        return children.size();
    }

    public Node getChild(int index) {
        return children.get(index);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isEnd() {
        return cave.getName().equals("end");
    }

    public static NodeBuilder builder(Cave cave) {
        return new NodeBuilder(cave);
    }

    public static class NodeBuilder {
        private final Cave cave;

        private Node parent;

        private NodeBuilder(Cave cave) {
            this.cave = cave;
        }

        public NodeBuilder parent(Node parent) {
            this.parent = parent;
            return this;
        }

        public Node build() {
            return new Node(this);
        }
    }
}
