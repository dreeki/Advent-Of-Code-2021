package day14;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toList;

public class Polymer {
    private final String template;
    private final Map<String, String> pairInsertionRules;
    private final Map<String, Pair> pairs;

    public Polymer(String template) {
        this.template = template;
        pairInsertionRules = new HashMap<>();
        pairs = new HashMap<>();
    }

    public void addPairInsertionRule(String pairInsertionRule) {
        String[] splitted = pairInsertionRule.split(" -> ");
        String pairValue = splitted[0];

        pairInsertionRules.put(pairValue, splitted[1]);
        pairs.put(pairValue, new Pair(pairValue));
    }

    public void initializePairs() {
        for (int i = 0; i < template.length() - 1; i++) {
            String pairValue = template.substring(i, i + 2);
            Pair pair = pairs.get(pairValue);
            pair.increaseAmount(1);
        }
    }

    public void doIterations(int amount) {
        IntStream.range(0, amount)
                .forEach(i -> doIteration());
    }

    public long getResult() {
        Character first = template.charAt(0);
        Character last = template.charAt(template.length() - 1);

        Map<Character, Long> amountOfOccurencesPerCharacter = pairs.values().stream()
                .map(Pair::getAmountPerCharacter)
                .flatMap(Collection::stream)
                .collect(groupingBy(Map.Entry::getKey, summingLong(Map.Entry::getValue)));

        amountOfOccurencesPerCharacter.put(first, amountOfOccurencesPerCharacter.get(first) + 1);
        amountOfOccurencesPerCharacter.put(last, amountOfOccurencesPerCharacter.get(last) + 1);

        List<Long> counts = amountOfOccurencesPerCharacter.values().stream()
                .map(i -> i/2)
                .sorted()
                .collect(toList());

        return Math.abs(counts.get(0) - counts.get(counts.size() - 1));
    }

    private void doIteration() {
        pairs.values().forEach(this::handlePair);
        pairs.values().forEach(Pair::finalizeIteration);
    }

    private void handlePair(Pair pair) {
        String toInsert = pairInsertionRules.get(pair.getValue());
        pair.getPairsValuesAfterInsertion(toInsert).stream()
                .map(pairs::get)
                .forEach(newPair -> newPair.increaseNewAmount(pair.getAmount()));
    }

    public Map<String, Pair> getPairs() {
        return pairs;
    }
}
