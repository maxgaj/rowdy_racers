package be.maxgaj.cm.rowdyracers.domain.walls.wall_generators;

import be.maxgaj.cm.rowdyracers.domain.squares.Square;

public interface WallGenerator {
    void generate(Square[][] squares);
}
