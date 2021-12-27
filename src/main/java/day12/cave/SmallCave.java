package day12.cave;

class SmallCave extends Cave {
    SmallCave(String name) {
        super(name);
    }

    @Override
    public boolean canBeVisitedOnlyOnce() {
        return true;
    }

    @Override
    public boolean canBeVisitedMultipleTimes() {
        return false;
    }
}
