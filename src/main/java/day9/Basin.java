package day9;

import java.util.HashSet;
import java.util.Set;

public class Basin {
    private final int lowPointRow;
    private final int lowPointCol;
    private final Set<Location> locations;

    public Basin(Location lowPoint) {
        lowPointRow = lowPoint.getRow();
        lowPointCol = lowPoint.getCol();
        locations = new HashSet<>();
        locations.add(lowPoint);
    }

    public int getLowPointRow() {
        return lowPointRow;
    }

    public int getLowPointCol() {
        return lowPointCol;
    }

    public void addLocationToBasin(Location location) {
        if (location.getHeight() < 9) {
            locations.add(location);
        }
    }

    public int getBasinSize() {
        return locations.size();
    }

    public Set<Location> getLocations() {
        return locations;
    }
}
