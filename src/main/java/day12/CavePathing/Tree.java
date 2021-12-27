package day12.CavePathing;

import day12.cave.Cave;

public class Tree {
    private final Node rootSimpleTree;

    public Tree(Cave rootCave) {
        rootSimpleTree = Node.builder(rootCave).build();
        fillTree(rootSimpleTree);
    }

    public int findAmountOfPathsToEndByDFS() {
        return findAmountOfPathsToEndRecursive(rootSimpleTree);
    }

    private int findAmountOfPathsToEndRecursive(Node node) {
        int sum = 0;
        for(int i = 0; i < node.getAmountOfChildren(); i++) {
            if(node.getChild(i).isEnd()) {
                sum += 1;
            }else {
                sum += findAmountOfPathsToEndRecursive(node.getChild(i));
            }
        }
        return sum;
    }

    void fillTree(Node current) {
        Cave currentCave = current.getCave();
        currentCave.getReachableCaves().forEach(reachableCave -> {
            if(isAnAllowedChild(current, reachableCave)){
                current.addChild(reachableCave);
                fillTree(current.getChild(current.getAmountOfChildren() - 1));
            }
        });
    }

    private boolean isAnAllowedChild(Node current, Cave reachableCave) {
        if(current.getCave().getName().equals("end")) {
            return false;
        }
        return reachableCave.canBeVisitedMultipleTimes() || (reachableCave.canBeVisitedOnlyOnce() && current.hasNotInParentPath(reachableCave));
    }

    public Node getRootSimpleTree() {
        return rootSimpleTree;
    }
}
