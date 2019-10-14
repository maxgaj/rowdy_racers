package be.maxgaj.cm.rowdyracers.domain;

import be.maxgaj.cm.rowdyracers.domain.grid.Grid;
import be.maxgaj.cm.rowdyracers.domain.items.item_generators.LightGrenadeGenerator;
import be.maxgaj.cm.rowdyracers.domain.players.player_managers.PlayerManager;
import be.maxgaj.cm.rowdyracers.domain.players.player_managers.TwoPlayersManager;
import be.maxgaj.cm.rowdyracers.domain.squares.Square;
import be.maxgaj.cm.rowdyracers.domain.squares.square_generators.SimpleSquareGenerator;
import be.maxgaj.cm.rowdyracers.domain.walls.wall_generators.RandomWallGenerator;

public class Game {
    private PlayerManager playerManager;

    private Grid grid;

    public Game(int widthOfGrid, int heightOfGrid) {
        grid = new Grid(widthOfGrid, heightOfGrid, new SimpleSquareGenerator());
        playerManager = new TwoPlayersManager();
        playerManager.placePlayers(grid);
        grid.setWallGenerator(new RandomWallGenerator());
        grid.generateWalls();
        grid.setItemGenerator(new LightGrenadeGenerator());
        grid.generateItems();
    }


    public Square getSquareAtPosition(int rowId, int colId){
        return grid.getSquareAtPosition(rowId, colId);
    }


}
