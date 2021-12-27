package day2;

public class ComplicatedSubmarine extends Submarine{
    private int aim;

    public ComplicatedSubmarine() {
        super();
        this.aim = 0;
    }

    public void move(Direction direction, int amount){
        int horizontalMove = direction.getHorizontalMultiplier() * amount;

        horizontal += horizontalMove;
        aim += direction.getVerticalMultiplier()*amount;
        depth += aim * horizontalMove;
    }

    public int getAim() {
        return aim;
    }
}
