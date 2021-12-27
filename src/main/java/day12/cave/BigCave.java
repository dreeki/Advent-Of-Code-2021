package day12.cave;

class BigCave extends Cave {
    BigCave(String name) {
        super(name);
    }

    @Override
    public boolean canBeVisitedOnlyOnce() {
        return false;
    }

    @Override
    public boolean canBeVisitedMultipleTimes() {
        return true;
    }
}
