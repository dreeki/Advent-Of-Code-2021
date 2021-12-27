package day12;

import day12.CavePathing.ExtraTimeTree;
import day12.CavePathing.Tree;
import day12.cave.Cave;
import day12.cave.CaveFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CavePathingOrchestrator {
    private final List<String> inputLines;
    private final Map<String, Cave> cavesByName;
    private Tree caveTree;
    private Tree extraTimeCaveTree;

    public CavePathingOrchestrator() {
        inputLines = new ArrayList<>();
        cavesByName = new HashMap<>();
    }

    public void addInputLine(String input) {
        inputLines.add(input);
    }

    public void processInput() {
        createAllCaves();
        linkAllCaves();
        createTrees();
    }

    public int getAmountOfPathsToEnd() {
        return caveTree.findAmountOfPathsToEndByDFS();
    }

    public int getAmountOfPathsToEndWithExtraTime() {
        return extraTimeCaveTree.findAmountOfPathsToEndByDFS();
    }

    private void createAllCaves() {
        inputLines.stream()
                .flatMap(line -> Arrays.stream(line.split("-")))
                .forEach(this::createCave);
    }

    private void createCave(String name) {
        if (isNewCave(name)) {
            Cave cave = CaveFactory.makeCave(name);
            cavesByName.put(name, cave);
        }
    }

    private boolean isNewCave(String name) {
        return !cavesByName.containsKey(name);
    }

    private void linkAllCaves() {
        inputLines.forEach(this::linkCaves);
    }

    private void linkCaves(String inputLine) {
        String[] inputSplitted = inputLine.split("-");

        Cave caveLeft = cavesByName.get(inputSplitted[0]);
        Cave caveRight = cavesByName.get(inputSplitted[1]);

        caveLeft.link(caveRight);
    }

    private void createTrees() {
        Cave start = cavesByName.get("start");
        caveTree = new Tree(start);
        extraTimeCaveTree = new ExtraTimeTree(start);
    }

    public Map<String, Cave> getCavesByName() {
        return cavesByName;
    }
}
