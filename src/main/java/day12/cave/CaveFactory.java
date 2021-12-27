package day12.cave;

public class CaveFactory {

    public static Cave makeCave(String name) {
        if(isBigCave(name)) {
            return new BigCave(name);
        }else {
            return new SmallCave(name);
        }
    }

    private static boolean isBigCave(String name) {
        return name.equals(name.toUpperCase());
    }
}
