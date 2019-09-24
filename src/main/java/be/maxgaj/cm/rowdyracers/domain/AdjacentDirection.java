package be.maxgaj.cm.rowdyracers.domain;

public enum AdjacentDirection {
    NORTH(0),
    NORTH_EAST(1),
    EAST(2),
    SOUTH_EAST(3),
    SOUTH(4),
    SOUTH_WEST(5),
    WEST(6),
    NORTH_WEST(7);

    private int index;

    AdjacentDirection(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
