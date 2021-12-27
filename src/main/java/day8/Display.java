package day8;

public class Display {
    private Segment top;
    private Segment topLeft;
    private Segment topRight;
    private Segment middle;
    private Segment bottom;
    private Segment bottomLeft;
    private Segment bottomRight;

    public Display() {
        top = dummySegment();
        topLeft = dummySegment();
        topRight = dummySegment();
        middle = dummySegment();
        bottom = dummySegment();
        bottomLeft = dummySegment();
        bottomRight = dummySegment();
    }

    public Segment getTop() {
        return top;
    }

    public void setTop(Segment top) {
        this.top = top;
    }

    public Segment getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Segment topLeft) {
        this.topLeft = topLeft;
    }

    public Segment getTopRight() {
        return topRight;
    }

    public void setTopRight(Segment topRight) {
        this.topRight = topRight;
    }

    public Segment getMiddle() {
        return middle;
    }

    public void setMiddle(Segment middle) {
        this.middle = middle;
    }

    public Segment getBottom() {
        return bottom;
    }

    public void setBottom(Segment bottom) {
        this.bottom = bottom;
    }

    public Segment getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Segment bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Segment getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Segment bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getNumber(Digit digit) {
        if(isZero(digit)){
            return 0;
        }
        if(isOne(digit)){
            return 1;
        }
        if(isTwo(digit)) {
            return 2;
        }
        if(isThree(digit)) {
            return 3;
        }
        if(isFour(digit)) {
            return 4;
        }
        if(isFive(digit)) {
            return 5;
        }
        if(isSix(digit)) {
            return 6;
        }
        if(isSeven(digit)) {
            return 7;
        }
        if(isEight(digit)) {
            return 8;
        }
        if(isNine(digit)) {
            return 9;
        }
        return -1;
    }

    private boolean isZero(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottom.getValue() == c);
    }

    private boolean isOne(Digit digit) {
        return digit.getSegments().stream().noneMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottom.getValue() == c);
    }

    private boolean isTwo(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottom.getValue() == c);
    }

    private boolean isThree(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottom.getValue() == c);
    }

    private boolean isFour(Digit digit) {
        return digit.getSegments().stream().noneMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottom.getValue() == c);
    }

    private boolean isFive(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottom.getValue() == c);
    }

    private boolean isSix(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottom.getValue() == c);
    }

    private boolean isSeven(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottom.getValue() == c);
    }

    private boolean isEight(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottom.getValue() == c);
    }

    private boolean isNine(Digit digit) {
        return digit.getSegments().stream().anyMatch(c -> top.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> topRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> middle.getValue() == c) &&
                digit.getSegments().stream().noneMatch(c -> bottomLeft.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottomRight.getValue() == c) &&
                digit.getSegments().stream().anyMatch(c -> bottom.getValue() == c);
    }

    private Segment dummySegment(){
        return new Segment('x');
    }
}
