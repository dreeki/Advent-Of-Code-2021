package day12.CavePathing;

import day12.cave.Cave;

public class ExtraTimeTree extends Tree{
    public ExtraTimeTree(Cave rootCave) {
        super(rootCave);
    }

    @Override
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
        if(current.getCave().getName().equals("end") || reachableCave.getName().equals("start")) {
            return false;
        }
        return reachableCave.canBeVisitedMultipleTimes() || (reachableCave.canBeVisitedOnlyOnce() && current.hasNotInParentPathOneException(reachableCave));
    }
}
