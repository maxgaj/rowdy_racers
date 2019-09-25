package be.maxgaj.cm.rowdyracers.domain;

public class Game {
    private final static int NUMBER_OF_PLAYERS = 2;

    private Player[] players;
    private Player activePlayer;
    private int activePlayerActionsCount;
    private Grid grid;

    public Game(int widthOfGrid, int heightOfGrid) {
        this.players = new Player[NUMBER_OF_PLAYERS];
        this.grid = new Grid(widthOfGrid, heightOfGrid);
        createAndSetPlayers();
    }

    private void createAndSetPlayers() {
        for (int i=0; i<NUMBER_OF_PLAYERS; i++){
            players[i] = new Player();
        }
        activePlayer = players[0];
        players[0].setCurrentPosition(grid.getBottomLeftSquare());
        players[1].setCurrentPosition(grid.getTopRightSquare());
        setNextTurn();
    }

    private void setNextPlayer(){
        int indexOfNextPlayer = activePlayer.getPlayerNumber();
        if (indexOfNextPlayer == NUMBER_OF_PLAYERS){
            indexOfNextPlayer = 0;
        }
        activePlayer = players[indexOfNextPlayer];
        setNextTurn();
    }

    private void setNextTurn() {
        activePlayerActionsCount = 3;
    }

    public boolean moveTo(AdjacentDirection direction){
        if (activePlayer.moveTo(direction)){
            removeOneActionToActiveUser();
            return true;
        }
        return false;
    }

    public void endTurn(){
        setNextPlayer();
    }

    private void removeOneActionToActiveUser() {
        if (--activePlayerActionsCount == 0){
            setNextPlayer();
        }
    }

    public Square getSquareAtPosition(int rowId, int colId){
        return grid.getSquareAtPosition(rowId, colId);
    }

    public void printGrid(){
        grid.printGrid();
    }


}
