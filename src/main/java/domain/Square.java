package domain;

public enum Square {
    PATH(true), FOREST(false), OUT_OF_BOUND(false);

    private final boolean crossable;

    private Square(boolean crossable){
        this.crossable = crossable;
    }

    public boolean isCrossable() {
        return crossable;
    }
}
