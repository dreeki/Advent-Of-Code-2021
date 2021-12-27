package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws IOException {
        BingoGame bingoGame = readBingoGame();
        System.out.println("puzzle1: " + bingoGame.play());

        BingoGame bingoGame2 = readBingoGame();
        System.out.println("puzzle2: " + bingoGame2.playLosing());
    }

    private static BingoGame readBingoGame() throws IOException {
        Path path = Path.of("src", "main", "resources", "day4", "puzzle1.txt");
        List<String> input = Files.readAllLines(path).stream()
                .filter(line -> !line.isBlank())
                .collect(toList());

        BingoGame bingoGame = new BingoGame(input.get(0));

        for(int i = 1; i < input.size(); i += 5){
            List<String> lines = IntStream.range(i, i+5)
                    .mapToObj(input::get)
                    .collect(toList());
            Board board = new Board(lines);
            bingoGame.addBoard(board);
        }
        return bingoGame;
    }
}
