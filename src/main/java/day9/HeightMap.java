package day9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class HeightMap {
    private final List<Row> rows;
    private final List<Basin> basins;

    public HeightMap() {
        rows = new ArrayList<>();
        basins = new ArrayList<>();
    }

    public void addRow(String line) {
        int currentRowCount = rows.size();
        rows.add(new Row(currentRowCount, line));
    }

    public void findLowPoints() {
        for (int row = 0; row < rows.size(); row++) {
            for (int col = 0; col < rows.get(0).getAmountOfLocations(); col++) {
                if (isLowPoint(row, col)) {
                    rows.get(row).setLocationAsLowPoint(col);
                }
            }
        }
    }

    private boolean isLowPoint(int row, int col) {
        return isLowerThanLeft(row, col) &&
                isLowerThanRight(row, col) &&
                isLowerThanAbove(row, col) &&
                isLowerThanBelow(row, col);
    }

    private boolean isLowerThanLeft(int row, int column) {
        if (column == 0) {
            return true;
        }
        return rows.get(row).getLocationAtIndex(column).getHeight() < rows.get(row).getLocationAtIndex(column - 1).getHeight();
    }

    private boolean isLowerThanRight(int row, int column) {
        if (column == rows.get(0).getAmountOfLocations() - 1) {
            return true;
        }
        return rows.get(row).getLocationAtIndex(column).getHeight() < rows.get(row).getLocationAtIndex(column + 1).getHeight();
    }

    private boolean isLowerThanAbove(int row, int column) {
        if (row == 0) {
            return true;
        }
        return rows.get(row).getLocationAtIndex(column).getHeight() < rows.get(row - 1).getLocationAtIndex(column).getHeight();
    }

    private boolean isLowerThanBelow(int row, int column) {
        if (row == rows.size() - 1) {
            return true;
        }
        return rows.get(row).getLocationAtIndex(column).getHeight() < rows.get(row + 1).getLocationAtIndex(column).getHeight();
    }

    public List<Row> getRows() {
        return rows;
    }

    public int getSumOfRiskLevels() {
        return rows.stream()
                .map(Row::getLowPoints)
                .flatMap(Collection::stream)
                .mapToInt(Location::getHeight)
                .map(height -> ++height)
                .sum();

    }

    public void findBasins() {
        List<Location> lowPoints = rows.stream()
                .map(Row::getLowPoints)
                .flatMap(Collection::stream)
                .collect(toList());
        lowPoints.forEach(lowPoint -> {
            Basin basin = new Basin(lowPoint);
            basins.add(basin);
            fillBasin(lowPoint, basin);
        });
    }

    private void fillBasin(Location lowPoint, Basin basin) {
        Optional<Location> left = findLocationLeft(lowPoint);
        Optional<Location> right = findLocationRight(lowPoint);
        Optional<Location> above = findLocationAbove(lowPoint);
        Optional<Location> below = findLocationBelow(lowPoint);

        left.ifPresent(location -> checkBelongsInBasing(lowPoint, location, basin));
        right.ifPresent(location -> checkBelongsInBasing(lowPoint, location, basin));
        above.ifPresent(location -> checkBelongsInBasing(lowPoint, location, basin));
        below.ifPresent(location -> checkBelongsInBasing(lowPoint, location, basin));
    }

    private void checkBelongsInBasing(Location lowPoint, Location location, Basin basin) {
        if(lowPoint.isNotHigher(location)) {
            int sizeBeforeAddition = basin.getBasinSize();
            basin.addLocationToBasin(location);
            int sizeAfterAddition = basin.getBasinSize();
            if(isNewLocationInBasin(sizeBeforeAddition, sizeAfterAddition)){
                fillBasin(location, basin);
            }
        }
    }

    private boolean isNewLocationInBasin(int sizeBeforeAddition, int sizeAfterAddition) {
        return sizeAfterAddition > sizeBeforeAddition;
    }

    private Optional<Location> findLocationAbove(Location location){
        if(location.getRow() == 0) {
            return Optional.empty();
        }
        return Optional.of(rows.get(location.getRow() - 1).getLocationAtIndex(location.getCol()));
    }

    private Optional<Location> findLocationBelow(Location location){
        if(location.getRow() == rows.size() - 1) {
            return Optional.empty();
        }
        return Optional.of(rows.get(location.getRow() + 1).getLocationAtIndex(location.getCol()));
    }

    private Optional<Location> findLocationLeft(Location location){
        if(location.getCol() == 0) {
            return Optional.empty();
        }
        return Optional.of(rows.get(location.getRow()).getLocationAtIndex(location.getCol() - 1));
    }

    private Optional<Location> findLocationRight(Location location){
        if(location.getCol() == rows.get(0).getAmountOfLocations() - 1) {
            return Optional.empty();
        }
        return Optional.of(rows.get(location.getRow()).getLocationAtIndex(location.getCol() + 1));
    }

    public int multiplyThreeBiggestBasinSizes() {
        List<Integer> limit = basins.stream()
                .map(Basin::getBasinSize)
                .sorted(Collections.reverseOrder())
                .collect(toList());
        return limit.stream().limit(3)
                .reduce(1, (first, second) -> first * second);
    }

    public List<Basin> getBasins() {
        return basins;
    }
}
