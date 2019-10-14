package be.maxgaj.cm.rowdyracers.domain.squares.square_generators;

import be.maxgaj.cm.rowdyracers.domain.squares.Square;
import static be.maxgaj.cm.rowdyracers.domain.grid.GridDirection.*;

public class SimpleSquareGenerator implements SquareGenerator {
    @Override
    public void generate(Square[][] squares) {
        int numberOfRows = squares.length;
        int numberOfColumns = squares[0].length;

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                Square newSquare = new Square(i, j);
                squares[i][j] = newSquare;
                setNeighbours(newSquare, squares);
            }
        }
    }

    private void setNeighbours(Square newSquare, Square[][] squares) {
        int rowIndex = newSquare.getRowIndex();
        int colIndex = newSquare.getColIndex();
        int numberOfColumns = squares.length;

        if (colIndex > 0) {
            newSquare.setNeighboursAt(WEST, squares[rowIndex][colIndex - 1]);
            squares[rowIndex][colIndex - 1].setNeighboursAt(EAST, newSquare);
        }
        if (rowIndex > 0) {
            newSquare.setNeighboursAt(NORTH, squares[rowIndex - 1][colIndex]);
            squares[rowIndex - 1][colIndex].setNeighboursAt(SOUTH, newSquare);
        }
        if (rowIndex > 0 && colIndex > 0) {
            newSquare.setNeighboursAt(NORTH_WEST, squares[rowIndex - 1][colIndex - 1]);
            squares[rowIndex - 1][colIndex - 1].setNeighboursAt(SOUTH_EAST, newSquare);
        }
        if (rowIndex > 0 && colIndex < numberOfColumns - 1) {
            newSquare.setNeighboursAt(NORTH_EAST, squares[rowIndex - 1][colIndex + 1]);
            squares[rowIndex - 1][colIndex + 1].setNeighboursAt(SOUTH_WEST, newSquare);
        }
    }
}
