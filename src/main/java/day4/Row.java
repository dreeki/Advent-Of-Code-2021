package day4;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Row {
    private final List<BingoNumber> bingoNumbers;

    public Row(String input) {
        bingoNumbers = Arrays.stream(input.split(" "))
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .map(BingoNumber::new)
                .collect(toList());
    }

    public List<BingoNumber> getBingoNumbers() {
        return bingoNumbers;
    }

    public void mark(int number){
        bingoNumbers.forEach(bingoNumber -> bingoNumber.mark(number));
    }

    public boolean isBingo() {
        return bingoNumbers.stream()
                .allMatch(BingoNumber::isMarked);
    }
}
