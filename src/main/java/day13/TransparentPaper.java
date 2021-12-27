package day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TransparentPaper {
    private final List<Dot> dots;
    private final List<FoldInstruction> foldInstructions;

    public TransparentPaper() {
        dots = new ArrayList<>();
        foldInstructions = new ArrayList<>();
    }

    public void addDot(String input) {
        dots.add(new Dot(input));
    }

    public void addFoldInstruction(String input) {
        foldInstructions.add(new FoldInstruction(input));
    }

    public void executeFoldInstruction() {
        FoldInstruction foldInstructionToExectute = foldInstructions.get(0);

        executeFoldInstructionOnAllDots(foldInstructionToExectute);
    }

    public void executeAllAfterFirstFoldInstruction() {
        IntStream.range(1, foldInstructions.size())
                .mapToObj(foldInstructions::get)
                .forEach(this::executeFoldInstructionOnAllDots);
    }

    private void executeFoldInstructionOnAllDots(FoldInstruction foldInstructionToExectute) {
        dots.forEach(dot -> dot.executeFoldInstruction(foldInstructionToExectute));
    }

    public long getAmountOfDots() {
        return dots.stream()
                .distinct()
                .count();
    }

    public void whatDoWeSee() {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 40; x++) {
                Optional<Dot> dot = findDotWithCoords(x, y);
                System.out.print(dot.map(d -> "#").orElse("."));
            }
            System.out.println();
        }
    }

    private Optional<Dot> findDotWithCoords(int x, int y) {
        return dots.stream()
                .filter(dot -> dot.getX() == x)
                .filter(dot -> dot.getY() == y)
                .findFirst();
    }
}
