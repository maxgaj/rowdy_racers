package be.maxgaj.cm.rowdyracers.domain.players;

import be.maxgaj.cm.rowdyracers.domain.grid.GridDirection;
import be.maxgaj.cm.rowdyracers.domain.items.Usable;
import be.maxgaj.cm.rowdyracers.domain.players.inventories.Inventory;
import be.maxgaj.cm.rowdyracers.domain.players.inventories.SixSlotsInventory;
import be.maxgaj.cm.rowdyracers.domain.squares.Square;

public class Player {
    private static int totalNumberOfPlayer;

    private final int playerNumber;
    private Square currentPosition;
    private Square finishPosition;
    private Inventory inventory;

    public Player() {
        this.playerNumber = ++totalNumberOfPlayer;
        inventory = new SixSlotsInventory();
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

    public Square getCurrentPosition() {
        return currentPosition;
    }

    public void setFinishPosition(Square finishPosition) {
        this.finishPosition = finishPosition;
    }

    public boolean addToInvertory(Usable item){
        return inventory.addItem(item);
    }

    public boolean removeFromInvertory(Usable item){
        return inventory.removeItem(item);
    }
}
