package day13;

public class FoldInstruction {
    private final FoldingDirection direction;
    private final int position;

    public FoldInstruction(String input) {
        String inputEssentialPart = input.split(" ")[2];
        String[] instruction = inputEssentialPart.split("=");

        direction = FoldingDirection.findDirection(instruction[0]);
        position = Integer.parseInt(instruction[1]);
    }

    public FoldingDirection getDirection() {
        return direction;
    }

    public int getPosition() {
        return position;
    }
}
