package be.maxgaj.cm.rowdyracers.domain.grid;

import be.maxgaj.cm.rowdyracers.domain.items.item_generators.ItemGenerator;
import be.maxgaj.cm.rowdyracers.domain.squares.Square;
import be.maxgaj.cm.rowdyracers.domain.squares.square_generators.SquareGenerator;
import be.maxgaj.cm.rowdyracers.domain.walls.wall_generators.WallGenerator;

public class Grid {
    private int numberOfColumns;
    private int numberOfRows;
    private Square[][] squares;
    private WallGenerator wallGenerator;
    private ItemGenerator itemGenerator;


    public Grid(int widthOfGrid, int heightOfGrid, SquareGenerator squareGenerator) {
        numberOfColumns = widthOfGrid;
        numberOfRows = heightOfGrid;
        squares = new Square[heightOfGrid][widthOfGrid];
        squareGenerator.generate(squares);
    }


    public void setWallGenerator(WallGenerator wallGenerator) {
        this.wallGenerator = wallGenerator;
    }

    public void generateWalls() {
        this.wallGenerator.generate(squares);
    }


    public void setItemGenerator(ItemGenerator itemGenerator) {
        this.itemGenerator = itemGenerator;
    }

    public void generateItems() {
        this.itemGenerator.generate(squares);
    }


    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Square getSquareAtPosition(int rowId, int colId) {
        return squares[rowId][colId];
    }
}
