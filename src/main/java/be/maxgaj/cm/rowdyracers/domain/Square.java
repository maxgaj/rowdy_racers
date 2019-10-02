package be.maxgaj.cm.rowdyracers.domain;

import be.maxgaj.cm.rowdyracers.domain.walls.Wall;

import java.util.Arrays;

public class Square {
    private static int NUMBER_OF_ADJACENT_SQUARES = 8;

    private Player player;
    private Square[] adjacentSquares;
    private Wall wall;

    private int rowIndex;

    private int colIndex;
    public Square(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        adjacentSquares = new Square[NUMBER_OF_ADJACENT_SQUARES];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isReachableBy(Player player) {
        if (player != null){
            return false;
        }
        return true;
    }

    public Square getAdjacentSquareAt(AdjacentDirection direction) {
        return adjacentSquares[direction.getIndex()];
    }

    public void setAdjacentSquareAt(AdjacentDirection direction, Square adjacentSquare){
        adjacentSquares[direction.getIndex()] = adjacentSquare;
    }

    public void setWall(Wall wall) {
        if (player == null){
            this.wall = wall;
        }
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public boolean hasWall(){
        return wall != null;
    }

    @Override
    public String toString() {
        if (wall == null){
            return "[ ] ";
        }
        return "[X] ";
    }

    public boolean hasPlayer() {
        return player != null;
    }

    public int getPlayerNumber() {
        return player.getPlayerNumber();
    }
}
