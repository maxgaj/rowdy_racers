package be.maxgaj.cm.rowdyracers.domain.walls;

import be.maxgaj.cm.rowdyracers.domain.AdjacentDirection;
import be.maxgaj.cm.rowdyracers.domain.Square;

public class Wall {
    private Square startingPosition;
    private WallDirection direction;
    private int length;

    public Wall(WallDirection direction, int length, Square startingPosition) {
        this.direction = direction;
        this.length = length;
        setWallStartingPosition(startingPosition);
    }


    public void setWallStartingPosition(Square startingPosition) {
        this.startingPosition = startingPosition;
        startingPosition.setWall(this);
        Square positionToSet = startingPosition;
        for (int i=1; i<length; i++){
            if (direction == WallDirection.HORIZONTAL){
                positionToSet = positionToSet.getAdjacentSquareAt(AdjacentDirection.EAST);
            } else {
                positionToSet = positionToSet.getAdjacentSquareAt(AdjacentDirection.SOUTH);
            }
            if (positionToSet == null){
                break;
            }
            positionToSet.setWall(this);
        }

    }

}
