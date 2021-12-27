package day11;

public class Octopus {
    private boolean dummyOctopus;

    private int energyLevel;
    private boolean didFlash;
    private int amountOfFlashes;

    public Octopus(int energyLevel) {
        this.energyLevel = energyLevel;
        didFlash = false;
        amountOfFlashes = 0;
        dummyOctopus = false;
    }

    public static Octopus aDummyOctopus() {
        Octopus dummy = new Octopus(-1);
        dummy.dummyOctopus = true;

        return dummy;
    }

    public void incrementEnergyLevel() {
        if(!didFlash) {
            energyLevel++;
        }
    }

    public void resetDidFlash() {
        didFlash = false;
    }

    public boolean mustFlash() {
        if(dummyOctopus) {
            return false;
        }
        return energyLevel > 9;
    }

    public void flash() {
        if(energyLevel <= 9) {
            throw new IllegalStateException("this should not happen");
        }
        energyLevel = 0;
        didFlash = true;
        amountOfFlashes++;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public boolean isDidFlash() {
        return didFlash;
    }

    public int getAmountOfFlashes() {
        return amountOfFlashes;
    }

    public boolean isNotADummy() {
        return !dummyOctopus;
    }
}
