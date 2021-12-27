package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class BingoGame {
    private final List<Integer> inputValues;
    private final List<Board> boards;

    public BingoGame(String input) {
        this.inputValues = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(toList());
        boards = new ArrayList<>();
    }

    public void addBoard(Board board) {
        boards.add(board);
    }

    public int play() {
        int i;
        for(i = 0; i < inputValues.size(); i++) {
            int currentInput = i;
            boards.forEach(board -> board.mark(inputValues.get(currentInput)));

            if(aBoardHasBingo()) {
                break;
            }
        }

        Board boardWithBingo = getBoardWithBingo();
        return inputValues.get(i) * boardWithBingo.getSumOfUnmarkedNumbers();
    }

    public int playLosing() {
        List<Board> remainingBoards = new ArrayList<>(boards);
        Optional<Board> losingBoard = Optional.empty();
        int i;
        for(i = 0; i < inputValues.size(); i++) {
            int currentInput = i;
            remainingBoards.forEach(board -> board.mark(inputValues.get(currentInput)));

            remainingBoards = remainingBoards.stream()
                    .filter(board -> !board.isBingo())
                    .collect(toList());
            if(remainingBoards.size() == 1) {
                losingBoard = Optional.of(remainingBoards.get(0));
            }
            if(remainingBoards.isEmpty()) {
                break;
            }
        }

        return inputValues.get(i) * losingBoard.map(Board::getSumOfUnmarkedNumbers).orElseThrow(NoSuchElementException::new);
    }

    private Board getBoardWithBingo() {
        return boards.stream()
                .filter(Board::isBingo)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean aBoardHasBingo() {
        return boards.stream()
                .anyMatch(Board::isBingo);
    }
}
