package day1;

import java.util.ArrayList;
import java.util.List;

public class DepthProcessor {
    private final List<Integer> depths;

    public DepthProcessor() {
        this.depths = new ArrayList<>();
    }

    public void addDepthNumber(int val) {
        depths.add(val);
    }

    public int calculateAmountOfIncreases() {
        int result = 0;
        for(int i = 1; i < depths.size(); i++){
            if(isAnIncrease(i)){
                result++;
            }
        }
        return result;
    }

    public int calculateAmountOfWindowIncreases() {
        int result = 0;
        for(int i = 3; i < depths.size(); i++){
            if(isAWindowIncrease(i)){
                result++;
            }
        }
        return result;
    }

    private boolean isAnIncrease(int i) {
        return depths.get(i-1) < depths.get(i);
    }

    private boolean isAWindowIncrease(int i) {
        return depths.get(i-3) < depths.get(i);
    }
}
