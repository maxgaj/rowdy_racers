package be.maxgaj.cm.rowdyracers.domain.walls;

import be.maxgaj.cm.rowdyracers.domain.Grid;
import be.maxgaj.cm.rowdyracers.domain.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WallsGenerator {
    private static final double WALL_COVERAGE_RATIO = 0.2;
    private static final double WALL_LENGTH_RATIO = 0.5;
    private static final int MINIMAL_WALL_LENGTH = 2;
    private static final int MINIMAL_NUMBER_OF_WALL = 1;

    private final Grid grid;
    private final int maxLengthOfHorizontalWall;
    private final int maxLengthOfVerticalWall;
    private final int numberOfSquareToCover;
    private Random random = new Random();

    public WallsGenerator(Grid grid) {
        this.grid = grid;
        maxLengthOfHorizontalWall = (int) Math.ceil( grid.getNumberOfColumns() * WALL_LENGTH_RATIO );
        maxLengthOfVerticalWall = (int) Math.ceil( grid.getNumberOfRows() * WALL_LENGTH_RATIO );
        numberOfSquareToCover = getRandomNumberOfSquareToCover();
    }

    private int getRandomNumberOfSquareToCover() {
        int minNumberOfSquareToCover =  MINIMAL_NUMBER_OF_WALL * MINIMAL_WALL_LENGTH;
        int maxNumberOfSquareToCover = (int) Math.ceil(grid.getNumberOfColumns() * grid.getNumberOfRows() * WALL_COVERAGE_RATIO);
        return minNumberOfSquareToCover + random.nextInt(maxNumberOfSquareToCover - minNumberOfSquareToCover +1);
    }

    public List<Wall> generateRandomWalls(){
        List<Wall> walls = new ArrayList<>();
        int numberOfRemainingSquaresToCover = numberOfSquareToCover;
        while(numberOfRemainingSquaresToCover > 0){
            WallDirection randomDirection = getRandomWallDirection();
            int randomLength = getRandomLength(randomDirection);
            if (randomLength > numberOfRemainingSquaresToCover){
                randomLength = numberOfRemainingSquaresToCover;
            }
            Square randomStartingPosition = getSuitableStartingPosition(randomDirection, randomLength);
            walls.add(new Wall(randomDirection, randomLength, randomStartingPosition));
            numberOfRemainingSquaresToCover -= randomLength;
        }
        System.out.println("Square to covers : "+ numberOfSquareToCover);
        return walls;
    }

    private WallDirection getRandomWallDirection() {
        int wallDirectionsSize = WallDirection.values().length;
        int randomIndex = random.nextInt(wallDirectionsSize);
        return WallDirection.values()[randomIndex];
    }

    private int getRandomLength(WallDirection randomDirection) {
        if (randomDirection == WallDirection.HORIZONTAL){
            return getRandomLengthForHorizontalWall();
        }
        return getRandomLengthForVerticalWall();
    }

    private int getRandomLengthForVerticalWall() {
        return MINIMAL_WALL_LENGTH + random.nextInt(maxLengthOfVerticalWall - MINIMAL_WALL_LENGTH + 1);

    }

    private int getRandomLengthForHorizontalWall() {
        return MINIMAL_WALL_LENGTH + random.nextInt(maxLengthOfHorizontalWall - MINIMAL_WALL_LENGTH + 1);
    }

    private Square getSuitableStartingPosition(WallDirection direction, int length){
        if (direction == WallDirection.HORIZONTAL){
            return getSuitableStartingPositionForHorizontalWall(length);
        }
        return getSuitableStartingPositionForVerticalWall(length);
    }

    private Square getSuitableStartingPositionForHorizontalWall(int length) {
        int colIndex = random.nextInt(grid.getNumberOfColumns() - length + 1);
        int rowIndex = random.nextInt(grid.getNumberOfRows());
        if ((rowIndex == 0 && colIndex == 0) || rowIndex == grid.getNumberOfRows()-1 && colIndex >= grid.getNumberOfColumns() - length){
            return getSuitableStartingPositionForHorizontalWall(length);
        }
        return grid.getSquareAtPosition(rowIndex, colIndex);
    }

    private Square getSuitableStartingPositionForVerticalWall(int length) {
        int colIndex = random.nextInt(grid.getNumberOfColumns());
        int rowIndex = random.nextInt(grid.getNumberOfRows() - length + 1);
        if ((rowIndex == 0 && colIndex == 0) || colIndex == grid.getNumberOfColumns() - 1 && rowIndex >= grid.getNumberOfRows() - length){
            return getSuitableStartingPositionForVerticalWall(length);
        }
        return grid.getSquareAtPosition(rowIndex, colIndex);
    }
}
