package day9;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Row {
    private final List<Location> locations;

    public Row(int row, String line) {
        locations = new ArrayList<>();
        String[] locationString = line.split("");
        for(int col = 0; col < locationString.length; col++) {
            int height = Integer.parseInt(locationString[col]);
            locations.add(new Location(row, col, height));
        }
    }

    public void setLocationAsLowPoint(int index) {
        locations.get(index).makeLowPoint();
    }

    public Location getLocationAtIndex(int index) {
        return locations.get(index);
    }

    public int getAmountOfLocations() {
        return locations.size();
    }

    public List<Location> getLowPoints() {
        return locations.stream()
                .filter(Location::isLowPoint)
                .collect(toList());
    }
}
