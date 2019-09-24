package be.maxgaj.cm.rowdyracers.domain;

import be.maxgaj.cm.rowdyracers.domain.walls.Wall;
import be.maxgaj.cm.rowdyracers.domain.walls.WallsGenerator;

import java.util.List;
import java.util.Random;

public class Grid {
    private int numberOfColumns;
    private int numberOfRows;
    private Square[][] squares;

    public Grid(int widthOfGrid, int heightOfGrid) {
        numberOfColumns = widthOfGrid;
        numberOfRows = heightOfGrid;
        squares = new Square[heightOfGrid][widthOfGrid];
        initializeAllSquares();
        initializeAllWalls();
    }


    private void initializeAllSquares() {
        for (int i=0; i<numberOfRows; i++){
            for (int j=0; j<numberOfColumns; j++){
                Square newSquare = new Square(i, j);
                squares[i][j] = newSquare;
                setAdjacentSquares(newSquare, i, j);
            }
        }
    }

    private void setAdjacentSquares(Square newSquare, int i, int j) {
        if (j>0){
            newSquare.setAdjacentSquareAt(AdjacentDirection.WEST, squares[i][j-1]);
            squares[i][j-1].setAdjacentSquareAt(AdjacentDirection.EAST, newSquare);
        }
        if (i>0){
            newSquare.setAdjacentSquareAt(AdjacentDirection.NORTH, squares[i-1][j]);
            squares[i-1][j].setAdjacentSquareAt(AdjacentDirection.SOUTH, newSquare);
        }
        if (i>0 && j>0){
            newSquare.setAdjacentSquareAt(AdjacentDirection.NORTH_WEST, squares[i-1][j-1]);
            squares[i-1][j-1].setAdjacentSquareAt(AdjacentDirection.SOUTH_EAST, newSquare);
        }
        if (i>0 && j<numberOfColumns-1){
            newSquare.setAdjacentSquareAt(AdjacentDirection.NORTH_EAST, squares[i-1][j+1]);
            squares[i-1][j+1].setAdjacentSquareAt(AdjacentDirection.SOUTH_WEST, newSquare);
        }
    }


    private void initializeAllWalls() {
        WallsGenerator wallsGenerator = new WallsGenerator(this);
        List<Wall> walls = wallsGenerator.generateRandomWalls();
    }

//    public void printGrid(){
//        for (Square[] row: squares) {
//            for (Square square : row){
//                System.out.print(square);
//            }
//            System.out.println("");
//        }
//    }


    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Square getSquareAtPosition(int rowId, int colId){
        return squares[rowId][colId];
    }

    public Square getBottomLeftSquare(){
        return getSquareAtPosition(numberOfRows-1, 0);
    }

    public Square getTopRightSquare(){
        return getSquareAtPosition(0, numberOfColumns-1);
    }

    private Square getRandomSquare(){
        Random rand = new Random();
        int randomRowId = rand.nextInt(numberOfRows);
        int randomColId = rand.nextInt(numberOfColumns);
        return getSquareAtPosition(randomRowId, randomColId);
    }

    private Square getRandomSquareExceptPlayersStartingPoint(){
        Square randomSquare = getRandomSquare();
        if (randomSquare == getBottomLeftSquare() || randomSquare == getTopRightSquare()){
            return getRandomSquareExceptPlayersStartingPoint();
        }
        return randomSquare;
    }
}
