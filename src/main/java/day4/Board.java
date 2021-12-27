package day4;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Board {
    private final List<Row> rows;

    public Board(List<String> inputs) {
        rows = inputs.stream()
                .map(Row::new)
                .collect(toList());
    }

    public void mark(int number) {
        rows.forEach(row -> row.mark(number));
    }

    public List<Row> getRows() {
        return rows;
    }

    public boolean isBingo() {
        return isRowBingo() || isColumnBingo();
    }

    public int getSumOfUnmarkedNumbers() {
        return rows.stream()
                .map(Row::getBingoNumbers)
                .flatMap(Collection::stream)
                .filter(BingoNumber::isNotMarked)
                .mapToInt(BingoNumber::getValue)
                .sum();
    }

    private boolean isRowBingo() {
        return rows.stream().anyMatch(Row::isBingo);
    }

    private boolean isColumnBingo() {
        for (int pos = 0; pos < rows.get(0).getBingoNumbers().size(); pos++) {
            int row;
            for (row = 0; row < rows.size(); row++) {
                if (!rows.get(row).getBingoNumbers().get(pos).isMarked()) {
                    break;
                }
            }
            if (row == rows.size()) {
                return true;
            }
        }
        return false;
    }
}
