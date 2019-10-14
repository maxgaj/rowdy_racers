package be.maxgaj.cm.rowdyracers.domain.items.item_generators;

import be.maxgaj.cm.rowdyracers.domain.squares.Square;

public interface ItemGenerator {
    void generate(Square[][] squares);
}
