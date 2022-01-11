package day14;

import java.util.List;
import java.util.Map;

public class Pair {
    private final String value;
    private long amount;
    private long newAmount;

    public Pair(String value) {
        this.value = value;
        this.amount = 0;
    }

    public void increaseAmount(long amount) {
        this.amount += amount;
    }

    public void increaseNewAmount(long amount) {
        this.newAmount += amount;
    }

    public void finalizeIteration() {
        this.amount = newAmount;
        newAmount = 0;
    }

    public List<String> getPairsValuesAfterInsertion(String toInsert) {
        String first = value.charAt(0) + toInsert;
        String second = toInsert + value.charAt(1);

        return List.of(first, second);
    }

    public List<Map.Entry<Character, Long>> getAmountPerCharacter() {
        return List.of(
                Map.entry(value.charAt(0), amount),
                Map.entry(value.charAt(1), amount)
        );
    }

    public String getValue() {
        return value;
    }

    public long getAmount() {
        return amount;
    }
}
