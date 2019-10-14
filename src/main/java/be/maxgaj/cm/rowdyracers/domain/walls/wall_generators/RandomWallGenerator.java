package be.maxgaj.cm.rowdyracers.domain.walls.wall_generators;


import be.maxgaj.cm.rowdyracers.domain.grid.GridDirection;
import be.maxgaj.cm.rowdyracers.domain.squares.Square;

import java.util.Random;

public class RandomWallGenerator implements WallGenerator {
    private static final int MIN_NUMBER_OF_WALL = 1;
    private static final int MIN_LENGTH_OF_WALL = 2;
    private static final double MAX_LENGTH_RATIO = 0.5;
    private static final double MAX_COVERAGE_RATIO = 0.2;
    private static final GridDirection[] AVAILABLE_DIRECTION = {GridDirection.NORTH, GridDirection.EAST, GridDirection.SOUTH, GridDirection.WEST};

    private Square[][] squares;
    private int height;
    private int width;
    private Random random = new Random();


    @Override
    public void generate(Square[][] squares) {
        setSquares(squares);
        int coverage = getRandomCoverage();
        while (coverage >= MIN_LENGTH_OF_WALL) {
            int lengthCreated = createWall();
            coverage -= lengthCreated;
        }
    }

    private void setSquares(Square[][] squares) {
        this.squares = squares;
        this.height = squares.length;
        this.width = squares[0].length;
    }

    private int getRandomCoverage() {
        int minCoverage = MIN_NUMBER_OF_WALL * MIN_LENGTH_OF_WALL;
        int maxCoverage = (int) Math.ceil((height * width) * MAX_COVERAGE_RATIO);
        return random.nextInt(maxCoverage - minCoverage + 1) + minCoverage;
    }

    private int createWall() {
        Square startingSquare = getRandomSquare();
        GridDirection direction = getRandomDirection();
        int availableLengthInThatDirection = getAvailableLengthInDirection(startingSquare, direction);
        int maxLengthInThatDirection = getMaxLengthInDirection(direction);
        if (availableLengthInThatDirection < MIN_LENGTH_OF_WALL) {
            return 0;
        }
        int randomLength = MIN_LENGTH_OF_WALL + random.nextInt(Math.min(availableLengthInThatDirection, maxLengthInThatDirection) - MIN_LENGTH_OF_WALL + 1);
        placeWall(startingSquare, direction, randomLength);
        return randomLength;
    }

    private void placeWall(Square square, GridDirection direction, int length) {
        square.setWall(true);
        if (length > 1) {
            placeWall(square.getNeighbourAt(direction), direction, length - 1);
        }
    }

    private Square getRandomSquare() {
        int rowId = random.nextInt(height);
        int colId = random.nextInt(width);
        return squares[rowId][colId];
    }

    private GridDirection getRandomDirection() {
        return AVAILABLE_DIRECTION[random.nextInt(AVAILABLE_DIRECTION.length)];
    }

    private int getAvailableLengthInDirection(Square square, GridDirection direction) {
        if (!square.isSuitableForAWall()) {
            return 0;
        }
        if (!square.hasNeighbourAt(direction)) {
            return 1;
        }
        return 1 + getAvailableLengthInDirection(square.getNeighbourAt(direction), direction);
    }

    private int getMaxLengthInDirection(GridDirection direction) {
        if (direction == GridDirection.NORTH || direction == GridDirection.SOUTH) {
            return (int) Math.ceil(width * MAX_LENGTH_RATIO);
        }
        return (int) Math.ceil(height * MAX_LENGTH_RATIO);
    }
}
