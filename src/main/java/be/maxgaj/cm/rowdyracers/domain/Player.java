package be.maxgaj.cm.rowdyracers.domain;

public class Player {
    private static int totalNumberOfPlayer;

    private final int playerNumber;
    private Square currentPosition;

    public Player() {
        this.playerNumber = ++totalNumberOfPlayer;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setCurrentPosition(Square square) {
        if (currentPosition != null){
            currentPosition.setPlayer(null);
        }
        this.currentPosition = square;
        square.setPlayer(this);
    }

    public boolean moveTo(AdjacentDirection direction) {
        Square newPosition = currentPosition.getAdjacentSquareAt(direction);
        if (newPosition == null){
            return false;
        }
        if (!newPosition.isReachableBy(this)){
            return false;
        }
        newPosition.setPlayer(this);
        currentPosition.setPlayer(null);
        currentPosition = newPosition;
        return true;
    }
}
