package be.maxgaj.cm.rowdyracers.domain.squares;

import be.maxgaj.cm.rowdyracers.domain.grid.GridDirection;
import be.maxgaj.cm.rowdyracers.domain.items.Activable;
import be.maxgaj.cm.rowdyracers.domain.items.Pickable;
import be.maxgaj.cm.rowdyracers.domain.players.Player;

import java.util.EnumMap;

public class Square {
    private EnumMap<GridDirection, Square> neighbours;
    private int rowIndex;
    private int colIndex;
    private Player player;
    private boolean wall = false;
    private Pickable item;
    private Activable activableItem;


    public Square(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        neighbours = new EnumMap<>(GridDirection.class);
    }


    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }


    public boolean hasPlayer() {
        return player != null;
    }

    public Player getPlayer() { return player; }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPlayerNumber() {
        if (!hasPlayer()){
            return -1;
        }
        return player.getPlayerNumber();
    }


    public boolean hasNeighbourAt(GridDirection gridDirection){
        return neighbours.containsKey(gridDirection);
    }

    public Square getNeighbourAt(GridDirection gridDirection){
        return neighbours.get(gridDirection);
    }

    public void setNeighboursAt(GridDirection gridDirection, Square neighbour){
        neighbours.put(gridDirection, neighbour);
    }


    public void setWall(boolean hasWall) {
        wall = hasWall;
    }

    public boolean hasWall(){
        return wall;
    }

    public boolean isSuitableForAWall() {
        if (neighbours.containsKey(GridDirection.NORTH) && neighbours.get(GridDirection.NORTH).hasWall()
                || neighbours.containsKey(GridDirection.EAST) && neighbours.get(GridDirection.EAST).hasWall()
                || neighbours.containsKey(GridDirection.SOUTH) && neighbours.get(GridDirection.SOUTH).hasWall()
                || neighbours.containsKey(GridDirection.WEST) && neighbours.get(GridDirection.WEST).hasWall()
        ) {
            return false;
        }
        return !hasPlayer() && !hasWall();
    }


    public boolean hasItem(){
        return item != null;
    }

    public void setItem(Pickable item){
        this.item = item;
    }

    public Pickable removeItem() {
        Pickable itemToReturn = item;
        item = null;
        return itemToReturn;
    }


    public boolean hasActivableItem(){
        return activableItem != null;
    }

    public void setActivableItem(Activable item){
        this.activableItem = item;
    }

    public Activable removeActivableItem() {
        Activable itemToReturn = activableItem;
        activableItem = null;
        return itemToReturn;
    }

    public boolean isSuitableForAGrenade() {
        return !hasItem() && !hasPlayer() && !hasWall();
    }
}
