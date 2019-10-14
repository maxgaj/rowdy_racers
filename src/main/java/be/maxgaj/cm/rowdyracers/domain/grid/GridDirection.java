package be.maxgaj.cm.rowdyracers.domain.grid;

public enum GridDirection {
    NORTH(0),
    NORTH_EAST(1),
    EAST(2),
    SOUTH_EAST(3),
    SOUTH(4),
    SOUTH_WEST(5),
    WEST(6),
    NORTH_WEST(7);

    private int index;

    GridDirection(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
