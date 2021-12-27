package day6;

import java.util.Objects;
import java.util.Optional;

public class LanternFish {
    private static final int NEW_FISH_TIMER = 8;

    private int internalTimer;

    public LanternFish(int internalTimer) {
        this.internalTimer = internalTimer;
    }

    public Optional<LanternFish> processDay() {
        internalTimer--;
        if(internalTimer < 0) {
            reset();
            return Optional.of(new LanternFish(NEW_FISH_TIMER));
        }
        return Optional.empty();
    }

    private void reset() {
        internalTimer = 6;
    }

    public int getInternalTimer() {
        return internalTimer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanternFish that = (LanternFish) o;
        return internalTimer == that.internalTimer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalTimer);
    }
}
