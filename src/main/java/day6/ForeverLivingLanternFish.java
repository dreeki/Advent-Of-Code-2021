package day6;

public class ForeverLivingLanternFish {
    private final int internalTimer;
    private long amountOfFish;

    public ForeverLivingLanternFish(int internalTimer) {
        this.internalTimer = internalTimer;
        amountOfFish = 0;
    }

    public void setAmountOfFish(long amountOfFish) {
        this.amountOfFish = amountOfFish;
    }

    public void addAmountOfFish(long amountOfFish) {
        this.amountOfFish += amountOfFish;
    }

    public int getInternalTimer() {
        return internalTimer;
    }

    public long getAmountOfFish() {
        return amountOfFish;
    }
}
