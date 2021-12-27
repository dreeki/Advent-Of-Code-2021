package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Simulation {
    private int currentDay;
    private final List<LanternFish> lanternFishes;
    private final List<ForeverLivingLanternFish> foreverLivingLanternFishes;

    public Simulation(String input) {
        currentDay = 0;
        lanternFishes = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(LanternFish::new)
                .collect(toList());
        foreverLivingLanternFishes = IntStream.rangeClosed(-1, 8)
                .mapToObj(ForeverLivingLanternFish::new)
                .collect(toList());
        lanternFishes.stream()
                .collect(groupingBy(LanternFish::getInternalTimer, counting()))
                .forEach((timer, amount) -> findForeverLivingLanterFishWithTimer(timer).setAmountOfFish(amount));
    }

    public int doSimulationOf80Days() {
        for (currentDay = 0; currentDay < 80; currentDay++) {
            List<Optional<LanternFish>> fishesToAdd = new ArrayList<>();
            processDayForAllFishes(fishesToAdd);
            addNewFishes(fishesToAdd);
        }
        return lanternFishes.size();
    }

    public Long doSimulationOf256Days() {
        for (currentDay = 0; currentDay < 256; currentDay++) {
            processDayForAllForeverLivingFishes();
            addNewForeverLivingFishes();
        }
        return foreverLivingLanternFishes.stream()
                .mapToLong(ForeverLivingLanternFish::getAmountOfFish)
                .sum();
    }

    private void addNewForeverLivingFishes() {
        ForeverLivingLanternFish fishesToReset = findForeverLivingLanterFishWithTimer(-1);
        ForeverLivingLanternFish resettedFishes = findForeverLivingLanterFishWithTimer(6);
        ForeverLivingLanternFish newBornFishes = findForeverLivingLanterFishWithTimer(8);

        resettedFishes.addAmountOfFish(fishesToReset.getAmountOfFish());
        newBornFishes.setAmountOfFish(fishesToReset.getAmountOfFish());
        fishesToReset.setAmountOfFish(0);
    }

    private void processDayForAllForeverLivingFishes() {
        for(int i = 1; i < foreverLivingLanternFishes.size(); i++) {
            foreverLivingLanternFishes.get(i - 1).setAmountOfFish(foreverLivingLanternFishes.get(i).getAmountOfFish());
        }
    }

    private void addNewFishes(List<Optional<LanternFish>> fishesToAdd) {
        lanternFishes.addAll(fishesToAdd.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList()));
    }

    private void processDayForAllFishes(List<Optional<LanternFish>> fishesToAdd) {
        lanternFishes.forEach(lanternFish -> {
            Optional<LanternFish> newFish = lanternFish.processDay();
            fishesToAdd.add(newFish);
        });
    }

    private ForeverLivingLanternFish findForeverLivingLanterFishWithTimer(int timer) {
        return foreverLivingLanternFishes.get(timer+1);
    }
}
