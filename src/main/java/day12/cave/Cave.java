package day12.cave;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Cave {
    final String name;
    final List<Cave> reachableCaves;

    public Cave(String name) {
        this.name = name;
        reachableCaves = new ArrayList<>();
    }

    public abstract boolean canBeVisitedOnlyOnce();

    public abstract boolean canBeVisitedMultipleTimes();

    public void link(Cave cave) {
        this.reachableCaves.add(cave);
        cave.reachableCaves.add(this);
    }

    public String getName() {
        return name;
    }

    public List<Cave> getReachableCaves() {
        return new ArrayList<>(reachableCaves);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return Objects.equals(name, cave.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
